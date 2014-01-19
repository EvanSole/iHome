package com.website.common.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.website.common.model.BaseModel;

/***
 * 公共SQL拼接类，该类只返回组装好的SQL语句，无其他业务
 * @MethodName insert , update , delete
 * @ClassName: CRUDTemplate 
 * @Description: TODO
 * @author 
 * 
 * 使用Mybatis注解作为SQL构造器，通过J2ee注解来获取对象对应的字段
 * 
 * @param <T>
 */
public class CRUDTemplate<T extends BaseModel> {

	public String insert(T obj) {

		BEGIN(); // Clears ThreadLocal variable

		INSERT_INTO(obj.tablename());
		obj.caculationColumnList();
		VALUES(obj.returnInsertColumnsName(), obj.returnInsertColumnsDefine());

		return SQL();
	}

	public String update(T obj) {
		
		String idname = obj.id();

		BEGIN();

		UPDATE(obj.tablename());
		obj.caculationColumnList();
		SET(obj.returnUpdateSet());
		WHERE(idname + "=#{" + idname + "}");  

		return SQL();
	}

	public String delete(T obj) {
		String idname = obj.id();

		BEGIN();

		DELETE_FROM(obj.tablename());
		
		WHERE(idname + "=#{" + idname + "}");  

		return SQL();
	}
	
}