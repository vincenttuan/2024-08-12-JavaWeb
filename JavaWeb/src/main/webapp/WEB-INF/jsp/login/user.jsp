<%@ page import="login.dto.UserDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 端傳來的資訊
	List<UserDto> userDtos = (List<UserDto>)request.getAttribute("userDtos");
	// 得到 session 內的 loginName 的資料
	String loginName = (String)session.getAttribute("loginName");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User 列表資料</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- title bar -->
		<%@ include file="/WEB-INF/jsp/login/title_bar.jspf" %>
		<div class="pure-form">
			<fieldset>
				<legend>Hi <%=loginName %> 您好 ! User 列表</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>userId</th>
							<th>userName</th>
							<th>email</th>
							<th>active</th>
						</tr>
					</thead>
					<tbody>
						<% for(UserDto user : userDtos) { %>
							<tr>
								<td><%=user.getUserId() %></td>
								<td><%=user.getUserName() %></td>
								<td><%=user.getEmail() %></td>
								<td><%=user.getActive() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>