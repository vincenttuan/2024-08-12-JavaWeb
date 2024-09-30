<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String resultMessage = request.getAttribute("resultMessage") + "";	
	String productName   = request.getAttribute("productName") + "";	
	String price         = request.getAttribute("price") + "";	
	String stockQuantity = request.getAttribute("stockQuantity") + "";	
	String base64Image   = request.getAttribute("base64Image") + "";	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Result</title>
	</head>
	<body>
		<div>
			<fieldset>
				<legend><%=resultMessage %></legend>
				商品名稱: <%=productName %><p />
				商品價格: <%=price %><p />
				商品庫存: <%=stockQuantity %><p />
				商品圖片: <img src="data:image/png;base64,<%=base64Image %>"><p />
			</fieldset>
		</div>
		<a href="/JavaWeb/product/add"> 商品新增 </a> | <a href="/JavaWeb/product/list"> 商品列表 </a>
	</body>
</html>