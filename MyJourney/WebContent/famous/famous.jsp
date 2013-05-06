<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./resource/daren-2013022610453602.css" rel="stylesheet" type="text/css">
<script src="./resource/h.js"></script>
<title>已经被daren.jsp页面代替了</title>
</head>
<body>
<div class="lvtu_container">
<jsp:include page="/module/head.jsp"></jsp:include>
		<!--内容 瀑布流-->
		<div class="gray_bg fn-clearfix">
		<div class="w980 darkgray999 fn-bc mb10"><a href="http://lvtu.qunar.com/">旅图首页</a>  &gt; 达人列表</div>
		<div class="w980 fn-bc lvtu_daren_info fn-ohidden border-bs-gray pb10">
		<div class="lvtu_daren_info_l fn-fl mr10"><img src="./resource/lvtu_daren_ad_1.jpg" width="670" height="260"></div>
		<div class="lvtu_daren_info_r fn-fr">
			<div class="pt15 pr15 pl15">
    		<h3 class="f14 fb mb5">什么是旅图达人？</h3>
   			<p class="lh180 mb5 pb5 border-bd-gray darkgray fn-pr">旅图达人，是旅途中的活跃分子，是旅图推出的一个真实的旅行美图分享家舞台... <span class="ui-activity-more deongaree fn-pa"><a href="http://lvtu.qunar.com/mobile_ugc/web/darenDetail.htm#daren_a">更多详情&gt;&gt;</a></span></p>
			<h3 class="f14 fb mt5 mb5">如何成为旅图达人？</h3>
    		<p class="lh180 mb5 pb5 border-bd-gray darkgray fn-pr">成为达人的你，不仅爱玩儿爱拍，还酷爱分享，喜欢随时随地上传美图参与互动... <span class="ui-activity-more deongaree fn-pa"><a href="http://lvtu.qunar.com/mobile_ugc/web/darenDetail.htm#daren_b">更多详情&gt;&gt;</a></span></p>
    		<h3 class="f14 fb mt5 mb5">达人特权</h3>
    		<p class="lh180 darkgray fn-pr">专属身份标识 专属达人活动 专属达人礼品 大型活动优先获取权 达人专享推荐... <span class="ui-activity-more deongaree fn-pa"><a href="http://lvtu.qunar.com/mobile_ugc/web/darenDetail.htm#daren_c">详细说明&gt;&gt;</a></span></p>
   		 	</div>
		</div>
		</div>
		
		
		<div class="lvtu_daren_content w980 fn-bc">
			<s:iterator value="dessertList" var="dessert">
				<jsp:include page="darenList.jsp"></jsp:include>
			</s:iterator>
		</div>
		
		<div class="lvtu_lineBetween fn-bc mt20 mb20 png24"></div>
		 <div id="pagination" class="pagination darkgray pb20"><a href="http://lvtu.qunar.com/mobile_ugc/#1" class="first png24">首页</a><a href="http://lvtu.qunar.com/mobile_ugc/#1" class="prev png24">前一页</a><span class="current">1</span><em><a href="http://lvtu.qunar.com/mobile_ugc/#2">2</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#3">3</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#4">4</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#5">5</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#6">6</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#7">7</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#8">8</a></em><em><a href="http://lvtu.qunar.com/mobile_ugc/#9">9</a></em><a href="http://lvtu.qunar.com/mobile_ugc/#2" class="next png24">下一页</a><a href="http://lvtu.qunar.com/mobile_ugc/#34" class="last png24">末页</a></div>
		</div>
	</div>
<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>