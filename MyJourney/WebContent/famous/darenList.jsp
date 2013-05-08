<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="lvtu_daren_content w980 fn-bc">
	<s:iterator value="darenList" var="dr">
		<jsp:include page="darenItem.jsp"></jsp:include>
	</s:iterator>
</div>