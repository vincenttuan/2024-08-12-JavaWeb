<%@page import="employee.entity.EmployeeName"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 取得 EmployeeServlet 傳遞過來的員工姓名
	List<EmployeeName> employeeNames = (List<EmployeeName>)request.getAttribute("employeeNames");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<title>Employee</title>
	</head>
	<body style="padding: 15px">
		<div class="pure-form">
			<fieldset>
				<legend>Employee List</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>Id</th><th>Name</th>
						</tr>
					</thead>
					<tbody>
						<% for(EmployeeName eName : employeeNames) { %>
							<tr>
								<td><%=eName.getId() %></td>
								<td><%=eName.getName() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>