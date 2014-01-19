package com.website.system.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.common.util.page.Page;
import com.website.system.dao.RoleMapper;
import com.website.system.model.Role;
import com.website.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private  RoleMapper roleMapper;

	/***
	 * 根据主键查询角色
	 */
	public Role findById(String id) {
		return roleMapper.findById(id);
	}

	/***
	 * 添加角色
	 */
	@Override
	public void insertRole(Role role) {
		roleMapper.insert(role);
	}

	/***
	 * 修改角色
	 */
	@Override
	public void updateRole(Role role) {
		roleMapper.update(role);
	}

	/***
	 * 删除角色
	 */
	@Override
	public void deleteRole(Role role) {
		roleMapper.delete(role);
	}

	/***
	 * 根据主键删除角色
	 */
	@Override
	public void deleteRole(String id) {
		roleMapper.delete(findById(id));
	}

	/***
	 * 查询所有角色信息
	 */
	@Override
	public List<Role> selectList() {
		return roleMapper.selectList();
	}

	/***
	 * 条件查询角色信息
	 */
	@Override
	public List<Role> selectList(Map<String, Object> paramMap) {
		return roleMapper.selectListParam(paramMap);
	}

	/***
	 * 分页查询角色信息
	 */
	@Override
	public List<Role> selectList(Page page) {
		return roleMapper.selectListPage(new RowBounds(page.getPageSize(), page.getPageSize()));
	}

	/***
	 * 条件分页查询角色信息
	 */
	@Override
	public List<Role> selectList(Map<String, Object> paramMap, Page page) {
		return roleMapper.selectListPageParam(paramMap,new RowBounds(page.getPageSize(), page.getPageSize()));
	}

	/***
	 * 根据用户ID获取用户所属角色
	 */
	@Override
	public List<Role> selectList(String userId) {
		return roleMapper.selectListRole(userId);
	}

}
