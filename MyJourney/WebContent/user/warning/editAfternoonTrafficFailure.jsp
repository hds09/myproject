<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var selectnum=document.getElementById("selectnum");
alert("编辑失败");
location.href="/MyJourney/user/editRoute?selectnum="+selectnum.value;
</script>
</body>
</html>