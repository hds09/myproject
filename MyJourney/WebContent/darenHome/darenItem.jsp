<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="lvtu_daren_intro border-bs-gray fn-clearfix">
	<div class="lvtu_daren_intro_l fn-fl">
		<div class="lvtu_daren_person p10 fn-ohidden">
			<div id="focus89435" class="lvtu_personal_person_l fn-fl">
				<a href="home?darenId=${daren.uid }" title="${daren.name }">
				   <img class="npic" src="${daren.image }" width="150" height="150">
				</a>
				<s:if test="daren.hasAttention==1">
					<p class="lvtu_daren_attention_add"><a href="/MyJourney/ajax/addAttention?AttentionAccount=${daren.account }"></a></p>
				</s:if>
			</div>
			<div class="lvtu_personal_person_r_dr fn-fl ml20">
				<a href="home?darenId=${daren.uid }" title="${daren.name }">
				   <h3 class="black f16 fb fn-enter">${daren.name }</h3>
				</a>
				<p class="mt10">
					<s:if test="daren.sex==1">
						<span class="lvtu_personal_user_male fn-fl png24"></span> 
					</s:if>
					<s:else>
						<span class="lvtu_personal_user_female fn-fl png24"></span> 
					</s:else>
					<span class="lvtu_personal_user_eredar fn-fl png24"></span>
  				</p>
				<div class="lvtu_daren_fineDetail mt50">
					<ul>
					<li class="w50 fn-fl"><em class="deongaree f16 fb"><a href="关注页面">${daren.attentionNum }</a></em><br><span class="darkgray f12">关注</span></li>         
					<li class="w50 fn-fl"><em id="fans89435" class="deongaree f16 fb"><a href="粉丝页面" class="fans">${daren.concernedNum }</a></em><br><span class="darkgray f12">粉丝</span></li>        
					<li class="w50 fn-fl"><em class="deongaree f16 fb">${daren.journeyNum }</em><br><span class="darkgray f12">旅行</span></li>        
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="lvtu_daren_intro_r fn-fr">
          <div class="lvtu_daren_picList mt5 ml15 fn-clearfix">
	          <ul>
	          <!--图片列表集 循环-->
		          	<s:iterator value="#daren.pictureList" var="picture">
			              <li class="daren_list_item">
				              <a href="album?albumId=${picture.journeyId }">
				             		 <img class="npic" src="${picture.image.imagepath }"  width="130" height="130" >
				              </a>
			              </li>
	              </s:iterator>
	       </ul>
       </div>
       <div class="fn-fr mt10 deongaree"></div>
	</div>
</div>