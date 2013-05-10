<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.*" %>
<%@ page import="edu.nju.MyJourney.model.Journey" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %> 
;
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="../css/myroutes.css" type="text/css"/>
		<link rel="stylesheet" href="../css/master.css" type="text/css"/>
		<link rel="stylesheet" href="../css/jquery-ui-1.10.2.custom.css" type="text/css"/>
		<script src="../js/myroutes.js" type="text/javascript"></script>
		<script src="../js/jquery.js" type="text/javascript"></script>
		<script src="../js/jquery-ui-1.10.2.custom.js"></script>
		<script type="text/javascript">
			
		</script>
		<title>酒店列表</title>
	</head>
	<body>
		<%
			List<Hotel> hotels=(List<Hotel>)ActionContext.getContext().getSession().get("allHotels");
			List<Hotel> hots=(List<Hotel>)ActionContext.getContext().getSession().get("hotHotels");
			Long uid=(Long)ActionContext.getContext().getSession().get("Auuid");
		%>
		<header>
			<h1>Where You Will Go</h1>
		</header>
		<nav>
			<ul>
				<li><a href="index">首页</a></li>
				<li><a href="Hotels">酒店</a></li>
				<li><a href="Restaurants">饭店</a></li>
				<li><a href="makeRoute">旅程</a></li>
				<li><a href="/MyJourney/pic/picwall">旅图</a></li>
				<li class="selected"><a href="">管理</a></li>
				<li><a href="personCenterSelect1">个人中心</a></li>
				<li class="subscribe"><a href="#"></a></li>
			</ul>
		</nav>
		<div id="containAll">
			<div id="text_div"><span>酒店列表</span></div>
			<div class="seperator"></div>
			<!-- menu-->
				<div id='searchHdiv' align='center'>
					<form action='HotelSearch' method='post'>
						<input id='search_field' type='text' name='keyword' style='width:300px;height:30px' />
						<input type='submit' value='搜一下'/>
					</form>
				</div>
				<div id='hots'>
					<span class='hotText'>热门酒店</span>
					<%
						int hsize=hots.size();
						for(int i=0;i<hsize;i++){
							out.print("<div class='hot1'>");
							out.print("<span class='hotTitle'>"+hots.get(i).getName()+"</span>&nbsp;&nbsp;&nbsp;");
							out.print("<a class='seeDetail' href='userviewHotel?hid="+hots.get(i).getId()+"&uid="+uid+"'>详情</a>");
							out.print("</div>");
						}
					%>
				</div>
				<div id='hlist'>
						<%
							int all=hotels.size();
							for(int i=0;i<all;i++){
								out.print("<div class='resultRow2'>");
								out.print("<span class='lTitle'>"+hotels.get(i).getName()+"</span><br/>");
								out.print("<span class='opop'>所在城市:</span>&nbsp;");
								out.print("<span class='opop'>"+hotels.get(i).getCity().getName()+"</span>&nbsp;&nbsp;&nbsp;&nbsp;");
								out.print("<span class='opop'>地址:</span>&nbsp;");
								out.print("<span class='opop'>"+hotels.get(i).getAddress()+"</span>&nbsp;&nbsp;&nbsp;&nbsp;");
								out.print("<span class='opop'>电话:</span>&nbsp;");
								out.print("<span class='opop'>"+hotels.get(i).getPhone()+"</span>&nbsp;&nbsp;&nbsp;&nbsp;");
								out.print("<span class='opop'>价格:</span>&nbsp;");
								out.print("<span class='opop'>"+hotels.get(i).getPrice()+"</span>&nbsp;&nbsp;&nbsp;&nbsp;");
								out.print("<a class='seeDetail' href='userviewHotel?hid="+hots.get(i).getId()+"&uid="+uid+"'>了解更多</a>&nbsp;&nbsp;&nbsp;&nbsp;");
								out.print("</div>");
								out.print("<div class='mysep'></div>");
							}
						%>
				</div>
			
			<div id="globalFooter">
			</div>
			
		</div>
		<footer>
		<div>
			<section id="about">
				<header>
					<h3>About</h3>
				</header>
				<p> <a href="#">云游网是一个集合网络社交的旅游行程规划网站</a> </br>
				<a href="#">你的加入会使得世界变得从此不同</a>
				</p>
			</section>
			<section id="blogroll">
				<header>
					<h3>Blogroll</h3>
				</header>
				<ul>
					<li><a href="#">NETTUTS+</a></li>
					<li><a href="#">FreelanceSwitch</a></li>
					<li><a href="#">In The Woods</a></li>
					<li><a href="#">Netsetter</a></li>
					<li><a href="#">PSDTUTS+</a></li>
				</ul>
			</section>
		</div>
	</footer>
	</body>
	<footer>
	</footer>
</html>