<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--图片模块 开始-->
<div class="personal_pic border-bd-gray pb30 fn-bc">
   	<div class="personal_pic_tit fn-bc fn-clearfix mt20 mb20">
       <h1 class="personal_title fn-fl font-yahei darkgray">${journey.journeyName} </h1>
       <span class="personal_ie6_7 bbb fn-fl ml10 mt20">
			<s:if test="#journey.state==1">
				进行中
			</s:if>
			<s:else>
				已结束
			</s:else>
		</span>
    </div>
    <s:if test="journey.places.size>0">
	   	<div class="personal_pic_status fn-pr fn-bc">
	        <span class="time fn-tc fn-pa png24">
	            <em class="time_day font-tahoma darkgray fn-block">${journey.places.get(0).time.getDay() }</em>
	            <em class="font-tahoma f14 darkgray fn-block">${journey.places.get(0).time.getYear() }/${journey.place.get(0).time.getMonth() }</em>
	        </span>
	       	<span class="fn-tc fn-pa png24"></span>
	       	<div class="J-img fn-pr fn-tc fn-ohidden">
		       	<a href="/MyJourney/pic/album?albumId=${journey.id }">
			       	<div class="J-img fn-pr fn-tc fn-ohidden">
		           		<p class="fn-tl f20 fb fn-omit darkgray999">
							<s:iterator value="journey.places" var="place" status="sta">
			               		${place.city.name }
			               		<s:if test="!#sta.last">-></s:if>
			               	</s:iterator>
						</p>
						<p>
						<s:iterator value="journey.places" var="place" status="sta">
			               		${place.city.name }
			               		<s:if test="!#sta.last">-></s:if>
			               	</s:iterator></p>
		            </div>
	            </a>
            </div>
	    </div>
    </s:if>
</div>
     