<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>达人秀</title>
	<style type="text/css">
		#pioneer{
			width: 300px;
			height: 770px;
			padding-left:20px;
			border: 1px solid #C9C9C9;
			background-color: #C9C9C9;
			border-radius: 18px;
			-moz-border-radius: 18px;
			-webkit-border-radius: 18px;
			background:-webkit-gradient(linear, left top, left bottom, from(#EAEAEA), to(#C9C9C9));
			opacity:0.7;
		}
	</style>
</head>
<body>
	<s:action name="" ></s:action>
	<s:doubleselect doubleList="" list="" doubleName=""></s:doubleselect>
	<s:updownselect list=""></s:updownselect>
	<section id="pioneer"><!-- 达人 -->
	<h2>达人<font color="red">秀</font></h2>
	<div class="lvtu_daren_content w980 fn-bc">
		<s:iterator value="darenList" var="dr">
			
		</s:iterator>
	</div>
	</section>
</body>
</html>