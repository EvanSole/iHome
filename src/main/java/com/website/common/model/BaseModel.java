
package com.website.common.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

import com.website.common.exception.BaseException;
import com.website.common.util.ListUtil;
import com.website.common.util.StringPool;

/****
 * 
 * MyBatis用POJO基类
 * 
 * @author Evan
 * 
 * getFields()获得某个类的所有的公共（public）的字段，包括父类。 
 * getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，
 * 但是不包括父类的申明字段。
 * 
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 获取POJO对应的表名 需要POJO中的属性定义@Table(name)
	 * 
	 * @return
	 */
	public String tablename() {
		Table table = this.getClass().getAnnotation(Table.class);
		if (table != null)
			return table.name();
		else
			throw new BaseException(
					"undefine POJO @Table, need Tablename(@Table(name))");
	}

	/**
	 * 获取POJO对应的表名 需要POJO中的属性定义@Table(name)
	 * 
	 * @return
	 */
	public static String tablename(Class<? extends BaseModel> clazz) {
		Table table = clazz.getAnnotation(Table.class);
		if (table != null)
			return table.name();
		else
			throw new BaseException(
					"undefine POJO @Table, need Tablename(@Table(name))");
	}

	/**
	 * 获取POJO中的主键字段名 需要定义@Id
	 * 
	 * @return
	 */
	public String id(Class<? extends BaseModel> clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Id.class))
				return field.getName();
		}
		throw new RuntimeException("undefine POJO @Id");
	}

	/**
	 * 获取POJO中的主键字段名 需要定义@Id
	 * 
	 * @return
	 */
	public String id() {
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Id.class))
				return field.getName();
		}

		throw new RuntimeException("undefine POJO @Id");
	}

	/**
	 * 用于存放POJO的列信息
	 */
	private transient static Map<Class<? extends BaseModel>, List<String>> columnMap = new HashMap<Class<? extends BaseModel>, List<String>>();

	private boolean isNull(String fieldname) {
		try {
			Field field = this.getClass().getDeclaredField(fieldname);
			return isNull(field);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return false;
	}

	private boolean isNull(Field field) {
		try {
			field.setAccessible(true);
			return field.get(this) == null;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 用于计算类定义 需要POJO中的属性定义@Column(name)
	 */
	public void caculationColumnList() {
		if (columnMap.containsKey(this.getClass()))
			return;

		Field[] fields = this.getClass().getDeclaredFields();
		List<String> columnList = new ArrayList<String>(fields.length);

		for (Field field : fields) {
			 if (field.isAnnotationPresent(Column.class) || field.isAnnotationPresent(Id.class))
				columnList.add(field.getName());
			  //columnList.add(field.getAnnotation(Column.class).name());
		}

		columnMap.put(this.getClass(), columnList);
	}

	/**
	 * 用于计算类定义 需要POJO中的属性定义@Column(name)
	 */
	public static String caculationColumnList(Class<? extends BaseModel> clazz) {

		Field[] fields = clazz.getDeclaredFields();
		List<String> columnList = new ArrayList<String>(fields.length);

		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class) || field.isAnnotationPresent(Id.class) ){
				columnList.add(field.getName());
				//columnList.add(field.getAnnotation(Column.class).name());
			}
		}
		
		String builderString = ListUtil.toString(columnList, StringPool.COMMA);
        //删除最后一个逗号 (",")
		if (StringPool.COMMA.equals(builderString.lastIndexOf(StringPool.COMMA)))
			builderString = builderString.substring(0,builderString.length() - 1);

		return builderString;
	}

	/**
	 * 获取用于WHERE的 有值字段表
	 * 
	 * @return
	 */
	public List<WhereColumn> returnWhereColumnsName(Class<? extends BaseModel> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<WhereColumn> columnList = new ArrayList<WhereColumn>(fields.length);

		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class) && !isNull(field))
				columnList.add(new WhereColumn(field.getName(), field
						.getGenericType().equals(String.class)));
		}

		return columnList;
	}

	/**
	 * 获取用于WHERE的 有值字段表
	 * 
	 * @return
	 */
	public List<WhereColumn> returnWhereColumnsName() {
		Field[] fields = this.getClass().getDeclaredFields();
		List<WhereColumn> columnList = new ArrayList<WhereColumn>(fields.length);

		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class) && !isNull(field))
				columnList.add(new WhereColumn(field.getName(), field
						.getGenericType().equals(String.class)));
		}

		return columnList;
	}

	/**
	 * Where条件信息
	 * 
	 * @author HUYAO
	 * 
	 */
	public class WhereColumn {
		public String name;
		public boolean isString;

		public WhereColumn(String name, boolean isString) {
			this.name = name;
			this.isString = isString;
		}
	}

	/**
	 * 用于获取Insert的字段累加
	 * 
	 * @return
	 */
	public String returnInsertColumnsName() {
		StringBuilder sb = new StringBuilder();

		List<String> list = columnMap.get(this.getClass());
		int i = 0;
		for (String column : list) {
			if (isNull(column))
				continue;

			if (i++ != 0)
				sb.append(',');
			sb.append(column);
		}
		return sb.toString();
	}

	/**
	 * 用于获取Insert的字段映射累加
	 * 
	 * @return
	 */
	public String returnInsertColumnsDefine() {
		StringBuilder sb = new StringBuilder();

		List<String> list = columnMap.get(this.getClass());
		int i = 0;
		for (String column : list) {
			if (isNull(column))
				continue;

			if (i++ != 0)
				sb.append(',');
			sb.append("#{").append(column).append('}');
		}
		return sb.toString();
	}

	/**
	 * 用于获取Update Set的字段累加
	 * 
	 * @return
	 */
	public String returnUpdateSet() {
		StringBuilder sb = new StringBuilder();

		List<String> list = columnMap.get(this.getClass());
		int i = 0;
		for (String column : list) {
			if (isNull(column))
				continue;

			if (i++ != 0)
				sb.append(',');
			sb.append(column).append("=#{").append(column).append('}');
		}
		return sb.toString();
	}

	/**
	 * 转化POJO为JSON格式
	 * 
	 * @return
	 */
	public String toJSONString() {
		JSONObject json = new JSONObject(this);
		return json.toString();
	}

	/**
	 * 打印执行SQL语句信息
	 */
	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (Field f : fields) {
			if (Modifier.isStatic(f.getModifiers())
					|| Modifier.isFinal(f.getModifiers()))
				continue;
			Object value = null;
			try {
				f.setAccessible(true);
				value = f.get(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if (value != null)
				sb.append(f.getName()).append('=').append(value).append(',');
		}
		sb.append(']');

		return sb.toString();
	}

	/**
	 * 根据条件，返回sql条件和条件中占位符的值
	 * 使用占位符
	 * 
	 * @param sqlWhereMap
	 *            key：字段名 value：字段值
	 * @return 第一个元素为SQL条件，第二个元素为SQL条件中占位符的值
	 * Simple: select column_1,column_2,column_3 from Tabel where (column_1 = ? AND column_2 = ?)  
	 */
	public static List<Object> getSqlWhereWithKeys(Map<String, Object> sqlWhereMap) throws SQLException {
		if (sqlWhereMap.size() < 1)
			return null;

		List<Object> list = new ArrayList<Object>();
		List<Object> fieldValues = new ArrayList<Object>();//占位符对应的值
		StringBuffer sqlWhere = new StringBuffer();//SQL语句

		Set<Entry<String, Object>> entrySets = sqlWhereMap.entrySet();

		for (Iterator<Entry<String, Object>> iteraotr = entrySets.iterator(); iteraotr.hasNext();) {

			Entry<String, Object> entrySet = iteraotr.next();

			fieldValues.add(entrySet.getValue());

			Object value = entrySet.getValue();
			if (value.getClass() == String.class) {
				sqlWhere.append(entrySet.getKey()).append(" like ").append("?").append(" and ");
			}else if(value.getClass() == Date.class){
				sqlWhere.append(entrySet.getKey()).append(" = ").append(StringPool.APOSTROPHE +  entrySet.getValue()  + StringPool.APOSTROPHE).append(" and ");
			} else {
				sqlWhere.append(entrySet.getKey()).append(" = ").append("?").append(" and ");
			}
		}
		sqlWhere.delete(sqlWhere.lastIndexOf("and"), sqlWhere.length());
		list.add(sqlWhere.toString());
		list.add(fieldValues);
		return list;
	}
	
	/**
	 * 根据条件，返回sql条件和条件中的值
	 * 不使用占位符
	 * 
	 * @param sqlWhereMap key：字段名 value：字段值
	 * @return
	 * Simple: select column_1,column_2,column_3 from Tabel where (column_1 = 'A' AND column_2 = 'B') 
	 */
	public static String getSqlWhereWithValues(Map<String, Object> sqlWhereMap) throws SQLException {
		if (sqlWhereMap.size() < 1)
			return null;

		StringBuffer sqlWhere = new StringBuffer();//SQL语句

		Set<Entry<String, Object>> entrySets = sqlWhereMap.entrySet();

		for (Iterator<Entry<String, Object>> iteraotr = entrySets.iterator(); iteraotr.hasNext();) {

			Entry<String, Object> entrySet = iteraotr.next();

			Object value = entrySet.getValue();
			if (value.getClass() == String.class) {
				sqlWhere.append(entrySet.getKey()).append(" like ").append(StringPool.APOSTROPHE+entrySet.getValue()+StringPool.APOSTROPHE).append(" and ");
			}else if(value.getClass() == Date.class){
				sqlWhere.append(entrySet.getKey()).append(" = ").append(StringPool.APOSTROPHE +  entrySet.getValue()  + StringPool.APOSTROPHE).append(" and ");
			}
			else {
				sqlWhere.append(entrySet.getKey()).append(" = ").append(entrySet.getValue()).append(" and ");
			}
		}
		sqlWhere.delete(sqlWhere.lastIndexOf("and"), sqlWhere.length());
		
		return sqlWhere.toString();
	}
	
}
