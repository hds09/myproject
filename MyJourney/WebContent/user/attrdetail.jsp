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
			function sNhCF(id){
				var id='#'+'cfid'+id;
				$(id).show(400);
			}
			
			function sNhCFc(id){
				var id='#'+'cfid'+id;
				$(id).hide(400);
			}
			
			function vote(uid,aid,type,isRated){
				if(uid==null){
					alert('您还未登陆!');
					location.href="index";
				}else{
					if(isRated=='1'){
						
						alert('您已评价过，感谢您的评价');
					}else{
						
						$.ajax({
							type:'post',
							url:'uservote.action',
							data:{aid:aid,voteType:'attraction',voteFoD:type},
							dataType:"json",  
							success: function(data){
								alert('感谢你的评价');
								if(type=='1'){
									var v=$('.voteUp').text();
									v=parseInt(v)+1;
									$('.voteUp').text(v);
								}else{
									var v=$('.voteDown').text();
									v=parseInt(v)+1;
									$('.voteDown').text(v);
								}
								location.href="/MyJourney/user/userviewAttraction?aid="+aid+"&uid="+uid;
							},
							error : function(XMLHttpRequest, textStatus, errorThrown) {   
			                     
				            },  
						});
					}
				}
				
			}
		</script>
		<title>酒店信息</title>
	</head>
	<body>
		<%
			Attraction attr=(Attraction)ActionContext.getContext().getSession().get("targeta");
			String uid=(String)ActionContext.getContext().getSession().get("viewer");
			List<Comment> comments=attr.getComments();
			String sStr="ratedattr"+attr.getId();
			String isRated="0";
			isRated=(String)ActionContext.getContext().getSession().get(sStr);
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
			
			<!-- menu-->
			<div id="cter">
				<div id="j_contents">
					<div id='title_div'>
						<span class='x_title'><%out.print(attr.getName());%></span>
						<div class='seperator2'></div>
					</div>
					<div id='info_div'>
						<div id='upper'>
							<span>地址:</span>
							<span>
							<% out.print(attr.getAddress()); %>
							</span>
							&nbsp;&nbsp;&nbsp;
							<span>价格:</span>
							<span>
							<% out.print(attr.getPrice());%>
							</span>
							<div class='likeNdis' align='center'>
								<img class='thumb' src='../images/sdd09/up.jpg' onclick='vote(<%out.print(uid);%>,<% out.print(attr.getId());%>,1,<% out.print(isRated);%>)'><span class='voteUp'><% out.print(attr.getFavor());%></span>&nbsp;&nbsp;&nbsp;
								<img class='thumb' src='../images/sdd09/down.jpg' onclick='vote(<%out.print(uid);%>,<% out.print(attr.getId());%>,0,<% out.print(isRated);%>)'><span class='voteDown'><% out.print(attr.getDislike());%></span>
							</div>
						</div>
						<div id='downer'>
							<span class='fdf'>来自用户的评价:</span>
							<div id='downer_i'>
								<% 
									if(attr.getComments().size()==0){
										out.print("暂无");
									}else{
										out.print("用户评价:");
										for(int k=0;k<attr.getComments().size();k++){
											out.print("<div class='cdi'>");
											out.print("<span>用户&nbsp;</span>");
											out.print("<span>"+attr.getComments().get(k).getUser().getAccount()+"</span>&nbsp;");
											out.print("<span><B><I>说道</I></B></span>&nbsp;");
											out.print("<div class='realc'>");
											out.print(attr.getComments().get(k).getContext());
											out.print("</div>");
											out.print("</div>");
										}
									}
								%>
							</div>
						</div>
						
					</div>
					
					
				</div>
			</div>
			<div class='clear_div'></div>
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