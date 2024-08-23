<%@page import="guestbook.entity.Guestbook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 取得所傳來的資訊
	List<Guestbook> guestbooks = (List)request.getAttribute("guestbooks");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<title>留言板檢視</title>
	</head>
	<body style="padding: 15px">
		<table class="pure-table pure-table-bordered">
			<thead>
				<th>UserId</th><th>Message</th><th>Time</th>
			</thead>
			<tbody>
				<%for(Guestbook gb : guestbooks) { %>
					<td><%=gb.getUserId() %></td>
					<td><%=gb.getMessage() %></td>
					<td><%=gb.getTime() %></td>
				<%} %>
			</tbody>
		</table>
	</body>
</html>