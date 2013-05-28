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
			
			function joinTeam(jid,uid){
				$.ajax({
					type:'post',
					url:'jointeam.action',
					data:{jid:jid,uid:uid},
					dataType:"json",  
					success: function(data){
						alert('加入成功');
						location.href="/MyJourney/user/userViewJourney?jid="+jid+"&uid="+uid;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {   
	                     
		            },  
				});
			}
			
			function comment(index,hid,rid,aid,uid){
				var id='#'+'commText'+index;
				var text=$(id).val();
				$.ajax({
					type:'post',
					url:'comment.action',
					data:{commText:text,hid:hid,rid:rid,aid:aid,uid:uid},
					dataType:"json",  
					success: function(data){
						alert('评价成功');
						location.reload();
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {   
	                     
		            },  
				});
				
			}
			
			function leaveTeam(jid,uid){
				$.ajax({
					type:'post',
					url:'leaveteam.action',
					data:{jid:jid,uid:uid},
					dataType:"json",  
					success: function(data){
						location.reload();
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {   
	                     
		            },  
				});
			}
		</script>
		<title>旅程信息</title>
	</head>
	<body>
		<%
			Journey j=(Journey)ActionContext.getContext().getSession().get("targetJ");
			String uid=(String)ActionContext.getContext().getSession().get("viewer");
			List<Comment> comments=(List<Comment>)ActionContext.getContext().getSession().get("comments");
			boolean joined=false;
			boolean finished=false;
			boolean ongoing=false;
			boolean notstarted=false;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String today=sdf.format(new Date());
			if(j.getPlaces().size()==0){
				
			}else{
				if(today.compareTo(j.getPlaces().get(j.getPlaces().size()-1).getTime())>0){
					finished=true;
				}else if(today.compareTo(j.getPlaces().get(0).getTime())<0){
					notstarted=true;
				}else{
					ongoing=true;
				}
			}
			
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
			<div id="text_div"><span><a href='userJourneyManagement'>返回旅程管理</a></span></div>
			<div class="seperator"></div>
			<!-- menu-->
			<div id="cter">
				<div id="j_contents">
					<div id='title_div2'>
						<span class='x_title'><%out.print(j.getJourneyName());%></span>
						<%
							if(j.getTeam()==null){
								
							}else{
								if(j.getState()==1){
									List<User> mems=j.getTeam().getUsers();
									for(User user:mems){
										if(uid.equals(Long.toString(user.getUid()))){
											joined=true;
											break;
										}
									}
								}
								if(finished){
									out.print("<span class='finished'>已结束</span>&nbsp;&nbsp;&nbsp;&nbsp;");
								}else if(notstarted){
									out.print("<span class='notStarted'>未开始</span>&nbsp;&nbsp;&nbsp;&nbsp;");
									if(joined){
										out.print("<span class='joined' >已加入</span>&nbsp;&nbsp;");
										if(j.getUser().getUid()==Long.parseLong(uid)){
											out.print("<span class='owner'>创建者</span>");
										}else{
											out.print("<span class='lvT' onclick='leaveTeam("+j.getId()+","+uid+")'>退出队伍</span>");
										}
									}else{
										if(j.getState()==1){
											out.print("<span class='not_joined' onclick='joinTeam("+j.getId()+","+uid+")'>立即加入</span>");
										}
										
									}
								}else if(ongoing){
									out.print("<span class='ongoing'>进行中</span>");
								}
							}
							
							
						
						%>
						
					</div>
					<div id='info_div'>
						<div id='upper'>
							<span>类型:</span>
							<span>
							<% if(j.getState()==0){
								out.print("个人");
							}else{
								out.print("结队");
							}%>
							</span>
							&nbsp;&nbsp;&nbsp;
							<span>发起人:</span>
							<span>
							<% out.print(j.getUser().getAccount());%>
							</span>
						</div>
						<div id='downer'>
							<span>旅行经过:</span>&nbsp;<a href='/MyJourney/user/editRoute?routeId=<%out.print(j.getId()); %>'>详情</a>
							<div id='downer_i'>
								<%
									if(j.getPlaces().size()!=0){
										for(int i=0;i<j.getPlaces().size();i++){
											out.print("<span>"+j.getPlaces().get(i).getTime()+"</span>&nbsp;");
											if(j.getPlaces().get(i).getHalfday()==0){
												out.print("<span>上午</span>&nbsp;");
											}else{
												out.print("<span>下午</span>&nbsp;");
											}
											out.print("<span>所在城市</span>&nbsp;");
											out.print("<span><B>"+j.getPlaces().get(i).getCity().getName()+"</B></span>&nbsp;");
											//
											if(j.getPlaces().get(i).getAttraction()!=null){
												out.print("<span>所在景点</span>&nbsp;");
												out.print("<span><a class='detail_lnk' href='userviewAttraction?aid="+j.getPlaces().get(i).getAttraction().getId()+"&uid="+uid+"'>"+j.getPlaces().get(i).getAttraction().getName()+"</a></span>&nbsp;&nbsp;");
											}
											if(j.getPlaces().get(i).getHotel()!=null){
												out.print("<span>所住酒店</span>&nbsp;");
												out.print("<span><a class='detail_lnk' href='userviewHotel?hid="+j.getPlaces().get(i).getHotel().getId()+"&uid="+uid+"'>"+j.getPlaces().get(i).getHotel().getName()+"</a></span>&nbsp;&nbsp;");
											}
											if(j.getPlaces().get(i).getRestaurant()!=null){
												out.print("<span>饭店</span>&nbsp;");
												out.print("<span><a class='detail_lnk' href='userviewRestaurant?rid="+j.getPlaces().get(i).getRestaurant().getId()+"&uid="+uid+"'>"+j.getPlaces().get(i).getRestaurant().getName()+"</a></span>&nbsp;&nbsp;");
											}
											out.print("<br/>");
											//
											
											//out.print("<span class='eva_t' onclick='sNhCF("+j.getPlaces().get(i).getId()+")'>评价</span>");
											//int csize=comments.size();
											//Comment tmp=null;
											//boolean commentExist=false;
											//String comment=null;
											//for(int k=0;k<csize;k++){
												//tmp=comments.get(k);
												//Attraction tmpa=j.getPlaces().get(i).getAttraction();
												//Hotel tmph=j.getPlaces().get(i).getHotel();
												//Restaurant tmpr=j.getPlaces().get(i).getRestaurant();
												//if(tmp.getAttraction().getId()==tmpa.getId()&&tmp.getHotel().getId()==tmph.getId()&&tmp.getRestaurant().getId()==tmpr.getId()){
													//commentExist=true;
													//comment=tmp.getContext();
													//break;
												//}
											//}
											//
											
											//out.print("<div class='cfld' style='display:none' id='cfid"+j.getPlaces().get(i).getId()+"'>");
											//out.print("<form action='comment' method='post'>");
											//if(commentExist){
												//out.print("<textarea class='cfld_f' style='width: 481px; height: 46px;' value='"+comment+"' disabled=true >"+comment+"</textarea>");
												//out.print("<div align='center'><span class='cspan' onclick='sNhCFc("+j.getPlaces().get(i).getId()+")'>已评</span></div>");
											//}else{
												//out.print("<textarea class='cfld_f' id='commText"+i+"' style='width: 481px; height: 46px;'  ></textarea>");
												//out.print("<input type='hidden' name='hid' value='"+j.getPlaces().get(i).getHotel().getId()+"' />");
												//out.print("<input type='hidden' name='rid' value='"+j.getPlaces().get(i).getRestaurant().getId()+"' />");
												//out.print("<input type='hidden' name='aid' value='"+j.getPlaces().get(i).getAttraction().getId()+"' />");
												//out.print("<input type='hidden' name='uid' value='"+uid+"' />");
												//out.print("<div align='center'><span class='cspan' onclick='sNhCFc("+j.getPlaces().get(i).getId()+")'>取消</span>&nbsp;|&nbsp;<span class='cspan' onclick='comment("+i+","+j.getPlaces().get(i).getHotel().getId()+","+j.getPlaces().get(i).getRestaurant().getId()+","+j.getPlaces().get(i).getAttraction().getId()+","+uid+")'>提交</span></div>");
											//}
											//out.print("</form>");
											//out.print("</div>");
										}
										
									}
								%>
								<span></span>
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