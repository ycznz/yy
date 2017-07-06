<%@page import="com.pro.services.CategoryServiceImpl"%>
<%@page import="com.pro.services.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//1	
	String categoryId = request.getParameter("categoryId");

	//2
	CategoryService categoryService=new CategoryServiceImpl();
	categoryService.removeCategory(Integer.parseInt(categoryId));
	
	//3
	response.sendRedirect("doquerycategory1.jsp");
%>