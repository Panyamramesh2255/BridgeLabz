<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.util.*" import="java.sql.Connection"%>
<%!
String uname;
String upwd;
Connection con;
PreparedStatement ps;
ResultSet rs;
%>
<%
try{
	session.setAttribute("operation", "login");
	 String uname=String.valueOf(request.getParameter("uname"));
     String upwd=String.valueOf(request.getParameter("upwd"));

	Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Design_patterns?useSSL=false", "root", "password");
ps=con.prepareStatement("select * from reg_user where uname=? and upwd=?");
ps.setString(1, uname);
ps.setString(2, upwd);
rs=ps.executeQuery();
boolean b=rs.next();
RequestDispatcher requestDispatcher=null;
if(b==true)
{
	requestDispatcher=application.getRequestDispatcher("/Sucess.jsp");
	requestDispatcher.forward(request, response); 
	//<%@ include file="Sucess.jsp"
	
	}
else
{
	requestDispatcher=application.getRequestDispatcher("/Failure.jsp");
    requestDispatcher.forward(request, response);
	}
}
catch(Exception e)
{
	e.printStackTrace();
	}
%>