<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.nju.MyJourney.model.User" %>
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
	</head>
	<body>
		<%
			List<Journey> journeys=(List<Journey>)ActionContext.getContext().getSession().get("user_journeys");
			List<Journey> alljourneys=(List<Journey>)ActionContext.getContext().getSession().get("all_journeys");
			List<Journey> personal=new ArrayList<Journey>();
			List<Journey> team=new ArrayList<Journey>();
			List<Journey> allteam=new ArrayList<Journey>();
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
				<li><a href="#">酒店</a></li>
				<li><a href="#">饭店</a></li>
				<li><a href="makeRoute">旅程</a></li>
				<li><a href="/MyJourney/pic/picwall">旅图</a></li>
				<li class="selected"><a href="">管理</a></li>
				<li><a href="personCenterSelect1">个人中心</a></li>
				<li class="subscribe"><a href="#"></a></li>
			</ul>
		</nav>
		<div id="containAll">
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
						  <li class="active tab_item" onclick="makeActive(0)"><a>所有</a></li>
						  <li class="tab_item" onclick="makeActive(1)" style='display:none'><a>关于我的</a></li>
						</ul>
					</div>
					<div id="search_div">
						<span onclick="sndSearchField()" id="search_text">搜索<img id="s_arrow" src="../images/sdd09/arr_d.jpg" /></span>		
					</div>
					<div id="search_field" style="display:none">
						<form>
							<div id="s_name">
								<span class="s_text">旅行名关键字</span>
								<input class="s_input" />
							</div>
							<div id="s_time">
								<span class="s_text">时间范围</span>
								<input id="s_startDate" class="s_input" /><span class="s_text"> 至  </span><input id="s_endDate" class="s_input" />
							</div>
							<div id="s_cities">
								<span class="s_text">沿途城市(至多添加5个)</span>
								<span class="s_text2">添加</span>
							</div>
							<div id="s_status">
								<span class="s_text">状态</span>
								<select name="status">
								<option value="finished"><span class="s_text">已结束</span></option>
								<option value="ongoing"><span class="s_text">进行中</span></option>
								<option value="pending"><span class="s_text">未开始</span></option>
								</select>
							</div>
							<div id="s_rate">
								<span class="s_text" >评分</span>
								<select name="rate">
								<option value="finished" class="s_text"><span class="s_text">从低到高</span></option>
								<option value="ongoing" class="s_text"><span class="s_text">从高到低</span></option>
								</select>
							</div>
							<div class="sep"></div>
							<div id="s_people">
								<span class="s_text">参加人数</span>
								<select name="rate">
								<option value="finished"><span class="s_text">从低到高</span></option>
								<option value="ongoing"><span class="s_text">从高到低</span></option>
								</select>
							</div>
							<div id="s_form_submit" align="right">
								<input type="submit" value="搜索" class="s_sbmt"/>
							</div>
							<div class="sep"></div>
						</form>
					</div>
					<div id="j_result" class="changeableTab">
						<!--this section should be updated asynchronously according to user clicking on different tabs
							expected to be implemented by AJAX -->
						<!--hard-coding data-->
						<% 
							int psize=personal.size();
							for(int i=0;i<psize;i++){
								out.print("<div class='resultRow'>");
								out.print("<div class='row_sep2'></div>");
								out.print("<div class='rrow_content'>");
								out.print("<div class='journey_title'>");
								out.print("<span class='title'><a>"+personal.get(i).getJourneyName()+"</a></span><br/>");
								if(personal.get(i).getPlaces().size()!=0){
									out.print("<span class='date'>开始于:"+personal.get(i).getPlaces().get(0).getTime()+"</span><br/>");
								}else{
									out.print("<span class='date'>无地点信息</span><br/>");
								}
								out.print("</div>");
								out.print("</div>");
								out.print("<div class='status'>");
								out.print("<span class='for_details'><a class='detail_tx' href='/MyJourney/user/editRoute?routeId="+personal.get(i).getId()+"&selectnum=1'>行程记录</a></span>");
								out.print("</div>");
								out.print("<div class='rrow_right' align='center'>");
								out.print("<span class='record_text'>查看相似行程</span><br/>");
								out.print("<span class='record_text'></span>");
								out.print("</div>");
								out.print("<div class='my_rate' align='center'>");
								out.print("<div class='ttt'><span class='p_trip_rate'><a href='userViewJourney?jid="+personal.get(i).getId()+"&uid="+personal.get(i).getUser().getUid()+"'>评价旅途</a></span></div>");
								out.print("</div>");
								out.print("<div class='trip_action'>");
								out.print("<span class='trip_action_text'><a href=''>分享</a></span>");
								out.print("<span class='trip_action_text'><a href=''>删除</a></span>");
								out.print("</div>");
								out.print("<div class='row_sep'></div>");
								out.print("</div>");
							}
							
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
								for(int i=0;i<tsize;i++){
									out.print("<div class='resultRow'>");
									out.print("<div class='row_sep2'></div>");
									out.print("<div class='rrow_content'>");
									out.print("<div class='journey_title'>");
									out.print("<span class='title'><a onclick='openCenterDiv()'>"+team.get(i).getJourneyName()+"</a></span>");
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
									out.print("<div><span><a href='/MyJourney/user/editRoute?routeId="+team.get(i).getId()+"&selectnum=1'>查看详情</a></span></div>");
									out.print("</div>");
									out.print("<div class='my_rate'>");
									out.print("<div><span><a href='userViewJourney?jid="+team.get(i).getId()+"'>评价</a></span></div>");
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
						<div id="team_row">
							<%
								SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
								String today2=sdf.format(new Date());
								int atsize=allteam.size();
								for(int i=0;i<atsize;i++){
									out.print("<div class='resultRow'>");
									out.print("<div class='row_sep2'></div>");
									out.print("<div class='rrow_content'>");
									out.print("<div class='journey_title'>");
									out.print("<span class='title'><a onclick='openCenterDiv()'>"+allteam.get(i).getJourneyName()+"</a></span>");
									out.print("<br/>");
									out.print("<span class='date'>从:"+allteam.get(i).getPlaces().get(0).getTime()+"</span>");
									out.print("<br/>");
									out.print("<span class='date'>至:"+allteam.get(i).getPlaces().get(allteam.get(i).getPlaces().size()-1).getTime()+"</span>");
									out.print("</div>");
									out.print("</div>");
									out.print("<div class='status'>");
									if(today2.compareTo(allteam.get(i).getPlaces().get(allteam.get(i).getPlaces().size()-1).getTime())>0){
										out.print("<span class='finished'>已结束</span>");
									}else if(today2.compareTo(allteam.get(i).getPlaces().get(0).getTime())<0){
										out.print("<span class='notStarted'>未开始</span>");
									}else{
										out.print("<span class='ongoing'>进行中</span>");
									}
									out.print("</div>");
									out.print("<div class='rrow_right'>");
									out.print("<div class='number' align='center'>"+allteam.get(i).getTeam().getUsers().size()+"</div>");
									out.print("<div class='participants' align='center'>成员</div>");
									out.print("</div>");
									out.print("<div class='my_rate'>");
									out.print("<div><span><a href='/MyJourney/user/editRoute?routeId="+allteam.get(i).getId()+"&selectnum=1'>查看详情</a></span></div>");
									out.print("</div>");
									out.print("<div class='my_rate'>");
									out.print("<div><span><a href='userViewJourney?jid="+allteam.get(i).getId()+"'>评价</a></span></div>");
									out.print("</div>");
									out.print("<div class='row_sep'></div>");
									out.print("</div>");
								}
							
							%>
						
						</div>
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
					<div class="rec_trip_row">
						<span class="trip_title"><a href="">西南5日行</a></span>
						<span class="trip_time">2013/5/1 至 2013/5/3</span>
					</div>
				</div>
			</div>
			<div id="rec_people">
				<span>"志同道合"的驴友</span>
			</div>
			<div id="globalFooter">
			</div>
			
			<div id="center_div" style="display:none">
				<div id="center_div_header" align="right">
					<span onclick="closeCenterDiv()">关闭</span>
				</div>
				<div>
					<div id="img_slider">
						<div class="prev">
							<img src="../images/sdd09/prev.jpg" onclick="showPreviousPicture()"/>
						</div>
						<ul id="img_list">
							<li class="present img"><img src="../images/sdd09/tp1.jpg" class="img1"/></li>
							<li class="hidden img"><img src="../images/sdd09/tp2.jpg" class="img1"/></li>
							<li class="hidden img"><img src="../images/sdd09/tp3.jpg" class="img1"/></li>
						</ul>
						<div class="next">
							<img src="../images/sdd09/next.jpg" onclick="showNextPicture()"/>
						</div>
						<div class="v_sep"></div>
					</div>
					<div id="trip_info">
						<span class="trip_info_title">黄山三日游</span>
						<div class="trip_info_details">
							<div class="text_info">
								<span class="text_info_text">出发地</span>
							</div>
							<div class="rate_info">
								
							</div>
						</div>
					</div>
					<div id="team_member_line"><span onclick="showMembers()">展开查看成员列表</span></div>
					<div id="team_member" style="display:none">
						<div class="member_row">
							user1
						</div>
						<div class="member_row">
							user2
						</div>
						<div class="member_row">
							user3
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<footer>
	</footer>
</html>