<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;" align="center">BridgeLabz</h2>
<h2 style="color:green;" align="center">User <%=session.getAttribute("operation") %> Status</h2>
<h2 style="color:black;" align="center">User <%=session.getAttribute("operation") %> Success</h2>
<h3 align="center">
<a href="./LoginForm.jsp">LoginForm</a>
</body>
</html>