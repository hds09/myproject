<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>达人主页</title>
<style type="text/css">
	@IMPORT "../css/common.css";
	@IMPORT "../css/banner.css";
	@import "../darenHome/resource/2.css";
	@import "../darenHome/resource/3.css";
	@import "../darenHome/resource/4.css";
</style>
<script type="text/javascript">
	function showD(){
		document.getElementById("uploadDialog").style.display = 'block';
	}
	function hideDialog(){
		document.getElementById("uploadDialog").style.display = 'none';
	}
</script>
<script src="./resource/base-2013040215135502.js"></script>
<script src="../js/h.js"></script>
<script src="../js/base-2013040215135502.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<!--中间内容-->
	<div class="personal_main mt10 fn-bc fn-ohidden">
		<jsp:include page="pictureContext.jsp"></jsp:include>
		<jsp:include page="darenInfo.jsp"></jsp:include>
	</div>
	<!--中间内容 end-->
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>