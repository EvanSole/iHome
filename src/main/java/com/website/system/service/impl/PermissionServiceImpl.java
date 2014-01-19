package com.website.system.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.common.util.page.Page;
import com.website.system.dao.PermissionMapper;
import com.website.system.model.Permission;
import com.website.system.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	/***
	 * 根据主键查询角色
	 */
	public Permission findById(String id) {
		return permissionMapper.findById(id);
	}

	/***
	 * 添加
	 */
	@Override
	public void insertPermission(Permission permission) {
		permissionMapper.insert(permission);
	}

	/***
	 * 修改
	 */
	@Override
	public void updatePermission(Permission permission) {
		permissionMapper.update(permission);
	}

	/***
	 * 删除
	 */
	@Override
	public void deletePermission(Permission permission) {
		permissionMapper.delete(permission);
	}

	/***
	 * 根据主键删除
	 */
	@Override
	public void deletePermission(String id) {
		permissionMapper.delete(findById(id));
	}

	/***
	 * 查询所有信息
	 */
	@Override
	public List<Permission> selectList() {
		return permissionMapper.selectList();
	}

	/***
	 * 条件查询信息
	 */
	@Override
	public List<Permission> selectList(Map<String, Object> paramMap) {
		return permissionMapper.selectListParam(paramMap);
	}

	/***
	 * 分页查询信息
	 */
	@Override
	public List<Permission> selectList(Page page) {
		return permissionMapper.selectListPage(new RowBounds(
				page.getPageSize(), page.getPageSize()));
	}

	/***
	 * 条件分页查询信息
	 */
	@Override
	public List<Permission> selectList(Map<String, Object> paramMap, Page page) {
		return permissionMapper.selectListPageParam(paramMap, new RowBounds(page.getPageSize(), page.getPageSize()));
	}

	/***
	 * 根据角色Id获取角色权限信息
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Permission> selectList(String roleId) {
		return permissionMapper.selectListPermission(roleId);
	}

}
