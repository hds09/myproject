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
		function deleteJourneys(){
			var idList=[];
			var ids="";
			$(".row_check").each(function(){
			    var $this = $(this);
			    if($this.is(":checked")){
			    	idList.push($this.attr("id"));
			    }
			});
			for(var i=0;i<idList.length;i++){
				ids=idList[i]+"+"+ids;
			}
			if(ids!=""){
				$.ajax({
					type:'post',
					url:'admindeletejourney.action',
					data:{ids:ids},
					dataType:"json",  
					success: function(data){
						
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {   
	                     
		            },  
				});
				alert("success");
				location.href="adminJourneyManagement.action";
			}else{
				alert("illegal!");
			}
			
		}
		</script>
		<title>Admin Index</title>
	</head>
	<body>
		<%
			List<Journey> journeys=(List<Journey>)ActionContext.getContext().getSession().get("journeys");
			int size=journeys.size();
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
				<div id="search_user">
					<div id="s_options">
						<form action="adminsearchjourney" method="post">
							<div class="option">
								<span class="option_text">key word</span>
								<input type="text" name="j_keyword" />
							</div>
							<div class="option">
								<span class="option_text">type</span>
								<select name="j_type">
								<option value="all">All</option>
								<option value="p">personal</option>
								<option value="t">team</option>
								</select>
							</div>
							<div class="option">
								<input type="submit" value="search" />
							</div>
						</form>
					</div>
				</div>
				<div id="tableCon">
					<table id="user_table">
						<tr class="row">
							<th>check</th>
							<th>ID</th>
							<th>Journey Name</th>
							<th>State</th>
							<th>Journey Owner</th>
							<th>Operation</th>
						</tr>
						<%
							if(size==0){
								out.print("no rows found");
							}
							for(int i=0; i<size;i++){
								out.print("<tr class='row' id='"+"tr"+journeys.get(i).getId()+"'>"+
								"<td><input type='checkbox' class='row_check' id='"+journeys.get(i).getId()+"'/></td>"+
								"<td class='id"+journeys.get(i).getId()+"'>"+journeys.get(i).getId()+"</td>"+
								"<td class='td"+journeys.get(i).getId()+"'>"+journeys.get(i).getJourneyName()+"</td>"+
								"<td class='td"+journeys.get(i).getId()+"'>"+journeys.get(i).getState()+"</td>"+
								"<td class='td"+journeys.get(i).getId()+"'>"+journeys.get(i).getUser().getAccount()+"</td>"+
								"<td><span class='op_text'><a href='adminViewJourney.action?vid="+journeys.get(i).getId()+"'>detail</a></span></td>"+
								"</tr>");
							}
						%>
					</table>
					<div id="action_div" align="right">
						<span class="action_txt" onclick='deleteJourneys()'>Delete</span>
					</div>
				</div>
				<div id="rowContentDiv">
					
				</div>
				
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>