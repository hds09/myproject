<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.User" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %> 
<html>
	<head>
		<link rel="stylesheet" href="../css/admin_ind.css" type="text/css"/>
		<script src="../js/admin.js" type="text/javascript"></script>
		<script src="../js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
			function isXML(input){
				var value = input.value;
		        var res = value.indexOf('.xml');
		        if(res==-1){
		        	alert("wrong file extension");
		        }
			}
		</script>
		<title>Admin Index</title>
	</head>
	<body>
		<%
			String adminEmail=(String)ActionContext.getContext().getSession().get("email");
		%>
		<div id="container">
			<div class="global_header">
				<div class="header_left">
					<img src="../images/sdd09/admin_key.jpg"/><span>MyJourney Admin Portal</span>
				</div>
				<div class="header_right" align="right">
					<span class="version">Welcome </span><span class="admin_name"><%out.print(adminEmail); %><span>
					<br/><span class="logout_lnk"><a href="adminlogout.action">Logout</a></span>
				</div>
			</div>
			<div class="sep"></div>
			<div id="left_navi">
				<span>Navigation</span>
				<ul class="navi">
					<li class="navi_li"><a href="adminIndex.action" class="other_lnk">User Management</a></li>
					<li class="navi_li_selected">Journey Management</li>
				</ul>
			</div>
			<div id="content">
				<div id="search_user">
					<div id="s_options">
						<form action="adminsearchjourney" method="post">
							<div class="option_word">
								<span class="option_text">key word</span>
								<input type="text" name="keyword" />
							</div>
							<div class="option">
								<span class="option_text">time range</span>
								<select name="timeRange">
								<option value="all">All</option>
								<option value="account">recent 1 month</option>
								<option value="city">recent 3 months</option>
								<option value="email">recent 1 year</option>
								</select>
							</div>
							<div class="option">
								<span class="option_text">status</span>
								<select name="statusOption">
								<option value="status_all">All</option>
								<option value="status1">finished</option>
								<option value="status2">ongoing</option>
								<option value="status3">not started</option>
								</select>
							</div>
							<div class="option">
								<span class="option_text">sort by</span>
								<select name="sortOption">
								<option value="default">No sort rule</option>
								<option value="agesort1">Members Low to High</option>
								<option value="agesort2">Members High to Low</option>
								<option value="agesort2">Rate High to Low</option>
								<option value="agesort2">Rate High to Low</option>
								</select>
							</div>
							<div class="option">
								<input type="submit" value="search" />
							</div>
						</form>
					</div>
				</div>
				<table id="user_table">
					<tr class="row">
						<th>check</th>
						<th>User ID</th>
						<th>Account</th>
						<th>Age</th>
						<th>City</th>
						<th>Email</th>
						<th>Image</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Password</th>
						<th>Sex</th>
						<th>Operation</th>
					</tr>
				</table>
				<div id="preAnxt"></div>
				<div id="action_div" align="right">
					<span class="action_txt" onclick="showField(1)">Add User</span>
					<span class="action_txt" onclick="showField(2)">BatchUpload</span>
					<span class="action_txt">Delete</span>
				</div>
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>