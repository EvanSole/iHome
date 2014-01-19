package com.website.system.service;

import java.util.List;
import java.util.Map;

import com.website.common.util.page.Page;
import com.website.system.model.Role;

public interface RoleService {

	Role findById(String id);
	
	void insertRole(Role role);
	
	void updateRole(Role role);
	
	void deleteRole(Role role);
	
	void deleteRole(String id);
	
	List<Role> selectList();
	
	List<Role> selectList(Map<String, Object> paramMap);
	
	List<Role> selectList(Page page);
	
	List<Role> selectList(Map<String, Object> paramMap,Page page);
	
	List<Role> selectList(String userId);
	
}
