<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Welcome Page</title>
</head>

<jsp:useBean id="name" scope="session" class="java.lang.String" />

<body>
<table width="650" border="0" >
  <tr>
    <td width="650" height="80" background="<%=request.getRealPath("")+"/image/top.jpg"%>">&nbsp;</td>
  </tr>
  <tr>
    <td >
	<a href="<%=request.getContextPath()+"/user/login.jsp" %>">Login</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()+"/user/register.jsp" %>">Register</a>&nbsp;&nbsp;
	<a href="logout.do">Log out</a>&nbsp;&nbsp;
	<a href="loadUser.do">My Profile</a>&nbsp;&nbsp;
	<%
	 	String myuserid=(String)session.getAttribute("userid");
	%>
	<a href="showMyStock.do?userid="<%=myuserid%>">My Stock</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()+"/ShowTrade?userid="%>"+"<%=myuserid%>">History</a>&nbsp;&nbsp;
	<a href="showWatchList.do">Watch List</a>&nbsp;&nbsp;
	<a href="index.do">Order Cancellation</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()+"/stock/search.jsp" %>">Search</a>
	</td>
  </tr>
  
  <tr>
   	<td>
   		<font color="green"><%=name%>,Welcome!</font><br>
   	</td>
  </tr>
</table>



</body>
</html>


