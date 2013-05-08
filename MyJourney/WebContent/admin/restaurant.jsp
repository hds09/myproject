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
			Restaurant h=(Restaurant)ActionContext.getContext().getSession().get("view_r");
			String adminEmail=(String)ActionContext.getContext().getSession().get("email");
			List<City> cities=(List<City>)ActionContext.getContext().getSession().get("cities");
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
				Restaurant Info
				<div id="j_content">
					<div id='hotel_profile' align='right'>
						<form disabled="true">
							<span class='h_text'>Hotel Name</span>
							<input name='hotel.name' value='<%out.print(h.getName()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Hotel Address</span>
							<input name='hotel.address' value='<%out.print(h.getAddress()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Hotel Phone</span>
							<input name='hotel.phone' value='<%out.print(h.getPhone()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Price</span>
							<input name='hotel.price' value='<%out.print(h.getName()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>People Like</span>
							<input name='hotel.price' value='<%out.print(h.getFavor()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>Price</span>
							<input name='hotel.price' value='<%out.print(h.getDislike()); %>' class='h_profile_input' disabled=true/><br/><br/>
							<span class='h_text'>City</span>
							<select name='hotel.price' class='h_profile_input' disabled=true>
								<%
									int cid=h.getCity().getCid();
									out.print("<option value ='"+cid+"'>"+h.getCity().getName()+"</option>");
									int csize=cities.size();
									for(int i=0;i<csize;i++){
										if(cid==cities.get(i).getCid()){
											continue;
										}else{
											out.print("<option value ='"+cities.get(i).getCid()+"'>"+cities.get(i).getName()+"</option>");
										}
									}
								%>
							</select>
							<div id='edit_panel' align='right'>
							<br/>
								<span id='edit_h' class='edit_t' onclick='eNsHotel(<%out.print(h.getId()); %>)'>edit</span>
							</div>
						</form>
					</div>
				</div>
				
				
				
					
				
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>