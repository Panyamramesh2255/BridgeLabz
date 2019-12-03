<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.util.*" import="java.sql.Connection"%>
<%!
String uname;
String upwd;
String uemail;
String umob;
Connection con;
PreparedStatement ps;
ResultSet rs;
RequestDispatcher requestdispatcher=null;
%>
<%
try{
session.setAttribute("operation", "Registration");
uname=request.getParameter("uname");
upwd=request.getParameter("upwd");
uemail=request.getParameter("uemail");
umob=request.getParameter("umob");
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Design_patterns?useSSL=false", "root", "password");
ps=con.prepareStatement("select * from reg_user where uname=? and upwd=?");
ps.setString(1, uname);
ps.setString(2, upwd);
rs=ps.executeQuery();
boolean b=rs.next();
RequestDispatcher requestdispatcher=null;
if(b==true)
{
	requestdispatcher=application.getRequestDispatcher("/Existed.jsp");
	requestdispatcher.forward(request, response);
	}
else
{
	ps=con.prepareStatement("insert into reg_user values(?,?,?,?)");
	ps.setString(1 ,uname);
	ps.setString(2,upwd);
	ps.setString(3 ,uemail);
	ps.setString(4 ,umob);
	int rowcount=ps.executeUpdate();
	if(rowcount==1)
	{
		requestdispatcher=application.getRequestDispatcher("/Sucess.jsp");
		requestdispatcher.forward(request, response);
	}
	else
	{
		//requestdispatcher=application.getRequestDispatcher("Failure.jsp");
		requestdispatcher.forward(request, response);
	}
	
	}
}
catch(Exception e)
{
	e.printStackTrace();
	try{
		//requestdispatcher=application.getRequestDispatcher("Failure.jsp");
		requestdispatcher.forward(request, response);
		
	}catch(Exception e1)
	{
	e1.printStackTrace();	
	}
	}


%>