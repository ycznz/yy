<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>公告信息</legend>
		<div>
			<br /> 又是一年。。 <br />
			<br />
		</div>
	</fieldset>
	<br />
	<form action="doaddcate.jsp" method="post">
		<table border="1" width="500" align="center">
			<tr>
				<td>类别id</td>
				<td><input type="text" name="categoryId" /></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="categoryName" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea name="categoryDesc" cols="30" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="添加" /></td>
			</tr>
		</table>
	</form>
</body>
</html>