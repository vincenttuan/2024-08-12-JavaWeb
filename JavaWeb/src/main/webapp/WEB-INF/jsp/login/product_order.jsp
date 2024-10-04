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
		<form class="pure-form" method="post" action="/JavaWeb/product/cart">
			<fieldset>
				<legend>訂單新增</legend>
				商品資訊: 
					<select name="productId">
						<% for(ProductDto productDto : products) { %>
							<option value="<%=productDto.getId() %>">
								品名: <%=productDto.getName() %>
								價格: $<%=productDto.getPrice() %>
								數量: <%=productDto.getQty() %>
							</option>
						<% } %>
					</select>
					<p />
				購買數量: 
					<input type="number" name="amount" placeholder="請輸入購買數量" required /><p />
				<button type="submit" class="pure-button pure-button-primary">新增到購物車</button>
			</fieldset>
		</form>
	</body>
</html>