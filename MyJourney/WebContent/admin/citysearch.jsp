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
			List<City> cities=null;
			List<Hotel> hotels=null;
			List<Attraction> attractions=null;
			List<Restaurant> restaurants=null;
			String s_type=(String)ActionContext.getContext().getSession().get("search_type");
			if(s_type.equals("1")){
				cities=(List<City>)ActionContext.getContext().getSession().get("search_cities");
			}else if(s_type.equals("2")){
				hotels=(List<Hotel>)ActionContext.getContext().getSession().get("search_hotels");
			}else if(s_type.equals("3")){
				restaurants=(List<Restaurant>)ActionContext.getContext().getSession().get("search_rests");
			}else if(s_type.equals("2")){
				attractions=(List<Attraction>)ActionContext.getContext().getSession().get("search_attrs");
			}
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
				<div id='cities'>
					<%
						if(s_type.equals("1")){
							out.print("Cities Search Result");
						}else if(s_type.equals("2")){
							out.print("Hotels Search Result");
						}else if(s_type.equals("3")){
							out.print("Restaurants Search Result");
						}else if(s_type.equals("4")){
							out.print("Attractions Search Result");
						}
					%>
					Cities
					<div id="tableCon">
						<table id="user_table">
							<%
							if(s_type.equals("1")){
								out.print("<tr class='row'>"+
										"<th>check</th>"+
										"<th>ID</th>"+
										"<th>Country</th>"+
										"<th>Latitude</th>"+
										"<th>Longitude</th>"+
										"<th>Name</th>"+
										"<th>Picture</th>"+
										"<th>Operations</th>"+
									"</tr>");
								if(cities.size()==0){
									out.print("no rows found");
								}else{
									for(int i=0; i<cities.size();i++){
										out.print("<tr class='row' id='"+"tr"+cities.get(i).getCid()+"'>"+
										"<td><input type='checkbox' class='row_check' id='city+"+cities.get(i).getCid()+"'/></td>"+
										"<td class='cityid"+cities.get(i).getCid()+"'>"+cities.get(i).getCid()+"</td>"+
										"<td class='citytd"+cities.get(i).getCid()+"'>"+cities.get(i).getCountry()+"</td>"+
										"<td class='citytd"+cities.get(i).getCid()+"'>"+cities.get(i).getLat()+"</td>"+
										"<td class='citytd"+cities.get(i).getCid()+"'>"+cities.get(i).getLng()+"</td>"+
										"<td class='citytd"+cities.get(i).getCid()+"'>"+cities.get(i).getName()+"</td>"+
										"<td class='citytd"+cities.get(i).getCid()+"'>"+cities.get(i).getPicture()+"</td>"+
														
										"<td><span class='op_text'><a href='adminViewCity.action?cid="+cities.get(i).getCid()+"'>detail</a></span></td>"+
										"</tr>");
									}
								}
							}else if(s_type.equals("2")){
								out.print("<tr class='row'>"+
										"<th>check</th>"+
										"<th>ID</th>"+
										"<th>Address</th>"+
										"<th>Dislike</th>"+
										"<th>Favor</th>"+
										"<th>Name</th>"+
										"<th>Phone</th>"+
										"<th>Price</th>"+
										"<th>HotelCity</th>"+
										"<th>Operations</th>"+
									"</tr>");
								if(hotels.size()==0){
									out.print("no rows found");
								}
								for(int i=0; i<hotels.size();i++){
									out.print("<tr class='row' id='"+"tr"+hotels.get(i).getId()+"'>"+
									"<td><input type='checkbox' class='row_check' id='hotel+"+hotels.get(i).getId()+"'/></td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getId()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getAddress()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getDislike()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getFavor()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getName()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getPhone()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getPrice()+"</td>"+
									"<td class='hoteltd"+hotels.get(i).getId()+"'>"+hotels.get(i).getCity().getName()+"</td>"+
									"<td><span class='op_text'><a href='adminViewHotel.action?hid="+hotels.get(i).getId()+"'>detail</a></span></td>"+
									"</tr>");
								}
							}else if(s_type.equals("3")){
								out.print("<tr class='row'>"+
										"<th>check</th>"+
										"<th>ID</th>"+
										"<th>Address</th>"+
										"<th>Dislike</th>"+
										"<th>Favor</th>"+
										"<th>Name</th>"+
										"<th>Phone</th>"+
										"<th>Price</th>"+
										"<th>RestaurantCity</th>"+
										"<th>Operations</th>"+
									"</tr>");
								if(restaurants.size()==0){
									out.print("no rows found");
								}
								for(int i=0; i<restaurants.size();i++){
									out.print("<tr class='row' id='"+"tr"+restaurants.get(i).getId()+"'>"+
									"<td><input type='checkbox' class='row_check' id='restaurant+"+restaurants.get(i).getId()+"'/></td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getId()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getAddress()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getDislike()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getFavor()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getName()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getPhone()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getPrice()+"</td>"+
									"<td class='restauranttd"+restaurants.get(i).getId()+"'>"+restaurants.get(i).getCity().getName()+"</td>"+
									"<td><span class='op_text'><a href='adminViewRestaurant.action?rid="+restaurants.get(i).getId()+"'>detail</a></span></td>"+
									"</tr>");
								}
							}else if(s_type.equals("4")){
								out.print("<tr class='row'>"+
										"<th>check</th>"+
										"<th>ID</th>"+
										"<th>Address</th>"+
										"<th>Dislike</th>"+
										"<th>Favor</th>"+
										"<th>Name</th>"+
										"<th>Price</th>"+
										"<th>AttractionCity</th>"+
										"<th>Operations</th>"+
									"</tr>");
								if(attractions.size()==0){
									out.print("no rows found");
								}
								for(int i=0; i<attractions.size();i++){
									out.print("<tr class='row' id='"+"tr"+attractions.get(i).getId()+"'>"+
									"<td><input type='checkbox' class='row_check' id='attraction+"+attractions.get(i).getId()+"'/></td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getId()+"</td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getAddress()+"</td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getDislike()+"</td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getFavor()+"</td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getName()+"</td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getPrice()+"</td>"+
									"<td class='attractiontd"+attractions.get(i).getId()+"'>"+attractions.get(i).getCity().getName()+"</td>"+
									"<td><span class='op_text'><a href='adminViewAttraction.action?aid="+attractions.get(i).getId()+"'>detail</a></span></td>"+
									"</tr>");
								}
							}
							%>
						</table>
						<div id="action_div" align="right">
							<span class="action_txt" onclick='deleteJourneys()'>Delete</span>
						</div>
					</div>
				</div>
				
				
			</div>
			<div id="global_footer"></div>
		</div>
		
	</body>
</html>