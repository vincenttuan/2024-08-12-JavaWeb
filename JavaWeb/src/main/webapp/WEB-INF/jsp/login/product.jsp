<%@ page import="login.dto.ProductDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 端傳來的資訊
	List<ProductDto> productDtos = (List<ProductDto>)request.getAttribute("productDtos");
	// 得到 session 內的 loginName 的資料
	String loginName = (String)session.getAttribute("loginName");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product 列表資料</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<div class="pure-form">
			<fieldset>
				<legend>Hi <%=loginName %> 您好 ! Product 列表</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th>Qty</th>
						</tr>
					</thead>
					<tbody>
						<% for(ProductDto product : productDtos) { %>
							<tr>
								<td><%=product.getId() %></td>
								<td><%=product.getName() %></td>
								<td><%=product.getPrice() %></td>
								<td><%=product.getQty() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>