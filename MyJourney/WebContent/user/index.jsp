<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.*" %>
<%@ page import="edu.nju.MyJourney.model.Journey" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %> 
<%@ page import="edu.nju.MyJourney.helperModel.*" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>云游</title>
	<link rel="stylesheet" href="../css/master.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../css/index_a.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../css/shade.css" type="text/css" media="screen" />
	<script src="../js/jquery.js" type="text/javascript"></script>
</head>
<body>

<script type="text/javascript">
//弹出隐藏层
function ShowDiv(show_div,bg_div){
document.getElementById(show_div).style.display='block';
document.getElementById(bg_div).style.display='block' ;
var bgdiv = document.getElementById(bg_div);
bgdiv.style.width = document.body.scrollWidth;
// bgdiv.style.height = $(document).height();
$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div)
{
document.getElementById(show_div).style.display='none';
document.getElementById(bg_div).style.display='none';
};
</script>
	<header>
		<%
		    List<Hotel> hotels=(List<Hotel>)ActionContext.getContext().getSession().get("ind_hotH");
		    List<Restaurant> rests=(List<Restaurant>)ActionContext.getContext().getSession().get("ind_hotR");
		    List<Attraction> attrs=(List<Attraction>)ActionContext.getContext().getSession().get("ind_hotA");
			Long uid=(Long)ActionContext.getContext().getSession().get("Auuid");
		%>
		<h1>Where You Will Go</h1>
	</header>
	<nav>
		<ul>
			<li class="selected"><a href="#">首页</a></li>
			<li><a href="Hotels">酒店</a></li>
			<li><a href="Restaurants">饭店</a></li>
			<li><a href="makeRoute">旅程</a></li>
			<li><a href="/MyJourney/pic/picwall">旅图</a></li>
			<li><a href="userJourneyManagement">管理</a></li>
			<li><a href="personCenterSelect1">个人中心</a></li>
			<li class="subscribe"><a href="#"></a></li>
		</ul>
	</nav>
