<%@ page import="login.dto.ProductDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ProductDto> products = (List<ProductDto>)request.getAttribute("products");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Order Add</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<form method="post" action="/JavaWeb/product/cart">
			<fieldset>
				<legend>訂單新增</legend>
				商品資訊: 
					
					<p />
				購買數量: 
					<input type="number" name="amount" placeholder="請輸入購買數量" required /><p />
				<button type="submit">新增到購物車</button>
			</fieldset>
		</form>
	</body>
</html>