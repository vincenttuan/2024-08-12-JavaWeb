<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員註冊</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<form class="pure-form" method="post" action="/JavaWeb/user/register">
			<fieldset>
				<legend>會員註冊</legend>
				使用名稱: <input type="text" name="userName" required placeholder="請輸入名稱" /><p /> 
				使用密碼: <input type="text" name="password" required placeholder="請輸入密碼" /><p /> 
				電子信箱: <input type="email" name="email" required placeholder="請輸入電子信箱" /><p />
				<button type="reset">清除</button>
				<button type="submit">傳送</button> 
			</fieldset>
		</form>
	</body>
</html>