<section id="intro">
		<header>
			<h2>行走的力量，你是否准备好了？</h2>
		</header>
	<p> 一路上走过的路遇见的人，长期在路上的人们，总是有着迷茫，下一站可以去哪里，这样行走是为追求什么？一切的一切总会要归于实处</p>
		<img src="../images/header.jpg" alt="Flower" />  </section>

	<div id="content">
			<section>
					<header id="rect">
						<h2>旅游热点推荐,<font color="red">hot</font></h2>
						<div class='ind_hots'>
							<%
								
								int asize=attrs.size();
								for(int i=0;i<asize;i++){
									out.print("<span class='ind_h_title'><a class='title_lnk' href='userviewAttraction?aid="+attrs.get(i).getId()+"&uid="+uid+"'>"+attrs.get(i).getName()+"</a></span><br/>");
									out.print("<span class='ind_h_detail'>地址:</span>");
									out.print("<span class='ind_h_detail'>"+attrs.get(i).getAddress()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>城市:</span>");
									out.print("<span class='ind_h_detail'>"+attrs.get(i).getCity().getName()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>价格:</span>");
									out.print("<span class='ind_h_detail'>"+attrs.get(i).getPrice()+"</span>&nbsp;&nbsp;");
									out.print("<br/><br/>");
								}
		
							
							%>
						</div>
					</header>	
					<div id="kong">
					 
					</div>
					<header id="rect">
						<h2>酒店推荐,<font color="red">hot</font></h2>
						<div class='ind_hots'>
							<%
								out.print("<div class='dghf' align='right'><a href='Hotels'>更多</a></div>");
								int hsize=hotels.size();
								for(int i=0;i<hsize;i++){
									out.print("<span class='ind_h_title'><a class='title_lnk' href='userviewHotel?hid="+hotels.get(i).getId()+"&uid="+uid+"'>"+hotels.get(i).getName()+"</a></span><br/>");
									out.print("<span class='ind_h_detail'>地址:</span>");
									out.print("<span class='ind_h_detail'>"+hotels.get(i).getAddress()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>城市:</span>");
									out.print("<span class='ind_h_detail'>"+hotels.get(i).getCity().getName()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>价格:</span>");
									out.print("<span class='ind_h_detail'>"+hotels.get(i).getPrice()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>电话:</span>");
									out.print("<span class='ind_h_detail'>"+hotels.get(i).getPhone()+"</span>&nbsp;&nbsp;");
									out.print("<br/><br/>");
								}
		
							
							%>
						</div>
					</header>	
					<div id="kong"></div>
					<header id="rect">
						<h2>饭店推荐,<font color="red">hot</font></h2>
						<div class='ind_hots'>
							<%
								out.print("<div class='dghf' align='right'><a href='Restaurants'>更多</a></div>");
								int rsize=rests.size();
								for(int i=0;i<rsize;i++){
									out.print("<span class='ind_h_title'><a class='title_lnk' href='userviewRestaurant?rid="+rests.get(i).getId()+"&uid="+uid+"'>"+rests.get(i).getName()+"</a></span><br/>");
									out.print("<span class='ind_h_detail'>地址:</span>");
									out.print("<span class='ind_h_detail'>"+rests.get(i).getAddress()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>城市:</span>");
									out.print("<span class='ind_h_detail'>"+rests.get(i).getCity().getName()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>价格:</span>");
									out.print("<span class='ind_h_detail'>"+rests.get(i).getPrice()+"</span>&nbsp;&nbsp;");
									out.print("<span class='ind_h_detail'>电话:</span>");
									out.print("<span class='ind_h_detail'>"+rests.get(i).getPhone()+"</span>&nbsp;&nbsp;");
									out.print("<br/><br/>");
								}
		
							
							%>
						</div>
					</header>	
			</section>
		<aside>
		
			<section id="login">
			<s:if test="islogined==false" >
				<form name="form1" action="login" method="post">
				<h3><font color="white">嘻嘻，顺便登陆一下呗！</font></h3>
				<p>
					<label for="name"><font color="white">姓名:</font></label>
					<input name="account" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="password"><font color="white">密码:</font></label>
					<input name="password" id="password" type="password" style="width:150px" />
				</p>
				<p> <input  id="button"  value="登陆" type="submit"  /><a id="index_a" onclick="ShowDiv('MyDiv','fade')">注册</a></p>
			</form>
			</s:if>
			<s:else>
			  <h3><font color="white">嘻嘻，O(∩_∩)O欢迎你,</font><font color="red">${account}</font><a href="/MyJourney/user/logout" style="color:yellow">退出</a></h3>
				<p>
					<label for="name"><font color="white"></font></label>
				
				</p>
				
			</s:else>
			</section>
			
			
			<section id="fade" class="black_overlay">
            </section>
            <section id="MyDiv" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('MyDiv','fade')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="register" method="post">
				<h3><font color="#EE7700 ">欢迎加入我们的大家庭！</font></h3>
				<p>
					<label for="account"><font color="black">账号:</font></label>
					<input name="user.account" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="password"><font color="black">密码:</font></label>
					<input name="user.pwd" id="password" type="password" style="width:150px" />
				</p>
				<p>
					<label for="password"><font color="black">重复密码:</font></label>
					<input name="password" id="password" type="password" style="width:150px" />
				</p>
				    <table>
				    <tr>
				    <td style="width:125px;">
					<label for="sex"><font color="black">性别:</font></label>
					</td>
					<td>
					<input name="user.sex" id="sex" type="radio" value="1" style="width:30px;" checked="checked">男
					<input name="user.sex" id="sex" type="radio" value="0" style="width:30px;margin-left:0px" >女
				   </td>
				   </tr>
				    </table>
				<p>
					<label for="name"><font color="black">姓名:</font></label>
					<input name="user.name" id="name" type="text" style="width:150px" />
				</p>
				<p>
					<label for="age"><font color="black">age:</font></label>
					<input name="user.age" id="age" type="number" style="width:150px" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<input name="user.phone" id="phone" type="tel" style="width:150px" />
				</p>
				<p>
					<label for="email"><font color="black">email:</font></label>
					<input name="user.email" id="email" type="email" style="width:150px" />
				</p>
				<p> <input  id="button"  value="注册" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
			
			<section id="pioneer"><!-- 达人 -->
			<h2>达人<font color="red">秀</font></h2>
			<div style="float:right;font-size: 10px;text-overflow:ellipsis"><a href="/MyJourney/pic/daren">更多</a></div>
			<s:iterator value="darenList" var="dr">
				<div style="overflow: hidden;height:60px;width:100%;margin-top: 6px;">
					<div style="float: left;"><a href="/MyJourney/pic/home?account=${dr.account }"><img alt="${dr.account }" src="${dr.image }" width="67px" height="67px"></a></div>
					<div style="float: left;margin-left: 20px;">
						<ul>
							<li style="width:55px; float: left;"><em style="color:#0069ca;font-size: 16px;font-weight: bold;">${dr.attentionNum }</em><br><span >关注</span></li>         
							<li style="width:55px; float: left;"><em style="color:#0069ca;font-size: 16px;font-weight: bold;">${dr.concernedNum }</em><br><span >粉丝</span></li>        
							<li style="width:55px; float: left;"><em style="color:#0069ca;font-size: 16px;font-weight: bold;">${dr.journeyNum }</em><br><span >旅行</span></li>        
						</ul>
					</div>
				</div>
			</s:iterator>
			</section>
		</aside>
	</div>
	<div id="kong"></div> 
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
</html>