<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传图片</title>
<style type="text/css">
	@import "../createAlbum/resource/0.css";
	@IMPORT "../css/common.css";
	@IMPORT "../css/banner.css";
	@import "../createAlbum/resource/3.css";
	
	.highlight
	{
		background-color: rgba(a,3,8,0.8);
	}
	
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript">
	function changePlaceId(id){
		$("#placeId").value = id;
	}
	$("li.pl15").click(function(){
		$(this).addClass("highlight").end().siblings().removeClass("highlight");
	});
</script>
</head>
<body class="bodybg">
<jsp:include page="/module/header.jsp"></jsp:include>
<!-- 发表游记的部分 
<jsp:include page="addPictures.jsp"></jsp:include>-->
<div class="wrapper fn-bc fn-pr mt20" style="background:rgba(255,255,255,0.7);">
	<div class="fn-pr">
		<div class="lvtu_specialadd_title f16 fb darkgray png24">发布新游记</div>
		<div class="fn-ohidden wrapper fn-bc fn-pr mt10" style="border-top:1px solid #ddd;">
			<!-- 左边的nav导航 -->
			<div class="w300 fn-fl" style="border-right:1px solid #ddd;">
				<ul class="f16 fn-ohidden ">
					<li class="pl15 fb" >我的旅行：</li>
					<s:iterator value="journeyList" var="journey" status="sta">
						<li class="pl15" ><a href="/MyJourney/pic/userJourney?journeyIndex=${sta.index }">${journey.journeyName}</a>
						</li>
					</s:iterator>
				</ul>
			</div>
			<!-- 右边的图片区域 -->
			<div class="w800 fn-fl ml20" style="border:1px solid #ddd;">
				<div class="w800" style="height:18px;">
					${journeyList.get(journeyIndex).journeyName}
					<s:iterator value="placeList" var="place" status="sta">
							-><a href="/MyJourney/pic/userJourney?journeyIndex=${journeyIndex }&&placeIndex=${sta.index}">${place.id }</a>
					</s:iterator>
				</div>
				<s:if test="placeList.size()>0">
					<form action="/MyJourney/pic/createAlbum"  method="post" enctype="multipart/form-data">
						<input id="placeId" name="placeId" type="hidden" value="${placeList.get(placeIndex).id }"/>
						<input type="file" name="picList"/>
						<input value="上传" type="submit"/>
					</form>
				</s:if>
				<s:iterator value="pictureList" var="image">
	           		<div class="J-hidden"></div>
	           		<div class="travels_right_cont fn-pr fn-tc">
		                <a href="" class="travels_right_img  fn-pr">
		                	<span class="travels_arrows fn-pa" style="width:782px"></span>
		            		   <img class="qpic" src="${image.imagepath }" width="782" height="499" alt="">
		                </a>
	            	</div>
	            </s:iterator>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>