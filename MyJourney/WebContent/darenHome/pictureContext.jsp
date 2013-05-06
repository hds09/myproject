<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--内容-->
	
	<div class="personal_content fn-fl">
		<s:iterator value="journeyList" var="journey">
    		<jsp:include page="pictureModel.jsp"></jsp:include>
   		</s:iterator>
     	<jsp:include page="/module/bottomIndex.jsp"></jsp:include>
     <!--图片模块 结束-->
    </div>
    <!--personal_content end-->
 