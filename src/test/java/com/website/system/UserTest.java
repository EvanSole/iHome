package com.website.system;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.website.common.util.page.Page;
import com.website.system.dao.UserMapper;
import com.website.system.model.User;

/**
 * Unit test for simple App.
 */
public class UserTest extends TestCase {

	public void testBaties() throws IOException {

		Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config-test.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = null;

		try {

			sessionFactory.getConfiguration().addMapper(UserMapper.class);

			session = sessionFactory.openSession();

			UserMapper userDao = session.getMapper(UserMapper.class);
			
			Page<User> page = new Page<User>();  
		    page.setPageNo(2);  
		    User  users = userDao.findUser("admin", null);  
			
//			//1.获取用户
//			User user = userDao.findUser("admin",null);
//			System.out.println(user.getEmail());
			
			//2.新增用户
//			User obj = new User();
//			obj.setId(UUID.randomUUID().toString());
//			obj.setUserName("zs");
//			obj.setPassword("test");
//			obj.setRealName("zhangshan");
//			obj.setEmail("zs@mail.com");
//			userDao.insert(obj);
//			session.commit();
			
			//3.修改用户
//			User user = userDao.findById("b1e84f09-ef8f-4b50-8d78-290e12f97a25");
//			user.setAge("20");
//			user.setSex(1);
//			user.setCreateTime(new Date());
//			userDao.update(user);
//			session.commit();
			
			
			//4.删除用户
//			userDao.delete(userDao.findById("dd6effe4-14d0-4fed-881f-c8814e77462f"));
//			session.commit();
			
			//5.条件查询
//			java.util.Map<String,Object> sqlWhereMap = new java.util.HashMap<String,Object>();
//	        sqlWhereMap.put("id", "AAA");
//	        sqlWhereMap.put("userName", "zs");
//	        sqlWhereMap.put("createTime",new Date());
//		    List<User> list= userDao.findList(sqlWhereMap);
//		    System.out.println("长度："+list.size());
			
			//6.查询集合
//			List<User> list =  userDao.find();
//			System.out.println("长度："+list.size());
			
			//7。分页查询
//			java.util.Map<String,Object> sqlWhereMap = new java.util.HashMap<String,Object>();
//	        sqlWhereMap.put("id", "AAA");
//	        sqlWhereMap.put("userName", "zs");
//			List<User> list =  userDao.selectListPageParam(sqlWhereMap,new RowBounds(1,Page.DEFAULT_PAGE_SIZE));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}

	}

}
