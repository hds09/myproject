<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.User" %>
<%@ page import="edu.nju.MyJourney.model.Journey" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %> 
<%@ page import="edu.nju.MyJourney.helperModel.*" %> 
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
			var currentList=1;
			function navi(type){
				var number=$('.team_row').size();
				if(type==0&&currentList!=1){
					$('.team_row')[currentList-1].style.display='none';
					$('.team_row')[currentList-2].style.display='block';
					currentList=currentList-1;
				}else if(type==1&&currentList!=number){
					$('.team_row')[currentList-1].style.display='none';
					$('.team_row')[currentList].style.display='block';
					currentList=currentList+1;
				}
			}
			var currentList2=1;
			function navi2(type){
				var number=$('.p_row').size();
				if(type==0&&currentList2!=1){
					$('.p_row')[currentList2-1].style.display='none';
					$('.p_row')[currentList2-2].style.display='block';
					currentList2=currentList2-1;
				}else if(type==1&&currentList2!=number){
					$('.p_row')[currentList2-1].style.display='none';
					$('.p_row')[currentList2].style.display='block';
					currentList2=currentList2+1;
				}
			}
			
			
			var currentList3=1;
			function navi3(type){
				var number=$('.p_row').size();
				if(type==0&&currentList3!=1){
					$('.p_row')[currentList3-1].style.display='none';
					$('.p_row')[currentList3-2].style.display='block';
					currentList3=currentList3-1;
				}else if(type==1&&currentList3!=number){
					$('.p_row')[currentList3-1].style.display='none';
					$('.p_row')[currentList3].style.display='block';
					currentList3=currentList3+1;
				}
			}
		</script>
		<title>旅行管理
		</title>
	</head>
	<body>
		<%
			List<Journey> journeys=(List<Journey>)ActionContext.getContext().getSession().get("user_journeys");
			List<Journey> alljourneys=(List<Journey>)ActionContext.getContext().getSession().get("all_journeys");
			List<SimilarJourney> sims=(List<SimilarJourney>)ActionContext.getContext().getSession().get("similarJs");
			List<Journey> interested=(List<Journey>)ActionContext.getContext().getSession().get("user_int");
			List<User> intUsers=(List<User>)ActionContext.getContext().getSession().get("InUser");
			Long uid=(Long)ActionContext.getContext().getSession().get("Auuid");
			String account=(String)ActionContext.getContext().getSession().get("account");
			List<Journey> personal=new ArrayList<Journey>();
			List<Journey> team=new ArrayList<Journey>();
			List<Journey> allteam=new ArrayList<Journey>();
			//
			//
			for(int i=0;i<journeys.size();i++){
				if(journeys.get(i).getState()==1){
					team.add(journeys.get(i));
				}else{
					personal.add(journeys.get(i));
				}
			}
			for(int i=0;i<alljourneys.size();i++){
				if(alljourneys.get(i).getState()==1){
					allteam.add(alljourneys.get(i));
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
		<div id="containAll2">
			<div id="text_div"><span>我的行程</span></div>
			<div class="seperator"></div>
			<!-- menu-->
			<div id="cter">
				<div id="left_navi" align="center">
					<ul>
						<li class="trip_type_selected" onclick="changeDiv(1)">我的个人旅程</li>
						<li class="trip_type_diselected" onclick="changeDiv(2)">结伴行程</li>
					</ul>
				</div>
				<div id="contents">
					<div id="j_tab">
						<ul id="tab" class="tabmenu">
						  <li class="active tab_item" onclick="makeActive(0)"><a>与我相关</a></li>
						  <li class="tab_item" onclick="makeActive(1)" style='display:none'><a>所有</a></li>
						</ul>
					</div>
					
					
					
					<div id="j_result" class="changeableTab">
						<!--this section should be updated asynchronously according to user clicking on different tabs
							expected to be implemented by AJAX -->
						<!--hard-coding data-->
						<% 
							int psize=personal.size();
							int panelNum2=psize/5+1; //panel number
							int index2=0;
							int p=0;
							if(psize==0){
								out.print("您还没有添加或加入任何旅行");
								out.print("<a href='makeRoute' class='insAdd'>立即去添加</a>");
							}
							for(int j=0;j<panelNum2;j++){
								if(j==0){
									out.print("<div class='p_row'>");
								}else{
									out.print("<div class='p_row' style='display:none'>");
								}
								for(index2=0;index2<5;index2++){
									if(p==psize){
										break;
									}
									out.print("<div class='resultRow'>");
									out.print("<div class='row_sep2'></div>");
									out.print("<div class='rrow_content'>");
									out.print("<div class='journey_title'>");
									out.print("<span class='title'>"+personal.get(p).getJourneyName()+"</span><br/>");
									if(personal.get(p).getPlaces().size()!=0){
										out.print("<span class='date'>开始于:"+personal.get(p).getPlaces().get(0).getTime()+"</span><br/>");
									}else{
										out.print("<span class='date'>无地点信息</span><br/>");
									}
									out.print("</div>");
									out.print("</div>");
									out.print("<div class='status'>");
									out.print("<span class='for_details'><a class='detail_tx' href='/MyJourney/user/editRoute?routeId="+personal.get(p).getId()+"&selectnum=1'>编辑</a></span>");
									out.print("</div>");
									out.print("<div class='rrow_right' align='center'>");
									out.print("<span class='record_text' onclick='openCenterDiv("+personal.get(p).getId()+")'>查看相似行程</span><br/>");
									out.print("<span class='record_text'></span>");
									out.print("</div>");
									out.print("<div class='my_rate' align='center'>");
									out.print("<div class='ttt'><span class='p_trip_rate'><a href='userViewJourney?jid="+personal.get(p).getId()+"&uid="+personal.get(p).getUser().getUid()+"'>查看详情</a></span></div>");
									out.print("</div>");
									out.print("<div class='trip_action'>");
									
									out.print("</div>");
									out.print("<div class='row_sep'></div>");
									out.print("</div>");
									out.print("<div class='center_div' id='center_div"+personal.get(p).getId()+"' style='display:none'>");
									out.print("<div id='center_div_header' align='right'>");
									out.print("<span onclick='closeCenterDiv("+personal.get(p).getId()+")'>关闭</span>");
									out.print("</div>");
									out.print("<span>&nbsp;&nbsp;&nbsp;为您找到的相似旅程</span>");
									out.print("<div id='sims' align='center'>");
									List<Journey> tmpss=null;
									for(int m=0;m<sims.size();m++){
										if(sims.get(m).getTheJ().getId()==personal.get(p).getId()){
											tmpss=sims.get(m).getSims();
											break;
										}
									}
									if(tmpss.size()==0||tmpss==null){
										out.print("抱歉,未找到相似旅程");
									}else{
										for(int l=0;l<tmpss.size();l++){
											out.print("<a class='simJTitle' href='userViewJourney?jid="+tmpss.get(l).getId()+"&uid="+personal.get(p).getUser().getUid()+"'>"+tmpss.get(l).getJourneyName()+"<a><br/>");
										}
									}
									out.print("</div>");
									out.print("<br/><br/><span>&nbsp;&nbsp;&nbsp;快去看看他们都干了些什么</span>");
									out.print("</div>");
									p++;
									
								}
								index2=0;
								//
								out.print("</div>");
							}
							if(psize>=6){
								out.print("<div class='backAndforth' align='right'>");
								out.print("<span class='textBut' onclick='navi2(0)'>上一页</span>&nbsp;&nbsp;&nbsp;<span class='textBut' onclick='navi2(1)'>下一页</span>");
								out.print("</div>");
							}
							//
							
							//	
							
							
						%>
					</div>
					<div id="team_results" class="changeableTab" style="display:none">
						<div id="team_header">
							           	                                          
						</div>
						<div id="team_row">
							<%
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								String today=sdf.format(new Date());
								int tsize=team.size();
								if(tsize==0){
									out.print("您还没有添加或加入任何旅行");
									out.print("&nbsp;&nbsp;&nbsp;<a href='makeRoute' class='insAdd'>立即去添加</a>");
								}
								for(int i=0;i<tsize;i++){
									
									out.print("<div class='resultRow'>");
									out.print("<div class='row_sep2'></div>");
									out.print("<div class='rrow_content'>");
									out.print("<div class='journey_title'>");
									out.print("<span class='title'>"+team.get(i).getJourneyName()+"</span>");
									out.print("<br/>");
									out.print("<span class='date'>从:"+team.get(i).getPlaces().get(0).getTime()+"</span>");
									out.print("<br/>");
									out.print("<span class='date'>至:"+team.get(i).getPlaces().get(team.get(i).getPlaces().size()-1).getTime()+"</span>");
									out.print("</div>");
									out.print("</div>");
									out.print("<div class='status'>");
									if(today.compareTo(team.get(i).getPlaces().get(team.get(i).getPlaces().size()-1).getTime())>0){
										out.print("<span class='finished'>已结束</span>");
									}else if(today.compareTo(team.get(i).getPlaces().get(0).getTime())<0){
										out.print("<span class='notStarted'>未开始</span>");
									}else{
										out.print("<span class='ongoing'>进行中</span>");
									}
									out.print("</div>");
									out.print("<div class='rrow_right'>");
									out.print("<div class='number' align='center'>"+team.get(i).getTeam().getUsers().size()+"</div>");
									out.print("<div class='participants' align='center'>成员</div>");
									out.print("</div>");
									out.print("<div class='my_rate'>");
									//
									if(team.get(i).getUser().getUid()==uid){
										out.print("<div><span><a href='/MyJourney/user/editRoute?routeId="+team.get(i).getId()+"&selectnum=1'>编辑</a></span></div>");
									}else{
										out.print("<div><span></span></div>");
									}
									
									//
									out.print("</div>");
									out.print("<div class='my_rate'>");
									out.print("<div><span><a href='userViewJourney?jid="+team.get(i).getId()+"&uid="+uid+"'>查看详情</a></span></div>");
									out.print("</div>");
									out.print("<div class='row_sep'></div>");
									out.print("</div>");
								}
							
							%>
						
						</div>
					</div>
					
					<div id="all_tj_results" class="changeableTab" style="display:none">
						<div id="team_header">
							           	                                          
						</div>
						
							<%
								tsize=allteam.size();
								int panelNum=tsize/5+1; //panel number
								int index=0;
								int m=0;
								for(int j=0;j<panelNum;j++){
									if(j==0){
										out.print("<div class='team_row'>");
									}else{
										out.print("<div class='team_row' style='display:none'>");
									}
									for(index=0;index<5;index++){
										if(m==tsize){
											break;
										}
										out.print("<div class='resultRow'>");
										out.print("<div class='row_sep2'></div>");
										out.print("<div class='rrow_content'>");
										out.print("<div class='journey_title'>");
										out.print("<span class='title'>"+allteam.get(m).getJourneyName()+"</span>");
										out.print("<br/>");
										
										//
										if(allteam.get(m).getPlaces().size()==0){
											out.print("没有时间信息");
										}else{
											out.print("<span class='date'>从:"+allteam.get(m).getPlaces().get(0).getTime()+"</span>");
											out.print("<br/>");
											out.print("<span class='date'>至:"+allteam.get(m).getPlaces().get(allteam.get(m).getPlaces().size()-1).getTime()+"</span>");
										}
										//
										out.print("</div>");
										out.print("</div>");
										out.print("<div class='status'>");
										//
										if(allteam.get(m).getPlaces().size()==0){
											out.print("<span class='finished'>不详</span>");
										}else{
											if(today.compareTo(allteam.get(m).getPlaces().get(allteam.get(m).getPlaces().size()-1).getTime())>0){
												out.print("<span class='finished'>已结束</span>");
											}else if(today.compareTo(allteam.get(m).getPlaces().get(0).getTime())<0){
												out.print("<span class='notStarted'>未开始</span>");
											}else{
												out.print("<span class='ongoing'>进行中</span>");
											}
										}
										//
										out.print("</div>");
										out.print("<div class='rrow_right'>");
										//
										if(allteam.get(m).getTeam()==null){
											out.print("<div class='number' align='center'>NA</div>");
										}else{
											out.print("<div class='number' align='center'>"+allteam.get(m).getTeam().getUsers().size()+"</div>");
										}
										//
										out.print("<div class='participants' align='center'>成员</div>");
										out.print("</div>");
										out.print("<div class='my_rate'>");
										if(allteam.get(m).getUser().getUid()==uid){
											out.print("<div><span><a href='/MyJourney/user/editRoute?routeId="+allteam.get(m).getId()+"&selectnum=1'>编辑</a></span></div>");
										}else{
											out.print("<div><span></span></div>");
										}
										
										out.print("</div>");
										out.print("<div class='my_rate'>");
										out.print("<div><span><a href='userViewJourney?jid="+allteam.get(m).getId()+"&uid="+uid+"'>查看详情</a></span></div>");
										out.print("</div>");
										out.print("<div class='row_sep'></div>");
										out.print("</div>");
										m++;
									}
									index=0;
									//
									out.print("</div>");
								}
								if(tsize>=6){
									out.print("<div class='backAndforth' align='right'>");
									out.print("<span class='textBut' onclick='navi(0)'>上一页</span>&nbsp;&nbsp;&nbsp;<span class='textBut' onclick='navi(1)'>下一页</span>");
									out.print("</div>");
								}
								//
								
							
							%>
							
						
					</div>
					
					
				</div>
			</div>
			<div id="text_div3">
				<span>为您推荐</span>
			</div>
			<div class="seperator"></div>
			<div id="rec_trip">
				<div class="rec_text_div"><span class="rec_text">猜您感兴趣的旅程</span></div>
				<div id="rec_trip_rows">
					<%
						int isize=interested.size();
						for(int i=0;i<isize;i++){
							if(interested.get(i).getPlaces().size()!=0){
								out.print("<div class='rec_trip_row'>");
								out.print("<span class='trip_title'><a class='trip_lnk' href='userViewJourney?jid="+interested.get(i).getId()+"&uid="+uid+"'>"+interested.get(i).getJourneyName()+"</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
								out.print("<span class='trip_time'>"+interested.get(i).getPlaces().get(0).getTime()+"&nbsp;&nbsp;至&nbsp;&nbsp; "+interested.get(i).getPlaces().get(interested.get(i).getPlaces().size()-1).getTime()+"</span>");
								out.print("</div>");
							}
							
						}
						
					%>
					
						
						
					
				</div>
			</div>
			<div id="rec_people">
				<div><span>"志同道合"的驴友</span></div>
				<%
					int recsize=intUsers.size();
					for(int i=0;i<recsize;i++){
						out.print("<div class='rec_row' align='center'>");
						out.print("<img src='"+intUsers.get(i).getImage()+"' width='50px;' height='50px;'' /><br/>");
						out.print("<a class='people_lnk' href=''>"+intUsers.get(i).getAccount()+"</a>");
						out.print("</div>");
					}
					
				%>
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
</html>