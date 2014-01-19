package com.website.common.dao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

import com.website.common.model.BaseModel;

/**
 * MyBatis CRUD基接口
 * 
 * @author Evan
 * 
 * @param <T> 处理的POJO对象
 */
public interface BaseDao<T extends BaseModel> {

	/**
	 * Insert语句从CUDTemplate类中生成
	 * 
	 * @param obj
	 */
	@InsertProvider(type = CRUDTemplate.class, method = "insert")
	@Options(flushCache = true, timeout = 20000)
	public void insert(T obj);

	/**
	 * Update语句从CUDTemplate类中生成
	 * 
	 * @param obj
	 */
	@UpdateProvider(type = CRUDTemplate.class, method = "update")
	@Options(flushCache = true, timeout = 20000)
	public void update(T obj);

	/**
	 * Delete语句从CUDTemplate类中生成
	 * 
	 * @param obj
	 */
	@DeleteProvider(type = CRUDTemplate.class, method = "delete")
	@Options(flushCache = true, timeout = 20000)
	public void delete(T obj);

}
