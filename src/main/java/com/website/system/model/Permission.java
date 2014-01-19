package com.website.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.website.common.model.BaseModel;

@Entity
@Table(name = "sys_permission")
public class Permission extends BaseModel {

	private static final long serialVersionUID = 1L;

	/***
	 * 表名称 Table
	 */
	public static final String TABLE_NAME = tablename(Permission.class);

	/***
	 * 列名称集合 columns
	 */
	public static final String COLUMNS = caculationColumnList(Permission.class);

	@Id
	private String id;

	// 角色名
	@Column(name = "permissionName", nullable = true, length = 50)
	private String permissionName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

}
