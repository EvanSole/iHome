package com.website.system.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INNER_JOIN;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.sql.SQLException;
import java.util.Map;

import com.website.common.model.BaseModel;
import com.website.system.model.Permission;

/***
 * 本类作为CRUDTemplate的辅助类，主要提供对象相应的查询方法SQL语句集，也可自定义
 * 使用Mybatis注解作为SQL构造器，通过J2ee注解来获取对象对应的字段
 * 
 * @author Administrator
 *
 * @see com.website.common.dao.CRUDTemplate
 */
public class PermissionSqlProvider {

	
	public static String findById(Map<String, Object> paramMap) {

		String idname = (String) paramMap.get("id");

		BEGIN();

		SELECT(Permission.COLUMNS);

		FROM(Permission.TABLE_NAME);

		WHERE("id" + "='" + idname + "'");

		return SQL();

	}
	
	public static String selectList(){

		BEGIN();

		SELECT(Permission.COLUMNS);

		FROM(Permission.TABLE_NAME);

		return SQL();
	}
	
	/***
	 * 分页查询使用mybatis分页拦截器对SQL语句集进行拦截处理
	 * 
	 * @return
	 * 
	 * @see com.website.common.util.page.PageInterceptor
	 */
	public static String selectListPage(){

		BEGIN();

		SELECT(Permission.COLUMNS);

		FROM(Permission.TABLE_NAME);

		return SQL();
	}
	
	
	/***
	 * 条件查询集合
	 * @param paramMap
	 * @return
	 * @throws SQLException
	 */
	public static String selectListParam(Map<String, Object> paramMap) throws SQLException{
	   
		@SuppressWarnings("unchecked")
		java.util.Map<String,Object> sqlWhereMap =  (Map<String, Object>) (paramMap.get("sqlWhereMap")==null ? "": paramMap.get("sqlWhereMap"));
		
		BEGIN();
		
		SELECT(Permission.COLUMNS);

		FROM(Permission.TABLE_NAME);
		
		if (sqlWhereMap != null && !"".equals(sqlWhereMap)) {  
		   //拼接查询条件	
           WHERE(BaseModel.getSqlWhereWithValues(sqlWhereMap));
        } 
		return SQL();
		
	}
	
	/***
	 * 条件分页查询使用mybatis分页拦截器对SQL语句集进行拦截处理
	 * @param paramMap
	 * @return
	 * @throws SQLException
	 * 
	 * @see com.website.common.util.page.PageInterceptor
	 */
	public static String selectListPageParam(Map<String, Object> paramMap) throws SQLException{
		   
		@SuppressWarnings("unchecked")
		java.util.Map<String,Object> sqlWhereMap =  (Map<String, Object>) (paramMap.get("sqlWhereMap")==null ? "": paramMap.get("sqlWhereMap"));
		
		BEGIN();
		
		SELECT(Permission.COLUMNS);

		FROM(Permission.TABLE_NAME);
		
		if (sqlWhereMap != null && !"".equals(sqlWhereMap)) {  
		   //拼接查询条件	
           WHERE(BaseModel.getSqlWhereWithValues(sqlWhereMap));
        } 
		return SQL();
	}
	
	
	/***
	 * 获取用户角色信息
	 * @param paramMap
	 * @return
	 * @throws SQLException
	 */
	public static String selectListPermission(Map<String, Object> paramMap) throws SQLException{
		
	    String roleId = paramMap.get("roleId")==null ? "": (String)paramMap.get("roleId");
		
		BEGIN();
		
		SELECT("sys_permission.id,sys_permission.permissionName");
		
		FROM("sys_permission");

		INNER_JOIN(" sys_role_permission on sys_permission.id = sys_role_permission.permissionId ");
		
		WHERE(" sys_role_permission.roleId " + "='" + roleId + "'");
		
		return SQL();
	}
	
}
