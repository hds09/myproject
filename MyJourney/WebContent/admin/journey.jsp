<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.User" %>
<%@ page import="edu.nju.MyJourney.model.Journey" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %> 
<html>
	<head>
		<link rel="stylesheet" href="../css/admin_j.css" type="text/css"/>
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
			var enableEditJ=0;
			function isXML(input){
				var value = input.value;
		        var res = value.indexOf('.xml');
		        if(res==-1){
		        	alert("wrong file extension");
		        }
			}
			function showMore(index){
				var id='row'+index;
				document.getElementById(id).style.display='block';
			}
			
			function eNdEditJ(){
				if(enableEditJ==0){
					var nodes=document.getElementsByClassName('disabledForms');
					for(var i=0;i<nodes.length;i++){
						nodes.item(i).disabled=false;
					}
					var text=document.getElementById('edit_j').textContent='save';
					enableEditJ=1;
				}else if(enableEditJ==1){
					var nodes=document.getElementsByClassName('disabledForms');
					for(var i=0;i<nodes.length;i++){
						nodes.item(i).disabled=true;
					}
					var text=document.getElementById('edit_j').textContent='edit';
					var jid=$('[name="j_id"]').val();
					var jname=$('[name="j_name"]').val();
					var jowner=$('[name="j_owner"]').val();
					var jtype=$('[name="j_type"]').val();
					alert(jname);
					$.ajax({
						type:'post',
						url:'admineditjourney.action',
						data:{jid:jid,jname:jname,jowner:jowner,jtype:jtype},
						dataType:"json",  
						success: function(data){
							alert("success");
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {   
		                     
			            },  
					});
					enableEditJ=0;
				}
			}
			
			function deleteUserFromTeam(jid,uid,tid){
				$.ajax({
					type:'post',
					url:'adminkickuser.action',
					data:{jid:jid,kick_uid:uid,kick_tid:tid},
					dataType:"json",  
					success: function(data){
						alert("success");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {   
	                     
		            },  
				});
			}
		</script>
		<title>Journey</title>
	</head>
	<body>
		<%
			Journey j=(Journey)ActionContext.getContext().getSession().get("view_j");
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
					<li class="navi_li"><a href="" class="other_lnk">Cities</a></li>
					<li class="navi_li"><a href="batchjobs.jsp" class="other_lnk">Batch Jobs</a></li>
				</ul>
			</div>
			<div id="content">
				Journey Info
				<div id="j_content">
					<form disabled="true">
						<div class='content_row'>
							<span class='journey_text'>Journey Name</span>
							<input name='j_id' type='hidden' value='<%out.print(j.getId()); %>' />
							<input id='input_jname' name='j_name' value='<%out.print(j.getJourneyName()); %>' disabled='true' class='disabledForms'/>
						</div>
						<div class='content_row'>
							<span class='journey_text'"'>Journey Owner</span>
							<input name='j_owner' value='<%out.print(j.getUser().getAccount()); %>' disabled='true' class='disabledForms'/>
						</div>
						<div class='content_row'>
							<span class='journey_text'>Journey Type</span>
							<select name='j_type' disabled='true' class='disabledForms'>
								<%
									if(j.getState()==0){
										out.print("<option value='0'>Team</option>"+
												"<option value='1'>Personal</option>");
									}else{
										out.print("<option value='1'>Personal</option>"+
											"<option value='0'>Team</option>");
									}
								%>
								
							</select>
							&nbsp;&nbsp;<span id='edit_j' class='editNsave' onclick='eNdEditJ()'>edit</span>
						</div>
					</form>
				</div>
				
				<div id="Members">
					<%
						if(j.getTeam()!=null && j.getTeam().getUsers()!=null){
							out.print("Members");
							int msize=j.getTeam().getUsers().size();
							for(int i=0;i<msize;i++){
								out.print("<div class='m_row'>"+
								"<span class='user_text'><a href='adminViewUser.action?uid="+j.getTeam().getUsers().get(i).getUid()+"'>"+j.getTeam().getUsers().get(i).getAccount()+"</a></span>&nbsp;<span class='delte_text' onclick='deleteUserFromTeam("+j.getId()+","+j.getTeam().getUsers().get(i).getUid()+","+j.getTeam().getTid()+")'>X</span>"+
								"</div>");
							}
						}
					%>
				</div>
				<div id="Places">
					Places
					<div class='p_row'>
					<%
						if(j.getPlaces()!=null){
							out.print(""+
						      "<table id='p_table'>"+
							"<tr class='p_table_tr'>"+
							"<th>id</th><th>time</th><th>half_day</th><th>traffic</th><th>hotel</th><th>attraction</th><th>restaurant</th><th>city</th>"+
							"</tr>");
							int psize=j.getPlaces().size();
							for(int i=0;i<psize;i++){
								out.print("<tr class='p_row_tr'>"+
								"<th>"+j.getPlaces().get(i).getId()+"</th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'>"+j.getPlaces().get(i).getTime()+"</th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'>"+j.getPlaces().get(i).getHalfday()+"</th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'>"+j.getPlaces().get(i).getTraffic()+"</th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'><a href='adminViewHotel.action?hid="+j.getPlaces().get(i).getHotel().getId()+"'>"+j.getPlaces().get(i).getHotel().getName()+"</a></th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'><a href='adminViewAttraction.action?aid="+j.getPlaces().get(i).getAttraction().getId()+"'>"+j.getPlaces().get(i).getAttraction().getName()+"</a></th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'><a href='adminViewRestaurant.action?rid="+j.getPlaces().get(i).getRestaurant().getId()+"'>"+j.getPlaces().get(i).getRestaurant().getName()+"</a></th>"+
								"<th class='rec"+j.getPlaces().get(i).getId()+"'><a href='adminViewCity.action?cid="+j.getPlaces().get(i).getCity().getCid()+"'>"+j.getPlaces().get(i).getCity().getName()+"</a></th>"+
								"</tr>");
							}
							out.print("</table>");
						}else{
							out.print("No Data!");
						}
					%>
					</div>
				</div>
				
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>