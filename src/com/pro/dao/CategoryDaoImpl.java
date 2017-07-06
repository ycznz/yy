package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.Category;
import com.pro.util.PageModel;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	/**
	 * 将类别表放入集合，再放入pageModel中
	 */
	public PageModel<Category> queryCategory(Connection conn, int currentPage, int pageSize) throws Exception {

		List<Category> cateList=new ArrayList<Category>();
		
		String sql="select * from category order by categoryId desc limit ?,?";
		Object[] param={(currentPage-1)*pageSize,pageSize};
		
		ResultSet rs = this.getRs(conn, sql, param);
		while(rs.next()){
			Category category=new Category();
			category.setCategoryDesc(rs.getString("categoryDesc"));
			category.setCategoryId(rs.getInt("categoryId"));
			category.setCategoryName(rs.getString("categoryName"));
			
			cateList.add(category);
		}
		
		PageModel<Category> pageModel=new PageModel<Category>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setList(cateList);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecord(this.getRowCount(conn, "select count(*) from category", null));
		
		return pageModel;
	}

	public void addCate(Connection conn, Category category) throws Exception {
		String sql="insert into category(categoryName,categoryDesc) values(?,?)";
		Object[] param={category.getCategoryName(),category.getCategoryDesc()};
		this.exeSql(conn, sql, param);
	}

	@Override
	public void deleteCateById(Connection conn, int categoryId) throws Exception {
		String sql="delete from category where categoryId=?";
		Object[] param={categoryId};
		this.exeSql(conn, sql, param);
		
	}

	@Override
	public void updateCategory(Connection conn, Category category) throws Exception {
		String sql="update category set categoryName=?,categoryDesc=? where categoryId=?";
		Object[] param={category.getCategoryName(),category.getCategoryDesc(),category.getCategoryId()};
		this.exeSql(conn, sql, param);		
	}

	@Override
	public Category findCategoryById(Connection conn, int categoryId) throws Exception {
		String sql="select * from category where categoryId=?";
		Object[] param={categoryId};
		
		ResultSet rs = this.getRs(conn, sql, param);
		Category category=null;
		if(rs.next()){
			category=new Category();
			category.setCategoryDesc(rs.getString("categoryDesc"));
			category.setCategoryId(rs.getInt("categoryId"));
			category.setCategoryName(rs.getString("categoryName"));
		}
		return category;
	}

}
