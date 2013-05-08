<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<!--页头开始-->
	<div class="lvtu_header">
		<div class="q_header q_header_lvtu">
    		 <div class="qn_nav">
    		  <div class="qn_header wrapper">
    		   <div class="inner">
    		    <div class="qn_nav_indexNav darkgray666 pl15 png24">
    		     <ul>
    		      <li><a href="" target="_top" hidefocus="on">旅行行程规划首页<span class="i"></span></a></li>
    		       <li><a href="" target="_top" hidefocus="on">攻略<span class="i"></span><em class="new"></em></a></li>
    		     </ul>
    		    </div> 
    		   <div class="q_header_tnav">
    		    <ul>
    		     <s:if test="#session.account==null">
    		     	<li id="__loginInfo_btn__" class="q_header_username"><a href="home" class="q_header_uname">登录</a></li>
    		     	<li id="__registerInfo_btn__" class="q_header_username"><a href="" class="q_header_uname">注册</a></li>
    		     </s:if>
    		     <s:else>
	    		     <li id="__loginInfo_u__" class="q_header_username"><a href="" hidefocus="on" class="q_header_uname">TenX</a></li>
	    		     <li id="__loginInfo_r__"><a href="" hidefocus="on">退出</a></li>
    		    </s:else>
    		    </ul>
    		   </div>
    		  </div>
    		 </div>
    	  </div>
		</div>
		<!--LOGO && 导航-->
		<div class="lvtu_nav_bg">
		<div class="lvtu_nav fn-pr wrapper">
			<div class="lvtu_logo fn-fl">
				<a href="" target="_blank">
					<img src="./resource/lvtu_logo_new.jpg" width="175" height="61" alt="旅图首页">
				</a>
			</div>
			<div class="lvtu_nav_list fn-pa">
		        <div id="webwidget_menu_glide2" class="lvtu_home_nav whitef4 fb webwidget_menu_glide" style="">
		            <div class="webwidget_menu_glide_sprite" style="width: 120px; height: 36px; left: 360px;">
		            </div>
		            <ul>
		                <li id="index" class="fn-tc" style=" width: 120px; height: 36px;">
			                <a href="" style="font-size: 15px;">旅图</a>
							<img src="./resource/lvtu_line_2_2_2.gif" class="fn-abs-right">
						</li>
		                <li id="daren" class="fn-tc" style=" width: 120px; height: 36px;">
		                	<a href="" style="font-size: 15px;">相册</a>
		                	<img src="./resource/lvtu_line_2_2_2.gif" class="fn-abs-right">
		                </li>
		                <li id="iphone" class="fn-tc" style=" width: 120px; height: 36px;">
			                <a href="" style="font-size: 15px;">主页</a>
			                <a href="" class="lvtu_ad fn-pa png24" style="font-size: 15px;"></a>
		                	<img src="./resource/lvtu_line_2_2_2.gif" class="fn-abs-right">
		                </li>
						<li class="person current" style=" width: 120px; height: 36px;">
							<a id="persons" href="javascript:void(0);" style="font-size: 15px;">我的旅图</a>
							<!-- 
							<span class="J-arrows down_arrows fn-pa png24"></span>
							<div class="person_list pt5 fn-pa fn-none fn-clearfix">
							<p class="myhome">我的主页</p>
							<p class="myfriend">我的好友</p>
							<p class="mylike">我的喜欢</p>
							<p class="commentandmessage">评论通知</p>
							<p class="accountset">账号设置</p>
							<p class="bind">社交绑定</p>
							</div>
							 -->
						</li>
		            </ul>
		            <div style="clear: both"></div>
		        </div>
		     </div>
			<!--旅图其他信息-->
			<div class="J-publish lvtu_addtravels fn-fr"></div>
			<input type="hidden" id="userid" value="136272">
		</div>
		</div>
		<div class="lvtu_top_line_b"></div>
	</div>
	<!--页头结束-->
		