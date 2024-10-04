<%@ page import="login.dto.CartDto"%>
<%@ page import="java.util.Map"%>
<%@ page import="login.dto.ProductDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<Integer, CartDto> cart = (Map<Integer, CartDto>)session.getAttribute("cart");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cart List</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<form class="pure-form" method="post" action="/JavaWeb/product/submit">
			<fieldset>
				<legend>Cart 購物車</legend>
				
				<button type="submit" class="pure-button pure-button-primary">結帳</button>
			</fieldset>
		</form>
	</body>
</html>