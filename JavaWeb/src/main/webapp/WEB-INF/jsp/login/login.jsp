<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員登入</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style type="text/css">
			/* 正中央 */
			body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
		</style>
	</head>
	<body style="padding: 15px">
		<form action="pure-form pure-form-aligned" method="post" action="#">
			<fieldset>
				<legend><h1>👨‍💼 會員登入</h1></legend>
				<div class="pure-control-group">
					<label for="userName">👤️ 帳號</label>
					<input name="userName" type="text" placeholder="請輸入帳號">
				</div>
				<div class="pure-control-group">
					<label for="password">🔐 密碼</label>
					<input name="password" type="password" placeholder="請輸入密碼">
				</div>
				<div class="pure-controls">
					<button type="submit" class="pure-button pure-button-primary">登入</button>
					✏️ <a href="${pageContext.request.contextPath}/user/register">註冊</a>
				</div>
			</fieldset>
		</form>
	</body>
</html>