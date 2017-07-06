package com.pro.services;

import java.sql.Connection;

import com.pro.dao.CategoryDao;
import com.pro.dao.CategoryDaoImpl;
import com.pro.domain.Category;
import com.pro.util.DbHelper;
import com.pro.util.PageModel;

public class CategoryServiceImpl implements CategoryService {

	public PageModel<Category> findCategory(int currentPage, int pageSize) {
		Connection conn=null;
		PageModel<Category> pageModel =null;
		
		try {
			conn = DbHelper.getConn();
			
			CategoryDao categoryDao=new CategoryDaoImpl();
			pageModel = categoryDao.queryCategory(conn, currentPage, pageSize);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return pageModel;
	}

	@Override
	public void saveCate(Category category) {
		Connection conn=null;
		try {
			conn=DbHelper.getConn();
			CategoryDao categoryDao=new CategoryDaoImpl();
			categoryDao.addCate(conn, category);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removeCategory(int categoryId) {
		Connection conn=null;
		try {
			conn=DbHelper.getConn();
			CategoryDao categoryDao=new CategoryDaoImpl();
			categoryDao.deleteCateById(conn, categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateCategory(Category category) {
		Connection conn=null;
		try {
			conn=DbHelper.getConn();
			CategoryDao categoryDao=new CategoryDaoImpl();
			categoryDao.updateCategory(conn, category);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Category queryCategory(int categoryId) {
		Connection conn=null;		
		Category category=null;
		
		try {
			conn=DbHelper.getConn();
			CategoryDao categoryDao=new CategoryDaoImpl();
			category = categoryDao.findCategoryById(conn, categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return category;
	}

}
