<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- 页面底部的分页导航--%>

<div id="pagination" class="pagination darkgray mt20 mb20 fn-tc">
	<s:if test="page!=0">
		<a href="${path}0" class="first png24">首页</a>
		<a href="${path }${page-1}" class="prev png24">前一页</a>
	</s:if>
	<span class="current">${page+1 }</span>
	<s:if test="page != pageMax">
		<a href="${path }${page+1}" class="next png24">下一页</a>
		<a href="${path }${pageMax-1}" class="last png24">末页</a>
	</s:if>
</div>
