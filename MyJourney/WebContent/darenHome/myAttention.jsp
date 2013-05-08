<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="attentionList" var="daren">
	<jsp:include page="darenItem.jsp"></jsp:include>
</s:iterator>