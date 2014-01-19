package com.website.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.website.common.dao.BaseDao;
import com.website.system.model.Role;

@Repository
public interface RoleMapper extends BaseDao<Role> {

	/***
	 * 主键查询
	 * @param id
	 * @return
	 */
	@SelectProvider(type=RoleSqlProvider.class,method="findById")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	Role findById(@Param(value="id") String id); 
	
	/***
	 * 查询所有集合
	 * @return
	 */
	@SelectProvider(type=RoleSqlProvider.class,method="selectList")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	java.util.List<Role> selectList(); 
	
	/***
	 * 条件查询
	 * @param sqlWhereMap
	 * @return
	 */
	@SelectProvider(type=RoleSqlProvider.class,method="selectListParam")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	java.util.List<Role> selectListParam(@Param(value="sqlWhereMap") Map<String,Object> sqlWhereMap);
	
	/***
	 * 默认分页查询
	 * @param rowBounds
	 * @return
	 */
	@SelectProvider(type=RoleSqlProvider.class,method="selectListPage")
	java.util.List<Role> selectListPage(@Param(value="rowBounds") RowBounds rowBounds);
   
    /***
    * 带条件分页查询
    * @param paramMap
    * @param rowBounds
    * @return
    */
	@SelectProvider(type=RoleSqlProvider.class,method="selectListPageParam")
	java.util.List<Role> selectListPageParam(@Param(value="sqlWhereMap") Map<String,Object> paramMap, @Param(value="rowBounds") RowBounds rowBounds);

	/***
	 * 根据用户ID获取用户所属角色
	 * @param userId
	 * @return
	 */
	@SelectProvider(type=RoleSqlProvider.class,method="selectListRole")
	List<Role> selectListRole(@Param(value="userId") String userId);

}
