package com.website.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.website.common.dao.BaseDao;
import com.website.system.model.Permission;

@Repository
public interface PermissionMapper extends BaseDao<Permission> {

	/***
	 * 主键查询
	 * @param id
	 * @return
	 */
	@SelectProvider(type=PermissionSqlProvider.class,method="findById")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	Permission findById(@Param(value="id") String id); 
	
	/***
	 * 查询所有集合
	 * @return
	 */
	@SelectProvider(type=PermissionSqlProvider.class,method="selectList")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	java.util.List<Permission> selectList(); 
	
	/***
	 * 条件查询
	 * @param sqlWhereMap
	 * @return
	 */
	@SelectProvider(type=PermissionSqlProvider.class,method="selectListParam")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	java.util.List<Permission> selectListParam(@Param(value="sqlWhereMap") Map<String,Object> sqlWhereMap);
	
	/***
	 * 默认分页查询
	 * @param rowBounds
	 * @return
	 */
	@SelectProvider(type=PermissionSqlProvider.class,method="selectListPage")
	java.util.List<Permission> selectListPage(@Param(value="rowBounds") RowBounds rowBounds);
   
    /***
    * 带条件分页查询
    * @param paramMap
    * @param rowBounds
    * @return
    */
	@SelectProvider(type=PermissionSqlProvider.class,method="selectListPageParam")
	java.util.List<Permission> selectListPageParam(@Param(value="sqlWhereMap") Map<String,Object> paramMap, @Param(value="rowBounds") RowBounds rowBounds);

	/***
	 * 根据角色Id获取角色权限信息
	 * @param roleId
	 * @return
	 */
	@SelectProvider(type=PermissionSqlProvider.class,method="selectListPermission")
	List<Permission> selectListPermission(@Param(value="roleId") String roleId);

}
