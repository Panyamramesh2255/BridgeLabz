<%@ page import="java.util.*" %>
<%!
int eid;
String ename;
float esal;
String eaddr;
%>
<%
try{
	eid=Integer.parseInt(request.getParameter("eid"));
	ename=request.getParameter("ename");
	esal=Float.parseFloat(request.getParameter("eid"));
	eaddr=request.getParameter("eaddr");
}
catch(Exception e)
{
e.printStackTrace();
}
%>
<html>
<body>
<h2 style="color:red" align="center">BridgeLanz</h2>
<h2 style="color:blue" align="center">EmployeeDetails</h3>
<center>
<table border="1">
<tr>
<td>EmployeeId</td>
<td><%=eid %></td>
</tr>
<tr>
<td>EmployeeName</td>
<td><%=ename %></td>
</tr>
<tr>
<td>EmployeeSalary</td>
<td><%=esal %></td>
</tr>
<tr>
<td>EmployeeAddress</td>
<td><%=eaddr %></td>
</tr>
</table>
</center>
</body>
</html>