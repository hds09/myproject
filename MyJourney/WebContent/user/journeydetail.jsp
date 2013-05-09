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
		</script>
		<title>旅程信息</title>
	</head>
	<body>
		<%
			Journey j=(Journey)ActionContext.getContext().getSession().get("targetJ");
			String uid=(String)ActionContext.getContext().getSession().get("viewer");
			List<Comment> comments=(List<Comment>)ActionContext.getContext().getSession().get("comments");
			out.print("hello,"+uid);
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
			<div id="text_div"><span><a href='userJourneyManagement'>返回旅程管理</a></span></div>
			<div class="seperator"></div>
			<!-- menu-->
			<div id="cter">
				<div id="j_contents">
					<div id='title_div'>
						<span class='x_title'><%out.print(j.getJourneyName());%></span>
						<div class='seperator2'></div>
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
											out.print("<span>所在景点</span>&nbsp;");
											out.print("<span><a class='detail_lnk' href=''>"+j.getPlaces().get(i).getAttraction().getName()+"</a></span>&nbsp;&nbsp;");
											out.print("<span>所住酒店</span>&nbsp;");
											out.print("<span><a class='detail_lnk' href=''>"+j.getPlaces().get(i).getHotel().getName()+"</a></span>&nbsp;&nbsp;");
											out.print("<span>饭店</span>&nbsp;");
											out.print("<span><a class='detail_lnk' href=''>"+j.getPlaces().get(i).getRestaurant().getName()+"</a></span>&nbsp;&nbsp;");
											out.print("<span class='eva_t' onclick='sNhCF("+j.getPlaces().get(i).getId()+")'>评价</span>");
											int csize=comments.size();
											Comment tmp=null;
											boolean commentExist=false;
											String comment=null;
											for(int k=0;k<csize;k++){
												tmp=comments.get(k);
												Attraction tmpa=j.getPlaces().get(i).getAttraction();
												Hotel tmph=j.getPlaces().get(i).getHotel();
												Restaurant tmpr=j.getPlaces().get(i).getRestaurant();
												if(tmp.getAttraction().getId()==tmpa.getId()&&tmp.getHotel().getId()==tmph.getId()&&tmp.getRestaurant().getId()==tmpr.getId()){
													commentExist=true;
													comment=tmp.getContext();
													break;
												}
											}
											out.print("<br/>");
											out.print("<div class='cfld' style='display:none' id='cfid"+j.getPlaces().get(i).getId()+"'>");
											out.print("<form action='comment' method='post'>");
											if(commentExist){
												out.print("<textarea value='"+comment+"' disabled=true ></textarea>");
											}else{
												out.print("<textarea class='cfld_f' style='width: 483px; height: 30px;' name='comment' ></textarea>");
												out.print("<input type='hidden' name='hid' value='"+j.getPlaces().get(i).getHotel().getId()+"' />");
												out.print("<input type='hidden' name='rid' value='"+j.getPlaces().get(i).getHotel().getId()+"' />");
												out.print("<input type='hidden' name='aid' value='"+j.getPlaces().get(i).getHotel().getId()+"' />");
												out.print("<input type='hidden' name='uid' value='"+uid+"' />");
												out.print("<div align='right'><span onclick='sNhCFc("+j.getPlaces().get(i).getId()+")'>取消</span><input type='submit' value='提交'></div>");
											}
											out.print("</form>");
											out.print("</div>");
										}
										
									}
								%>
								<span></span>
							</div>
						</div>
						
					</div>
					
					
				</div>
			</div>
			
			<div id="globalFooter">
			</div>
			
			
		</div>
	</body>
	<footer>
	</footer>
</html>