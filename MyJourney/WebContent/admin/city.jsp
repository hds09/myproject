<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.*" %>
<%@ page import="edu.nju.MyJourney.model.Journey" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %> 
<html>
	<head>
		<link rel="stylesheet" href="../css/admin_j.css" type="text/css"/>
		<script src="../js/admin.js" type="text/javascript"></script>
		<script src="../js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">

			var enableEditH=0;
			
			function eNsHotel(){
				if(enableEditH==0){
					var nodes=document.getElementsByClassName('h_profile_input');
					for(var i=0;i<nodes.length;i++){
						nodes.item(i).disabled=false;
					}
					var text=document.getElementById('edit_h').textContent='save';
					enableEditH=1;
				}else if(enableEditH==1){
					var nodes=document.getElementsByClassName('h_profile_input');
					for(var i=0;i<nodes.length;i++){
						nodes.item(i).disabled=true;
					}
					var text=document.getElementById('edit_h').textContent='edit';
					enableEditH=0;
				}
			}
		</script>
		<title>Journey</title>
	</head>
	<body>
		<%
			City h=(City)ActionContext.getContext().getSession().get("view_c");
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
					<li class="navi_li_selected">Cities</li>
					<li class="navi_li"><a href="batchjobs.jsp" class="other_lnk">Batch Jobs</a></li>
				</ul>
			</div>
			<div id="content">
				City Info
				<div id="j_content">
					<div id='hotel_profile' align='right'>
						<form disabled="true">
							<div align='center'><img alt="city" src='../images/<%out.print(h.getPicture()); %>.PNG'></div><br/>
							<span class='h_text'>Country</span>
							<input name='city.country' value='<%out.print(h.getCountry()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Latitude</span>
							<input name='city.lat' value='<%out.print(h.getLat()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Longitude</span>
							<input name='city.lng' value='<%out.print(h.getLng()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Name</span>
							<input name='city.name' value='<%out.print(h.getName()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Image</span>
							<input name='city.image' type='file' value='<%out.print(h.getPicture()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<div id='edit_panel' align='right'>
							<br/>
								<span id='edit_h' class='edit_t' onclick='eNsHotel(<%out.print(h.getCid()); %>)'>edit</span>
							</div>
						</form>
					</div>
				</div>
				Hotels
				<div class='c_hotels'>
					<%
						int hsize=h.getHotels().size();
						for(int i=0;i<hsize;i++){
							out.print("<a href='adminViewHotel.action?hid="+h.getHotels().get(i).getId()+"'>"+h.getHotels().get(i).getName()+"</a>");
						}
					%>
				</div>
				Restaurants
				<div class='c_hotels'>
					<%
						int rsize=h.getRestaurants().size();
						for(int i=0;i<rsize;i++){
							out.print("<a href='adminViewRestaurant.action?rid="+h.getRestaurants().get(i).getId()+"'>"+h.getRestaurants().get(i).getName()+"</a>");
						}
					%>
				</div>
				Attractions
				<div class='c_hotels'>
					<%
						int asize=h.getAttractions().size();
						for(int i=0;i<asize;i++){
							out.print("<a href='adminViewAttraction.action?aid="+h.getAttractions().get(i).getId()+"'>"+h.getAttractions().get(i).getName()+"</a>");
						}
					%>
				</div>
					
				
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>