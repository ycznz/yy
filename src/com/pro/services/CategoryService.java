package com.pro.services;

import com.pro.domain.Category;
import com.pro.util.PageModel;

public interface CategoryService {

	public PageModel<Category> findCategory(int currentPage,int pageSize);

	public void saveCate(Category category);
	
	public void removeCategory(int categoryId);
	
	public void updateCategory(Category category);
	
	public Category queryCategory(int categoryId);
}
