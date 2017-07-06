package com.pro.dao;

import java.sql.Connection;

import com.pro.domain.Category;
import com.pro.util.PageModel;

public interface CategoryDao {
	
	public PageModel<Category> queryCategory(Connection conn,int currentPage,int pageSize)throws Exception;

	public void addCate(Connection conn,Category category)throws Exception;

	public void deleteCateById(Connection conn,int categoryId)throws Exception;
	
	public void updateCategory(Connection conn,Category category) throws Exception;

	public Category findCategoryById(Connection conn,int categoryId)throws Exception;
}
