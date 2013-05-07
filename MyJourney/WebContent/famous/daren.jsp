<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>达人们</title>
<style type="text/css">
	@IMPORT "../css/common.css";
	@IMPORT "../css/banner.css";
	@import "../famous/resource/2.css";
</style>
<script src="../js/h.js"></script></head>
</head>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<jsp:include page="darenContext.jsp"></jsp:include>
	<jsp:include page="darenList.jsp"></jsp:include>
	<jsp:include page="/module/bottomIndex.jsp"></jsp:include>
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>