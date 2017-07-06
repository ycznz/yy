<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.util.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.services.CategoryService"%>
<%@page import="com.pro.services.CategoryServiceImpl"%>
<%
	//注意：控制器，里面一般会写三步曲。
	//1，取表单数据。request对象，是请求对象，由服务器来创建，
	String currentPage=request.getParameter("currentPage");
	if(currentPage==null||"".equals(currentPage)){
		currentPage="1";
	}
	
	//2，调用业务层。
	CategoryService categoryService=new CategoryServiceImpl();
	PageModel<Category> pageModel=categoryService.findCategory(Integer.parseInt(currentPage), 3);
	//将数据通过setAttribute方法，放入request对象中，
	request.setAttribute("gyy", pageModel);
	
	//3，跳转
	request.getRequestDispatcher("category1.jsp").forward(request, response);
	
%>
