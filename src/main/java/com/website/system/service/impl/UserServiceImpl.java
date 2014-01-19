package com.website.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.common.util.page.Page;
import com.website.system.dao.UserMapper;
import com.website.system.model.User;
import com.website.system.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/***
	 * 根据主键查询用户
	 */
	public User findById(String id) {
		return userMapper.findById(id);
	}

	/***
	 * 添加用户
	 */
	@Override
	public void insertUser(User user) {
		userMapper.insert(user);
	}

	/***
	 * 修改用户
	 */
	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}

	/***
	 * 删除用户
	 */
	@Override
	public void deleteUser(User user) {
		userMapper.delete(user);
	}

	/***
	 * 根据主键删除用户
	 */
	@Override
	public void deleteUser(String id) {
		userMapper.delete(findById(id));
	}

	/***
	 * 查询所有用户信息
	 */
	@Override
	public List<User> selectList() {
		return userMapper.selectList();
	}

	/***
	 * 条件查询用户信息
	 */
	@Override
	public List<User> selectList(Map<String, Object> paramMap) {
		return userMapper.selectListParam(paramMap);
	}

	/***
	 * 分页查询用户信息
	 */
	@Override
	public List<User> selectList(Page<User> page) {
		return userMapper.selectListPage(page);
	}

	/***
	 * 条件分页查询用户信息
	 */
	@Override
	public List<User> selectList(Map<String, Object> paramMap, Page<User> page) {

		return userMapper.selectListPageParam(paramMap, page);
	}

	/***
	 * 根据用户名和密码查询用户信息
	 */
	@Override
	public User findUser(String userName, String password) {
		return userMapper.findUser(userName, password);
	}

	/***
	 * 根据用户名查询用户信息
	 */
	@Override
	public User findUser(String userName) {
		return userMapper.findUser(userName, null);
	}

}
