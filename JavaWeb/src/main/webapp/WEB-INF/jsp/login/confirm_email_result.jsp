<%@ page import="login.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	UserDto userDto = null;
	String loginMessage = (String)request.getAttribute("loginMessage");
	boolean loginSuccess = (Boolean)request.getAttribute("loginSuccess");
	if(loginSuccess) {
		userDto = (UserDto)request.getAttribute("userDto");
	}
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登入結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<div class="pure-form">
			<fieldset>
				<legend>登入結果</legend>
				登入成功: <%=loginSuccess %><p>
				登入訊息: <%=loginMessage %><p>
				使用者資訊: <%=userDto %><p>
			</fieldset>
		</div>
	</body>
</html>