<%@ page import="login.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String errorMessage = (String)request.getAttribute("errorMessage");
	boolean isPass = (Boolean)request.getAttribute("isPass");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Email 確認結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<div class="pure-form">
			<fieldset>
				<legend>Email 確認結果</legend>
				Email確認: <%=isPass %><p>
				相關訊息: <%=errorMessage %><p>
			</fieldset>
		</div>
	</body>
</html>