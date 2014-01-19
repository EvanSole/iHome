package com.website.system.service;

import java.util.List;
import java.util.Map;

import com.website.common.util.page.Page;
import com.website.system.model.User;

public interface UserService {

	User findById(String id);
	
	void insertUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	void deleteUser(String id);
	
	List<User> selectList();
	
	List<User> selectList(Map<String, Object> paramMap);
	
	List<User> selectList(Page<User> page);
	
	List<User> selectList(Map<String, Object> paramMap,Page<User> page);

	User findUser(String userName, String password);

	User findUser(String userName);
	
}
