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
			function editRow(id,input){
				if(input.textContent=='edit'){
					var td_class='td'+id;
					var nodes=document.getElementsByClassName(td_class);
					for (var i=0;i<nodes.length;i++){
						nodes.item(i).contentEditable='true';
						nodes.item(i).style.backgroundColor = "#FCEFA1";
					}
					input.textContent='save';
				}else{
					var className='td'+id;
					var fields=$('.'+className); 
					$.ajax({
						type:'post',
						url:'adminedituser.action',
						data:{id:id,account:fields[0].textContent,age:fields[1].textContent,city:fields[2].textContent,
							email:fields[3].textContent,image:fields[4].textContent,name:fields[5].textContent,
							phone:fields[6].textContent,password:fields[7].textContent,sex:fields[8].textContent},
						dataType:"json",  
						error : function(XMLHttpRequest, textStatus, errorThrown) {   
		                    alert('status:'+XMLHttpRequest.status+' state:'+XMLHttpRequest.readyState);    
			            },  
					});
					var td_class='td'+id;
					var nodes=document.getElementsByClassName(td_class);
					for (var i=0;i<nodes.length;i++){
						nodes.item(i).contentEditable='false';
						nodes.item(i).style.backgroundColor = "#CCCCCC";
					}
					input.textContent='edit';
				}
			}
			function deleteUser(ids){
				$.ajax({
					type:'post',
					url:'admindeleteuser.action',
					data:{ids:ids},
					dataType:"json",  
					error : function(XMLHttpRequest, textStatus, errorThrown) {   
	                     
		            },  
				});
			}
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
			List<User> users=(List<User>)ActionContext.getContext().getSession().get("users");
			int size=users.size();
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
					<li class="navi_li_selected">User Management</li>
					<li class="navi_li"><a href="adminJourneyManagement.action" class="other_lnk">Journey Management</a></li>
				</ul>
			</div>
			<div id="content">
				<div id="search_user">
					<div id="s_options">
						<form action="adminsearchuser" method="post">
							<div class="option_word">
								<span class="option_text">key word</span>
								<input type="text" name="keyword" />
							</div>
							<div class="option">
								<span class="option_text">search by</span>
								<select name="field">
								<option value="all">All</option>
								<option value="account">Account</option>
								<option value="city">City</option>
								<option value="email">Email</option>
								<option value="name">Name</option>
								</select>
							</div>
							<div class="option">
								<span class="option_text">age</span>
								<select name="ageOption">
								<option value="age_all">All</option>
								<option value="age1">Below 20</option>
								<option value="age2">20 to 40</option>
								<option value="age3">40 to 60</option>
								<option value="age4">above 60</option>
								</select>
							</div>
							<div class="option">
								<span class="option_text">sex</span>
								<select name="sexOption">
								<option value="sex_all">All</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
								</select>
							</div>
							<div class="option">
								<span class="option_text">sort by</span>
								<select name="sortOption">
								<option value="default">No sort rule</option>
								<option value="agesort1">Age Low to High</option>
								<option value="agesort2">Age High to Low</option>
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
					<%
						if(size==0){
							out.print("no rows found");
						}
						for(int i=0; i<size;i++){
							out.print("<tr class='row' id='"+"tr"+users.get(i).getUid()+"'>"+
							"<td><input type='checkbox' class='row_check'/></td>"+
							"<td class='id"+users.get(i).getUid()+"'>"+users.get(i).getUid()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getAccount()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getAge()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getCity()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getEmail()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getImage()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getName()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getPhone()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getPwd()+"</td>"+
							"<td class='td"+users.get(i).getUid()+"'>"+users.get(i).getSex()+"</td>"+
							"<td><span class='op_text' onclick='editRow("+users.get(i).getUid()+",this)'>edit</span>&nbsp;<span class='op_text' onclick='deleteUser("+users.get(i).getUid()+")'>delete</span></td>"+
							"</tr>");
						}
					%>
				</table>
				<div id="preAnxt"></div>
				<div id="action_div" align="right">
					<span class="action_txt" onclick="showField(1)">Add User</span>
					<span class="action_txt" onclick="showField(2)">BatchUpload</span>
					<span class="action_txt">Delete</span>
				</div>
			</div>
			<div id="addUserDiv" style="display:none">
				<div class="closeDiv" align="right">
					<span onclick="hideField(1)">close</span>
				</div>
				<span>Fill User Profile</span>
				<div id="addUser" >
					<form action="register" method="post">
						<span class="label">account</span>
						<input type="text" name="user.account"/>
						<span class="label">age</span>
						<input type="number" name="user.age"/>
						<span class="label">city</span>
						<input type="text" name="user.city"/>
						<span class="label">email</span>
						<input type="email" name="user.email"/>
						<span class="label">name</span>
						<input type="text" name="user.name"/>
						<span class="label">phone</span>
						<input type="tel" name="user.phone"/>
						<span class="label">password</span>
						<input type="password" name="user.pwd"/>
						<span class="label">reType</span>
						<input type="password" name="password"/>
						<span class="label">Sex</span>
						<input name="user.sex" id="sex" type="radio" value="1" style="width:30px;" checked="checked">male
						<input name="user.sex" id="sex" type="radio" value="0" style="width:30px;margin-left:0px" >female
						<span class="label">avatar upload</span>
						<input type="file" name="user.image" accept="images/*" />
						<div align="right" id="add_sbmt">
							<input type="submit" value="submit"/>
						</div>
					</form>
					
				</div>
			</div>
			<div id="b_addUserDiv" style="display:none">
				<div class="closeDiv" align="right">
					<span onclick="hideField(2)">close</span>
				</div>
				<span>Select XML File</span>
				<div id="b_addUser" >
					<form name="batch_upload" action="userbatchupload"  method="post" enctype="multipart/form-data">
						<input type="file" name="userXml" onchange="isXML(this)"/>
						<input type="submit" value="add"/>
					</form>
				</div>
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>