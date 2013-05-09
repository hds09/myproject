<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.User" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %> 
<html>
	<head>
		<link rel="stylesheet" href="../css/admin_ind.css" type="text/css"/>
		<link rel="stylesheet" href="../css/admin_bat.css" type="text/css"/>
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
		<title>Admin Batch Jobs</title>
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
					<li class="navi_li"><a href="adminJourneyManagement.action" class="other_lnk">Journey Management</a></li>
					<li class="navi_li"><a href="adminCityManagement.action" class="other_lnk">Cities</a></li>
					<li class="navi_li_selected">Batch Jobs</li>
				</ul>
			</div>
			<div id="content">
				<span>Batch Jobs<span>
				<div class="job">
					<span class="job_title">1. User Profile Batch Upload</span><br/>
					<span class="job_desc">select XML file</span>
					<form name="batch_upload" action="userbatchupload"  method="post" enctype="multipart/form-data">
						<input type="file" name="userXml" onchange="isXML(this)"/>
						<input type="submit" value="add"/>
					</form>
				</div>
				<div class="job">
					<span class="job_title">2. Journey Batch Upload</span><br/>
					<span class="job_desc">select XML file</span>
					<form action="journeybatchupload"  method="post" enctype="multipart/form-data">
						<input type="file" name="journeyXml"/>
						<input type="submit" value="add"/>
					</form>
				</div>
				<div class="job">
					<span class="job_title">3. Cities Batch Upload</span><br/>
					<span class="job_desc">select XML file</span>
					<form action="citybatchupload" method="post" enctype="multipart/form-data">
						<input type="file" name="cityXml"/>
						<input type="submit" value="add"/>
					</form>
				</div>
				<div class="job">
					<span class="job_title">4. Hotels Batch Upload</span><br/>
					<span class="job_desc">select XML file</span>
					<form action="hotelbatchupload"  method="post" enctype="multipart/form-data">
						<input type="file" name="hotelXml"/>
						<input type="submit" value="add"/>
					</form>
				</div>
				<div class="job">
					<span class="job_title">5. Attractions Batch Upload</span><br/>
					<span class="job_desc">select XML file</span>
					<form action="attractionbatchupload"  method="post" enctype="multipart/form-data">
						<input type="file" name="attractionXml"/>
						<input type="submit" value="add"/>
					</form>
				</div>
				<div class="job">
					<span class="job_title">6. Restaurants Batch Upload</span><br/>
					<span class="job_desc">select XML file</span>
					<form action="restbatchupload"  method="post" enctype="multipart/form-data">
						<input type="file" name="restXml"/>
						<input type="submit" value="add"/>
					</form>
				</div>
			</div>
			
			
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>