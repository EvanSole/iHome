package com.website.system;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.website.system.dao.RoleMapper;
import com.website.system.model.Role;

/**
 * Unit test for simple App.
 */
public class RoleTest extends TestCase {

	public void testBaties() throws IOException {

		Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config-test.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = null;

		try {

			sessionFactory.getConfiguration().addMapper(RoleMapper.class);

			session = sessionFactory.openSession();

			RoleMapper roleDao = session.getMapper(RoleMapper.class);
            
			
			
			//1.获取用户
//			Role role = roleDao.findById("10000");
//			System.out.println(role.getRoleName());
			
	        List<Role> list  = roleDao.selectListRole("10000");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}

	}

}
