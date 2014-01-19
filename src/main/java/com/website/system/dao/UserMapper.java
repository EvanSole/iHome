package com.website.system.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.website.common.dao.BaseDao;
import com.website.common.util.page.Page;
import com.website.system.model.User;

@Repository
public interface UserMapper extends BaseDao<User> {

	/***
	 * 主键查询
	 * @param id
	 * @return
	 */
	@SelectProvider(type=UserSqlProvider.class,method="findById")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	User findById(@Param(value="id") String id); 
	
	/***
	 * 查询所有集合
	 * @return
	 */
	@SelectProvider(type=UserSqlProvider.class,method="selectList")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	java.util.List<User> selectList(); 
	
	/***
	 * 条件查询
	 * @param sqlWhereMap
	 * @return
	 */
	@SelectProvider(type=UserSqlProvider.class,method="selectListParam")
	@Options(useCache = true, flushCache = false, timeout = 10000) 
	java.util.List<User> selectListParam(@Param(value="sqlWhereMap") Map<String,Object> sqlWhereMap);
	
	/***
	 * 默认分页查询
	 * @param rowBounds
	 * @return
	 */
	@SelectProvider(type=UserSqlProvider.class,method="selectListPage")
	java.util.List<User> selectListPage(@Param(value="page") Page<User> page);
   
    /***
    * 带条件分页查询
    * @param paramMap
    * @param rowBounds
    * @return
    */
	@SelectProvider(type=UserSqlProvider.class,method="selectListPageParam")
	java.util.List<User> selectListPageParam(@Param(value="sqlWhereMap") Map<String,Object> paramMap, @Param(value="page") Page<User> page);

	/***
	 * 查询用户信息
	 * @param paramMap
	 * @return
	 */
	@SelectProvider(type=UserSqlProvider.class,method="findUser")
	User findUser(@Param(value="userName") String userName,@Param(value="password") String password);
}
