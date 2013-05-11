<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!--个人登录后右侧内容-->
<div class="personal_sidebar fn-pr fn-fr fn-bc ml20">
   	<span class="corner_tips fn-pa png24"></span>
   	
   	<p class="personal_picture fn-pr png24">
   		<a href="javascript:showD()"><img class="qpic fn-pa" src="${daren.image }" width="200" height="200"></a>
   		<div id="uploadDialog" style="display:none">
   			<s:if test="daren.account==#session.account">
				<form action="/MyJourney/pic/createHeadPhoto" method="post" enctype="multipart/form-data">
					<input type="file" name="photo"/><br>
					<input value="上传" type="submit"/>
					<input type="button" value="取消" onclick="hideDialog()"> 
				</form>
			</s:if>
		</div>
   	</p>
     <h2 class="font-yahei ml5 darkgray fn-enter">${daren.name } </h2>
     <span id="focus" class="ml5 mt10 fn-block">
     	<s:if test="daren.hasAttention == 1">
     		<a href="/MyJourney/ajax/addAttention?AttentionAccount=${daren.account }"><p class="personal_attention_add png24"></p></a>
     	</s:if>
	 </span>
     <ul>
      <li>${daren.meassageNum } 条留言</li>
      <li><span class="personal_total"><a href="">${daren.journeyNum } 篇游记</a></span></li>
      <li>${daren.teamNum } 次团队旅行</li>
      <li class="personal_total"><a href=""><span id="focusNum"> ${daren.attentionNum }</span> 关注</a>，
      <a href=""><span id="fans">${daren.concernedNum }</span> 粉丝 </a> </li>
     </ul>
</div>
<!--personal_sidebar end-->
    