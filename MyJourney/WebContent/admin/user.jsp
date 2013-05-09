<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %> 
<html>
	<head>
		<link rel="stylesheet" href="../css/admin_ind.css" type="text/css"/>
		<script src="../js/admin.js" type="text/javascript"></script>
		<script src="../js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
		var enableEditJ=0;
		function eNsComm(){
			if(enableEditJ==0){
				var nodes=document.getElementsById('p_input');
				for(var i=0;i<nodes.length;i++){
					nodes.item(i).disabled=false;
				}
				var text=document.getElementById('edit_u').textContent='save';
				enableEditJ=1;
			}else if(enableEditJ==1){
				var nodes=document.getElementsByClassName('p_input');
				for(var i=0;i<nodes.length;i++){
					nodes.item(i).disabled=true;
				}
				var text=document.getElementById('edit_u').textContent='edit';
				var u_id=$('[name="user_id"]').val();
				var u_account=$('[name="user_account"]').val();
				var u_age=$('[name="user_age"]').val();
				var u_city=$('[name="user_city"]').val();
				var u_email=$('[name="user_email"]').val();
				var u_name=$('[name="user_name"]').val();
				var u_phone=$('[name="user_phone"]').val();
				var u_pwd=$('[name="user_pwd"]').val();
				var u_sex=$('[name="user_sex"]').val();
				var u_image=$('[name="user_image"]').val();
				
				$.ajax({
					type:'post',
					url:'adminedituser2.action',
					data:{u_id:u_id,u_account:u_account,u_age:u_age,u_city:u_city,u_email:u_email,u_name:u_name,u_phone:u_phone,u_pwd:u_pwd,u_sex:u_sex,u_image:u_image},
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
		</script>
		<title>Admin Index</title>
	</head>
	<body>
		<%
			User user=(User)ActionContext.getContext().getSession().get("view_user");
			String adminEmail=(String)ActionContext.getContext().getSession().get("email");
			List<Comment> comments=(List<Comment>)ActionContext.getContext().getSession().get("user_comments");
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
					<li class="navi_li_selected">User Management</li>
					<li class="navi_li"><a href="adminJourneyManagement.action" class="other_lnk">Journey Management</a></li>
					<li class="navi_li"><a href="" class="other_lnk">Cities</a></li>
					<li class="navi_li"><a href="batchjobs.jsp" class="other_lnk">Batch Jobs</a></li>
				</ul>
			</div>
			<div id="content">
				User Profile
				<div class='sep'></div>
				<div id="user_p" align='right'>
					<form action="register" method="post">
						<input name="user_id" disabled='true' type='hidden' class='p_input' value='<%out.print(user.getUid()); %>'/>
						<span class="label">account</span>
						<input type="text" name="user_account" disabled='true' class='p_input' value='<%out.print(user.getAccount()); %>'/><br/><br/>
						<span class="label">age</span>
						<input type="number" name="user_age" disabled='true' class='p_input' value='<%out.print(user.getAge()); %>'/><br/><br/>
						<span class="label">city</span>
						<input type="text" name="user_city" disabled='true' class='p_input' value='<%out.print(user.getCity()); %>'/><br/><br/>
						<span class="label">email</span>
						<input type="email" name="user_email" disabled='true' class='p_input' value='<%out.print(user.getEmail()); %>'/><br/><br/>
						<span class="label">name</span>
						<input type="text" name="user_name" disabled='true' class='p_input' value='<%out.print(user.getName()); %>'/><br/><br/>
						<span class="label">phone</span>
						<input type="tel" name="user_phone" disabled='true' class='p_input' value='<%out.print(user.getPhone()); %>'/><br/><br/>
						<span class="label">password</span>
						<input type="password" name="user_pwd" disabled='true' class='p_input' value='<%out.print(user.getPwd()); %>'/><br/><br/>
						<span class="label">Sex</span>
						<select name='user_sex' disabled='true' class='p_input'>
						<%
							if(user.getSex()==0){
								out.print("<option value='0' name='user.sex'>Female</option>"+
										"<option value='1' name='user.sex'>Male</option>");
							}else{
								out.print("<option value='1' name='user.sex'>Male</option>"+
									"<option value='0' name='user.sex'>Female</option>");
							}						
						%></select><br/><br/>
						<span class="label">avatar upload</span>
						<input type="file" name="user_image" accept="images/*" disabled='true' class='p_input' value='<%out.print(user.getImage()); %>>' /><br/><br/>
						<div align="right" id="add_sbmt">
							<span id='edit_u' onclick='eNdEditJ()'>edit</span>
						</div>
					</form>
				</div>
				<div id='user_comments'>
					User Comments
					<div class='sep'></div>
					
					
					<%for(int i=0;i<comments.size();i++){
						out.print("<div class='c_row'>");
						out.print("<span class='c_u_account'>"+user.getAccount()+"</span>");
						out.print("&nbsp;comments to&nbsp");
						out.print("<a href='adminViewHotel.action?hid="+comments.get(i).getHotel().getId()+"'>"+comments.get(i).getHotel().getName()+"</a>&nbsp;");
						out.print("<a href='adminViewAttraction.action?aid="+comments.get(i).getAttraction().getId()+"'>"+comments.get(i).getAttraction().getName()+"</a>&nbsp;");
						out.print("<a href='adminViewRestaurant.action?rid="+comments.get(i).getAttraction().getId()+"'>"+comments.get(i).getRestaurant().getName()+"</a>&nbsp;");
						out.print("<span class='says'><I><B>Says</B></I></span><br/><br/>");
						out.print("<form>"+
								  "<input type='hidden' value='"+comments.get(i).getId()+"'/>"+
								  "<input disabled=true id='comm"+comments.get(i).getId()+"' name='comment.context' value='"+comments.get(i).getContext()+"'/>"+
								"</form>");
						out.print("<div align='right'><span id='edit_c' onclick='eNsComm("+comments.get(i).getId()+")'>edit</span>&nbsp;<span>delete</span></div>");
						out.print("</div>");
						out.print("<div class='sep'></div>");
					}%>
				</div>
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>