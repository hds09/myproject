<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="concernedList" var="daren">
	<jsp:include page="darenItem.jsp"></jsp:include>
</s:iterator>