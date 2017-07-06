<%@page import="com.pro.services.CategoryServiceImpl"%>
<%@page import="com.pro.services.CategoryService"%>
<%@page import="com.pro.domain.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1,取表单数据
	String categoryId = request.getParameter("categoryId");
	String categoryName = request.getParameter("categoryName");
	String categoryDesc = request.getParameter("categoryDesc");
	
	Category cg=new Category();
	cg.setCategoryDesc(categoryDesc);
	cg.setCategoryId(Integer.parseInt(categoryId));
	cg.setCategoryName(categoryName);
	
	//2.调用业务层
	CategoryService categoryService=new CategoryServiceImpl();
	categoryService.updateCategory(cg);
	
	//3
	response.sendRedirect("doquerycategory1.jsp");
%>