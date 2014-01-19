package com.website.system.service;

import java.util.List;
import java.util.Map;

import com.website.common.util.page.Page;
import com.website.system.model.Permission;

public interface PermissionService {

	Permission findById(String id);
	
	void insertPermission(Permission permission);
	
	void updatePermission(Permission permission);
	
	void deletePermission(Permission permission);
	
	void deletePermission(String id);
	
	List<Permission> selectList();
	
	List<Permission> selectList(Map<String, Object> paramMap);
	
	List<Permission> selectList(Page page);
	
	List<Permission> selectList(Map<String, Object> paramMap,Page page);
	
	List<Permission> selectList(String roleId);
	
}
