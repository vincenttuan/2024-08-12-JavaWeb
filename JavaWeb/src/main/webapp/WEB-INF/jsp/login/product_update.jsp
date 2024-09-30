<%@page import="login.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDto productDto = (ProductDto)request.getAttribute("productDto");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Update</title>
	</head>
	<body>
		<form method="post" enctype="multipart/form-data" action="/JavaWeb/product/update">
			<fieldset>
				<legend>商品修改</legend>
				<input type="hidden" value="<%=productDto.getId() %>">
				商品名稱: <input type="text" name="product_name" value="<%=productDto.getName() %>" placeholder="請輸入商品名稱" required /><p />
				商品價格: <input type="number" name="price" value="<%=productDto.getPrice() %>" placeholder="請輸入商品價格" required /><p />
				商品庫存: <input type="text" name="stock_quantity" value="<%=productDto.getQty() %>" placeholder="請輸入商品庫存" required /><p />
				商品原圖: <img width="100" src="data:image/png;base64,<%=productDto.getImageBase64() %>"><p />
				商品圖片: <input type="file" name="product_image" placeholder="請選擇商品圖片" /><p />
				<button type="submit">修改</button>
			</fieldset>
		</form>
	</body>
</html>