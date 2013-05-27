<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet"  type="text/css" href="../css/head.css" />
<!--页头开始-->
		<header class="lvtu_header">
		<div class="q_header q_header_lvtu">
    		 <div class="qn_nav">
    		   <div class="qn_header wrapper">
	    		   <div class="inner">
		    		   <div class="qn_nav_indexNav darkgray666 pl15 png24">
			    		    <ul>
			    		     <li><a href="/MyJourney/user/index" target="_top" hidefocus="on">首页<span class="i"></span></a></li>
			    		     <li><a href="/MyJourney/user/Hotels" target="_top" hidefocus="on">酒店<span class="i"></span></a></li> 
			    		     <li><a href="/MyJourney/user/Restaurants" target="_top" hidefocus="on">饭店<span class="i"></span></a></li> 
			    		     <li><a href="/MyJourney/user/makeRoute" target="_top" hidefocus="on">旅程<span class="i"></span></a></li>
			    		     <li><a href="/MyJourney/pic/picwall" target="_top" hidefocus="on">旅图<span class="i"></span></a></li> 
			    		     <li><a href="/MyJourney/user/userJourneyManagement" target="_top" hidefocus="on">管理<span class="i"></span></a></li> 
			    		     <li><a href="/MyJourney/user/personCenterSelect1" target="_top" hidefocus="on">个人中心<span class="i"></span></a></li> 
			    		    </ul> 
		    		   </div> 
		    		   
		    		   <div class="q_header_tnav">
			    		    <ul> 
			    		    	<s:if test="#session.account!=null">
				    		    	<li id="__loginInfo_u__" class="q_header_username fn-nonehead" ><a href="/MyJourney/pic/home?account=${session.account }" hidefocus="on" class="q_header_uname" rel="nofollow">${session.account }</a></li> 
				    		        <li id="__loginInfo_r__"><a href="/MyJourney/user/logout" hidefocus="on" rel="nofollow">退出</a></li> 
			    		    	</s:if>
			    		    	<s:else>
			    		    		<li class="q_header_username darkgray666 J-popUp fn-cursor"><a href="javascript:showLogin()" hidefocus="on" rel="nofollow">登录</a></li> 
									<jsp:include page="login.html"></jsp:include>
			    		    	</s:else>
			    		        
			    		        <li class="last">      </li> 
			    		    </ul>
		    		   </div>
	    		   </div> 
    		   </div> 
    		</div>
		</div>
		<!--LOGO && 导航-->
<jsp:include page="nav.jsp"></jsp:include>
		</header>
		<!--页头结束-->