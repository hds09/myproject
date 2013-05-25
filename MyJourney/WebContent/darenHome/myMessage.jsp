<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="personal_content fn-fl">
	<s:iterator value="messageList" var="reply">
		<div style="width:850px;border-top:1px dotted #000;border-bottom: 1px dotted #000;">
			<div style="font-size: 16px;padding:10px 5px 15px 20px;">
				<span>留言来自：${reply.account_from }</span>
			</div>
		 	<div style="padding:0px 15px 15px 20px;height:90px;">
				<div style="height:90px;overflow:scroll;">&nbsp;&nbsp;${reply.context }</div>
				<div style="overflow: none">
					<button style="float:right;border: medium none;line-height:25px;font-size:16px;font-weight:bold;color:rgb(255,255,255);cursor:pointer;background:rgb(103, 160, 13)">回复</button>
				</div>
		 	</div>
		</div>
	</s:iterator>
    <!--图片模块 结束-->
</div>