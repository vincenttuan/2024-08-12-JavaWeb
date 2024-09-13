<%@ page import="login.entity.User"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 端傳來的資訊
	List<User> users = (List<User>)request.getAttribute("users");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User 列表資料</title>
	</head>
	<body>
		<%=users %>
	</body>
</html>