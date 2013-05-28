<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传图片</title>
<style type="text/css">
	@IMPORT "../css/common.css";
	@IMPORT "../css/banner.css";
	
		
	.black_overlay{
	display: none;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index:10000;
	-moz-opacity: 0.8;
	opacity:0.8;
	filter: alpha(opacity=0);
	}
	.white_content {
	margin-top:200px;
	margin-left:350px;
	position: absolute;
	top: 5%;
	left: 10%;
	width: 480px;;
	height: 180px;
	opacity:1.0;
	border: 16px solid #CCEEFF;
	background-color:#CCEEFF;
	z-index:10001;
	
	}
	span
	{
		font-size: 16px;
		font-weight: bold;
		margin-right: 20px;
	}
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript">
	function changePlaceId(id){
		$("#placeId").value = id;
	}
	$(".pl15 > li").click(function(){
		$(this).addClass("highlight").end().siblings().removeClass("highlight");
	});
	
	function showD(){
		document.getElementById("uploadDialog").style.display = 'block';
	}
	function hideD(){
		document.getElementById("uploadDialog").style.display = 'none';
	}
</script>
</head>
<body class="bodybg">
<jsp:include page="/module/header.jsp"></jsp:include>
<!-- 发表游记的部分 
<jsp:include page="addPictures.jsp"></jsp:include>-->
<div class="wrapper fn-bc fn-pr mt20" style="background:rgba(255,255,255,0.7);">
	<div class="fn-pr">
		<div class="lvtu_specialadd_title f16 fb darkgray png24 ml10">发布新游记</div>
		<div class="fn-ohidden wrapper fn-bc fn-pr mt10" style="border-top:1px solid #ddd;">
			<!-- 左边的nav导航 -->
			<div class="w300 fn-fl" style="border-right:1px solid #ddd;">
				<ul class="f16 fn-ohidden ml10">
					<li class="pl15 fb" >我的旅行：</li>
					<s:iterator value="journeyList" var="journey" status="sta">
						<s:if test="#sta.index==journeyIndex">
							<li class="pl15 hili" ><a href="/MyJourney/pic/userJourney?journeyIndex=${sta.index }">${journey.journeyName}</a>
							</li>
						</s:if>
						<s:else>
							<li class="pl15" ><a href="/MyJourney/pic/userJourney?journeyIndex=${sta.index }">${journey.journeyName}</a>
							</li>
						</s:else>
					</s:iterator>
				</ul>
			</div>
			<!-- 右边的图片区域 -->
			<div class="w800 fn-fl ml20" style="border:1px solid #ddd;">
				<div class="w800 fn-ohidden f20 fb" style="height:40px;">
					${journeyList.get(journeyIndex).journeyName}
					<s:iterator value="placeList" var="place" status="sta">
							<s:if test="#place.city != null">
								-><a href="/MyJourney/pic/userJourney?journeyIndex=${journeyIndex }&placeId=${place.id }">${place.city.name }</a>
							</s:if>
					</s:iterator>
					<img width="33px" height="33px" alt="添加图片" src="/MyJourney/createAlbum/resource/addpic.jpg" onclick="showD()" style="float:right;margin-right: 20px;box-shadow:1px #ef3;cursor: pointer;">	
				</div>
				<%-- <s:if test="placeList.size()>0">
					<form action="/MyJourney/pic/createAlbum"  method="post" enctype="multipart/form-data">
						<input id="placeId" name="placeId" type="hidden" value="${placeList.get(placeIndex).id }"/>
						<input type="file" name="picList"/>
						<input value="上传" type="submit"/>
					</form>
				</s:if> --%>
				<s:iterator value="pictureList" var="image">
	           		<div class="J-hidden"></div>
	           		<div class="travels_right_cont fn-pr fn-tc">
		                <a href="" class="travels_right_img  fn-pr">
		                	<span class="travels_arrows fn-pa" style="width:782px"></span>
		            		<img class="qpic" src="${image.imagepath }" width="782" height="499">
		            		
		                </a>
	            	</div>
	            </s:iterator>
	            <s:if test="pictureList.size()==0">
	            	<div class="J-hidden"></div>
	           		<div class="travels_right_cont fn-pr fn-tc">
	                	<span class="travels_arrows fn-pa" style="width:782px"></span>
	            		<img class="qpic" src="/MyJourney/createAlbum/resource/default.jpg" width="782" height="499" alt="请上传图片">
	            	</div>
	            </s:if>
			</div>
		</div>
	</div>
</div>
<div id="uploadDialog" class="black_overlay">
	<div class="white_content">
		<a href="javascript:hideD()" style="float:right;margin-right:20px;">关闭</a>
		<span>旅行:${journeyList.get(journeyIndex).journeyName}</span>
		<span>地点:${placeList.get(placeIndex).city.name }</span>
		<span>共有图片:${pictureList.size() }</span>
		<form style="margin-top:20px;" action="/MyJourney/pic/createAlbum"  method="post" enctype="multipart/form-data">
			<input id="placeId" name="placeId" type="hidden" value="${placeList.get(placeIndex).id }"/>
			<input id="journeyIndex" name="journeyIndex" type="hidden" value="${journeyIndex}">
			<input class="f16 fb" type="file" name="picList"/>
			<input class="f16 fb" value="添加图片" type="submit"/>
		</form>
	</div>
</div>
<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>