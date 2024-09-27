<%@ page import="login.dto.SalesOrderDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 端傳來的資訊
	List<SalesOrderDto> salesOrderDtos = (List<SalesOrderDto>)request.getAttribute("salesOrderDtos");
	// 得到 session 內的 loginName 的資料
	String loginName = (String)session.getAttribute("loginName");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SalesOrder 列表資料</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<div class="pure-form">
			<fieldset>
				<legend>Hi <%=loginName %> 您好 ! Product 列表</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>order id</th>
							<th>user id</th>
							<th>user name</th>
							<th>order date</th>
							<th>total amount</th>
							<th>order status</th>
							<th>item list</th>
						</tr>
					</thead>
					<tbody>
						<% for(SalesOrderDto salesOrderDto : salesOrderDtos) { %>
							<tr>
								<td><%=salesOrderDto.getOrderId() %></td>
								<td><%=salesOrderDto.getUserId() %></td>
								<td><%=salesOrderDto.getUserName() %></td>
								<td><%=salesOrderDto.getOrderDate() %></td>
								<td><%=salesOrderDto.getTotalAmount() %></td>
								<td><%=salesOrderDto.getOrderStatus() %></td>
								<td><a href="/JavaWeb/product/order/item/list?orderId=<%=salesOrderDto.getOrderId() %>">item list</a></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>