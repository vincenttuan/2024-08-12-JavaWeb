<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 取得 EmployeeServlet 傳遞過來的員工姓名
	List<String> employeeNames = (List<String>)request.getAttribute("employeeNames");
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
							<th>Index</th><th>Name</th>
						</tr>
					</thead>
					<tbody>
						<% for(int i=0;i<employeeNames.size()-1;i++) { %>
							<tr>
								<td><%=i %></td><td><%=employeeNames.get(i) %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>