<%@ page import="login.dto.OrderItemDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 端傳來的資訊
	List<OrderItemDto> orderItemDtos = (List<OrderItemDto>)request.getAttribute("orderItemDtos");
	// 得到 session 內的 loginName 的資料
	String loginName = (String)session.getAttribute("loginName");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>OrderItem 列表資料</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<div class="pure-form">
			<fieldset>
				<legend>Hi <%=loginName %> 您好 ! Product 列表</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>item id</th>
							<th>order id</th>
							<th>product id</th>
							<th>product name</th>
							<th>quantity</th>
							<th>unit price</th>
							<th>sub total</th>
						</tr>
					</thead>
					<tbody>
						<% for(OrderItemDto orderItemDto : orderItemDtos) { %>
							<tr>
								<td><%=orderItemDto.getItemId() %></td>
								<td><%=orderItemDto.getOrderId() %></td>
								<td><%=orderItemDto.getProductId() %></td>
								<td><%=orderItemDto.getProductName() %></td>
								<td><%=orderItemDto.getQuantity() %></td>
								<td><%=orderItemDto.getUnitPrice() %></td>
								<td><%=orderItemDto.getQuantity() * orderItemDto.getUnitPrice() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>