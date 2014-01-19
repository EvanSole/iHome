package com.website.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.website.common.model.BaseModel;

@Entity
@Table(name = "sys_user")
public class User extends BaseModel {

	private static final long serialVersionUID = 1L;

	/***
	 * 表名称 Table
	 */
	public static final String TABLE_NAME = tablename(User.class);

	/***
	 * 列名称集合  columns
	 */
	public static final String COLUMNS = caculationColumnList(User.class);

	@Id
	private String id;

	// 用户名
	@Column(name = "userName", nullable = true, length = 50)
	private String userName;

	// 用户密码
	@Column(name = "password", length = 50)
	private String password;

	// 真实姓名
	@Column(name = "realName", length = 50)
	private String realName;

	// 用户性别
	@Column(name = "sex")
	private int sex;

	// 用户年龄
	@Column(name = "age", length = 3)
	private String age;

	// 用户邮箱
	@Column(name = "email", length = 50)
	private String email;
	
	// 创建时间
	@Column(name = "createTime")
	private Date createTime;
	
	// 修改时间
	@Column(name = "modifyTime")
	private Date modifyTime;
	
	//用户状态
	@Column(name="status")
	private String status;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}
