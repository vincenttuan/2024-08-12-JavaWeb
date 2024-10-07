<%@page import="login.exception.BaseException"%>
<%@ page import="login.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	BaseException baseException = (BaseException)request.getAttribute("baseException");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%=baseException.getTitle() %></title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<div class="pure-form">
			<fieldset>
				<legend><%=baseException.getTitle() %></legend>
				錯誤訊息: <%=baseException.getErrorMessage() %><p>
			</fieldset>
		</div>
	</body>
</html>