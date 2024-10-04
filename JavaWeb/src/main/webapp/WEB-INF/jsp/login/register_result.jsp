<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員註冊結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<form class="pure-form" method="get" action="/JavaWeb/user/register">
			<fieldset>
				<legend>會員註冊結果</legend>
				<%=request.getAttribute("result") %>
				<button type="submit">再註冊一個</button> 
			</fieldset>
		</form>
		<a href="/JavaWeb/user/register">再註冊一個</a>
	</body>
</html>