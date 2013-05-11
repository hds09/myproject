<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="wrapper fn-bc" style="height:1180px;">
	<s:iterator value="picList" var="pic">
		 <jsp:include page="wall0.jsp"></jsp:include>
	</s:iterator>
</div>