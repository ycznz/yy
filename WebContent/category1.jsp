<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.util.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<fieldset>
			<legend>公告信息</legend>
			<div>
				<br/>				
				又是一年。。
				<br/><br/>
			</div>
	</fieldset>
	<br/>
	<a href="addCate.jsp">添加类别</a>
<%
	PageModel<Category> pageModel=(PageModel<Category>)request.getAttribute("gyy");
	List<Category> cateList=pageModel.getList();
%>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>描述</td>
		<td>操作</td>
	</tr>
<%
	for(int i=0;i<cateList.size();i++)
	{
		Category catetory=cateList.get(i);
%>
		<tr>
			<td><%=catetory.getCategoryId() %></td>
			<td><%=catetory.getCategoryName() %></td>
			<td><%=catetory.getCategoryDesc() %></td>
			<td>
				<a href="dofindcategory.jsp?categoryId=<%=catetory.getCategoryId() %>">修改</a>/
				<a href="dodeleteCategory.jsp?categoryId=<%=catetory.getCategoryId() %>">删除</a>
			</td>
		</tr>
<%
	}
%>	
</table>

<script type="text/javascript">
	function f(i){
		
		//将页码放入currentPage表单元素中
		document.getElementById("currentPage").value=i;
		//根据表单id找到表单，再提交
		document.getElementById("searchForm").submit();
	}
</script>
<!-- 将页码放入currentPage表单元素中。再提交表单 -->
<form action="doquerycategory1.jsp" method="post" id="searchForm">
	<input type="hidden" name="currentPage" id="currentPage"/>	
</form>
<table width="100%">
	<tr>
		<td align="right">
			<a href="#" onclick="f(1);return false;">首页</a>
			<a href="#" onclick="f(<%=pageModel.getPageUp() %>);return false;"><%=pageModel.getPageUp() %>上一页</a>
			<a href="#" onclick="f(<%=pageModel.getPageDown()%>);return false;"><%= pageModel.getPageDown()%>下一页</a>
			<a href="#" onclick="f(<%=pageModel.getPageEnd() %>);return false;"><%=pageModel.getPageEnd() %>尾页</a>
		</td>
	</tr>
</table>
</body>
</html>