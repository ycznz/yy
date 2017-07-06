<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.services.CategoryServiceImpl"%>
<%@page import="com.pro.services.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1
	String categoryId = request.getParameter("categoryId");

	//2
	CategoryService categoryService=new CategoryServiceImpl();
	Category category=categoryService.queryCategory(Integer.parseInt(categoryId));
	
	request.setAttribute("category", category);
	//3
	request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
%>