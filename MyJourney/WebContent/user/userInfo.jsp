<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>云游</title>
<link rel="stylesheet" href="../css/userInfo.css" type="text/css" media="screen" />

</head>
<body onload="load()">
<input id="selectnum" type="hidden" value="<s:property value='selectnum' />" />
<input type="hidden" id="ageValue" value="<s:property value='user.age' />" />
<input type="hidden" id="sexValue" value="<s:property value='user.sex'/>" />
<input type="hidden" id="emailValue" value="<s:property value='user.email' />" />
<input type="hidden" id="phoneValue" value="<s:property value='user.phone' />" />
<input type="hidden" id="cityValue" value="<s:property value='user.city' />" />
<script type="text/javascript">

function load(){

var selectnum=document.getElementById("selectnum");
var itemId="menuitem"+selectnum.value;

var item=document.getElementById(itemId);
item.style.background="#C4E1FF";
item.style.color="#D26900";
}
//弹出隐藏层

function selectItem(num){
	//alert("ok");
	clearCSS();
	
	var itemId="menuitem"+num;
	var item=document.getElementById(itemId);
	item.style.background="#C4E1FF";
	item.style.color="#D26900";
	var url="personCenterSelect"+num;
	location.href="/MyJourney/user/"+url;

}
function clearCSS(){
	// alert("ok");
	for(var i=1;i<=4;i++){
		var itemId="menuitem"+i;
		var item=document.getElementById(itemId);
		item.style.background="#ffffff";
		item.style.color="#000000";
		
		
	} 
}
function changePwd(){
	var tableId=document.getElementById("loginInfo");
	var pwdId=document.getElementById("pwd");
	var newpwdId=document.getElementById("pwdInfo");
	var confirmpwd=document.getElementById("confirmpwd");
	var submitId=document.createElement("tr");
	submitId.setAttribute("id","submit");
	pwdId.innerHTML="<td>旧密码</td><td><input type='password' name='oldpwd' value='' /></td>"
	newpwdId.innerHTML="<td>新密码</td><td><input type='password' id='newpwd'  name='newpwd' value=''/></td>";
	confirmpwd.innerHTML="<td>确认</td><td><input type='password' id='oldpwd' value='' /></td>";
	submitId.innerHTML="<td></td><td><input type='button' value='取消' onclick='cancelPwd()' /><input type='submit' value='提交' /></td>";
	tableId.appendChild(submitId);
}
function cancelPwd(){
	var tableId=document.getElementById("loginInfo");
	var pwdId=document.getElementById("pwd");
	var newpwdId=document.getElementById("pwdInfo");
	var confirmpwd=document.getElementById("confirmpwd");
	var submitId=document.getElementById("submit");
	pwdId.innerHTML=" <td width='50px'> 密码：  </td>  <td width='200px' > <div style='font-size:14px;font-family: sans-serif;'>●●●●●●</div>   </td>  <td>  <a onclick='changePwd()' >修改</a></td>";
	newpwdId.innerHTML="<td width='50px'> </td> <td  width='200px' >可用于登录，请妥善保管 </td>";
	confirmpwd.innerHTML="<td width='50px'></td> <td  width='200px' ></td>";
	tableId.removeChild(submitId);
}
function changeAge(){
	var ageId=document.getElementById("age");
	var agevalue=document.getElementById("ageValue");
	var tmpvalue="";
	
	if(agevalue.value!=null){
		tmpvalue=agevalue.value;
	}
	ageId.innerHTML="<td width='50px'>年龄</td><td width='200px'><input type='text' name='age' value='"+tmpvalue+"' /></td><td><input type='submit' value='确定' /><input type='button' value='取消' onclick='cancelAge()'/></td>";
}
function changeSex(){
	var sexId=document.getElementById("sex");
	var sexvalue=document.getElementById("sexValue");
	if(sexvalue.value==0){
	sexId.innerHTML="<td width='50px'>性别</td><td width='200px'><input type='radio' name='sex' value='1' >男<input type='radio' name='sex' value='0' checked='checked'>女</td><td><input type='submit' value='确定' /><input type='button' value='取消' onclick='cancelSex()'/></td>";
	}else{
		sexId.innerHTML="<td width='50px'>性别</td><td width='200px'><input type='radio' name='sex' value='1' checked='checked'>男<input type='radio' name='sex' value='0' >女</td><td><input type='submit' value='确定' /><input type='button' value='取消' onclick='cancelSex()'/></td>";
	}
	}
	
function changePhone(){
	var phoneId=document.getElementById("phone");
	var phonevalue=document.getElementById("phoneValue");
	var tmpvalue="";
	
	if(phonevalue.value!=null){
		tmpvalue=phonevalue.value;
	}
	phoneId.innerHTML="<td width='50px'>phone</td><td width='200px'><input type='text' name='phone' value='"+tmpvalue+"' /></td><td><input type='submit' value='确定' /><input type='button' value='取消' onclick='cancelPhone()'/></td>";
}
function changeCity(){
	var cityId=document.getElementById("city");
	var cityvalue=document.getElementById("cityValue");
	var tmpvalue="";
	
	if(cityvalue.value!=null){
		tmpvalue=cityvalue.value;
	}
	cityId.innerHTML="<td width='50px'>城市</td><td width='200px'><input type='text' name='city' value='"+tmpvalue+"' /></td><td><input type='submit' value='确定' /><input type='button' value='取消' onclick='cancelCity()'/></td>";
}
function changeEmail(){
	var emailId=document.getElementById("email");
	var emailvalue=document.getElementById("emailValue");
    var tmpvalue="";
	
	if(emailvalue.value!=null){
		tmpvalue=emailvalue.value;
	}
	emailId.innerHTML="<td width='50px'>email</td><td width='200px'><input type='text' name='email' value='"+tmpvalue+"' /></td><td><input type='submit' value='确定' /><input type='button' value='取消' onclick='cancelEmail()'/></td>";
}
function cancelAge(){
	var ageId=document.getElementById("age");
	var agevalue=document.getElementById("ageValue");
	var tmpvalue="未填";
	
	if((agevalue.value!=null)&&(agevalue.value!="")){
		tmpvalue=agevalue.value;
	}
	ageId.innerHTML="<td width='50px' >年纪:</td> <td width='270px'>"+tmpvalue+"</td> <td width='100px'> <a onclick='changeAge()'>修改</a> </td>";
}
function cancelSex(){
	var sexId=document.getElementById("sex");
	var sexvalue=document.getElementById("sexValue");
	if(sexvalue.value==0){
	sexId.innerHTML="<td width='50px' >性别:</td> <td width='270px'>女</td> <td width='100px'> <a onclick='changeSex()'>修改</a> </td>";
	}else{
	sexId.innerHTML="<td width='50px' >性别:</td> <td width='270px'>男</td> <td width='100px'> <a onclick='changeSex()'>修改</a> </td>";
	}
	}
	
function cancelPhone(){
	var phoneId=document.getElementById("phone");
	var phonevalue=document.getElementById("phoneValue");
	var tmpvalue="未填";
	
	if((phonevalue.value!=null)&&(phonevalue.value!="")){
		tmpvalue=phonevalue.value;
	}
	phoneId.innerHTML="<td width='50px' >phone:</td> <td width='270px'>"+tmpvalue+"</td> <td width='100px'> <a onclick='changePhone()'>修改</a> </td>";
}
function cancelCity(){
	var cityId=document.getElementById("city");
	var cityvalue=document.getElementById("cityValue");
	var tmpvalue="未填";
	
	if((cityvalue.value!=null)&&(cityvalue.value!="")){
		tmpvalue=cityvalue.value;
	}
	cityId.innerHTML="<td width='50px' >city:</td> <td width='270px'>"+tmpvalue+"</td> <td width='100px'> <a onclick='changeCity()'>修改</a> </td>";
}
function cancelEmail(){
	var emailId=document.getElementById("email");
	var emailvalue=document.getElementById("emailValue");
    var tmpvalue="未填";
	
	if((emailvalue.value!=null)&&(emailvalue.value!="")){
		tmpvalue=emailvalue.value;
	}
	emailId.innerHTML="<td width='50px' >email:</td> <td width='270px'>"+tmpvalue+"</td> <td width='50px'> <a onclick='changeEmail()'>修改</a> </td>";
}
</script>

<header style="margin-left:180px;">
		<h1>Where You Will Go</h1>
	</header>
	<nav>
		<ul>
			<li><a href="index">首页</a></li>
			<li><a href="Hotels">酒店</a></li>
			<li><a href="Restaurants">饭店</a></li>
			<li><a href="makeRoute">旅程</a></li>
			<li><a href="/MyJourney/pic/picwall">旅图</a></li>
			<li><a href="userJourneyManagement">管理</a></li>
			<li class="selected"><a href="#">个人中心</a></li>
			<li class="subscribe"><a href="#"></a></li>
		</ul>
	</nav>
<div id="outer">
    <div id="outerContent">
    	<div id="kong"></div> 
	<div id="content">
		<section id="left">
          <section id="head">
	          <div id="headimage">
	          	<img alt="" src="${user.image }" width="50px;" height="50px;" >
	          </div>
	          <div id="headright">
	          <h4>欢迎回来</h4>
	          <a href="#" style="text-decoration: none;color:#484891">${user.name }</a></br>
	          <a href="#" style="text-decoration: none;">修改资料</a>
	         </div>
	         
          </section>
			<section id="menu">
			<section id="menuitem1"  class="menuitem" onclick="selectItem(1)" >
			<h3>登陆信息</h3>
			</section>
			<section id="menuitem2"  class="menuitem" onclick="selectItem(2)">
			<h3>个人信息</h3>
			</section>
			<section id="menuitem3"  class="menuitem" onclick="selectItem(3)">
			<h3>账号绑定</h3>
			</section>
			<section id="menuitem4"  class="menuitem" onclick="selectItem(4)">
			<h3>我的攻略</h3>
			</section>		
		</section>
		</section>
	       <aside>
			<section id="right">
			<div style="margin-top:-80px;">
			<s:if test="selectnum==1" >
		     <div id="itemContent1" >
		     
		     <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>登陆信息
		     <div style="border-top: 1px dashed #D26900;">
		     <div style="border-bottom: 1px dashed #D26900;">
		     <h3><font color="#D26900">欢迎来到云游</font></h3>
		     </div>
		     <form action="changePwd" method="post">
		     <table style="margin-left:80px;margin-top:30px" id="loginInfo">
		     <tr>
		        <td width="50px">
		                 账号:
		        </td>
		        <td width="200px">
		         <s:property value="account" />
		        </td>
		        <td>
		        </td>
		     </tr>
		     <tr>
		        <td width="50px">
		        </td>
		        <td width="200px">
		               可用于登录，请妥善保管
		        </td>
		        <td>
		        </td>
		     </tr>
		     <tr id="pwd">
		        <td width="50px">
		                密码：
		        </td>
		        <td width="200px" >
		        <div style="font-size:14px;font-family: sans-serif;">●●●●●●</div>
		        </td>
		        <td>
		        <a onclick="changePwd()" >修改</a>
		        </td>
		     </tr>
		     <tr id="pwdInfo">
		        <td width="50px">
		        </td>
		        <td  width="200px" >
		               可用于登录，请妥善保管
		        </td>
		     </tr>
		       <tr id="confirmpwd">
		        <td width="50px">
		        </td>
		        <td  width="200px" >
		             
		        </td>
		     </tr>
		     </table>
		     </form>
		     </div>
		     </div>		    
		     </s:if>
		    <s:if test="selectnum==2" >
	          <div id="itemContent2">
	        <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>个人信息
	           <div style="border-top: 1px dashed #D26900;">
		     <div style="border-bottom: 1px dashed #D26900;">
		      <h3><font color="#D26900">欢迎来到云游</font></h3>
		     </div>
		     <form action="changeAge" method="post" >
		     <table style="margin-left:80px;margin-top:30px">
		     <tr id="age">
		     <td width="50px" >
		          年纪:
		     </td>
		     <td width="270px">
		     <s:if test="user.age==null">
		          未填
		      </s:if>
		          <s:property value="user.age" />
		      
		     </td>
		     <td width="100px">
		      <a onclick="changeAge()">修改</a>
		     </td>
		     </tr>
		     </table>
		     </form>
		     
		     <form action="changeSex" method="post">
		     <table style="margin-left:80px">
		     <tr id="sex">
		      <td width="50px"  >
		           性别:
		     </td>
		     <td width="270px">
		      <s:if test="user.sex==1">
		            男

		      </s:if>
		      <s:elseif test="user.sex==0">
		           女

		      </s:elseif>
		   
		      <s:else>
		           未填
		      </s:else>
		     </td>
		     <td width="100px">
		        <a onclick="changeSex()">修改</a>
		     </td>
		     </tr>
		     </table>
		     </form>
		     
		     <form action="changeCity" method="post">
		     <table style="margin-left:80px">
		     <tr id="city">
		      <td width="50px" >
		          城市:
		     </td>
		     <td width="270px">
		      <s:if test="user.city==null">
		          未填
		      </s:if>
		     <s:property value="user.city" />
		     
		     </td>
		     <td width="100px">
		        <a onclick="changeCity()">修改</a>
		     </td>
		     </tr>
		     </table>
		     </form>
		     
		     <form  action="changeEmail" method="post">
		     <table style="margin-left:80px">
		     <tr id="email">
		      <td width="50px" >
		      email:
		     </td>
		     <td width="270px">
		     <s:if test="user.email==null">
		          未填
		      </s:if>
		     <s:property value="user.email"/>
		     
		     </td>
		     <td width="100px">
		         <a onclick="changeEmail()">修改</a>
		     </td>
		     </tr>
		     </table>
		    </form>
		     <form action="changePhone" method="post">
		     <table style="margin-left:80px">
		      <tr id="phone">
		      <td width="50px" >
		      phone:
		     </td>
		     <td width="270px">
		     <s:if test="user.phone==null">
		          未填
		      </s:if>
		     <s:property value="user.phone"/>
		    
		     </td>
		     <td width="100px">
		      <a onclick="changePhone()">修改</a>
		     </td>
		     </tr>
		     </table>
		     </form>
		       <form action="/MyJourney/pic/createHeadPhoto" method="post" enctype="multipart/form-data">
		     <table style="margin-left:80px">
		      <tr id="phone">
		      <td width="55px" >
		          头像:
		     </td>
		     <td width="190px">
		      		<input type="file" name="photo"/><br>
		      		<input type="hidden" name="person" value="person">
		     </td>
             <td width="100px">
             <input type="submit" value="修改">
           <!-- <a click="">提交</a> -->
             </td>
		     </tr>
		     </table>
		     </form>
		     </div>
		     </div>
		     </s:if>
		     <s:if test="selectnum==3">
		      <div id="itemContent3">
		    <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>账号绑定
		       <div style="border-top: 1px dashed #D26900;">
		     <div style="border-bottom: 1px dashed #D26900;">
		      <h3><font color="#D26900">欢迎来到云游</font></h3>
		     </div>
		 		  <!-- 人人账号绑定TO DO -->
		 		  <a href="https://graph.renren.com/oauth/authorize?client_id=${client_id }&response_type=code&redirect_uri=${redirect_url }&display=page">
        <img style="border:0px" src="../sns/RENREN.png"/></a>
		     </div>
		     </div>
		     </s:if>
		     <s:if test="selectnum==4">
		      <div id="itemContent4">
		      <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>我的攻略
		       <div style="border-top: 1px dashed #D26900;">
		     <div style="border-bottom: 1px dashed #D26900;">
		      <h3><font color="#D26900">欢迎来到云游</font></h3>
		     </div>
		          您的行程如下:
		     <s:iterator value="journeylist" var="journey">
		      <h3><a href="/MyJourney/user/editRoute?routeId=<s:property value='#journey.id' />&selectnum=1"><s:property value="#journey.journeyName" /></a></h3>
		     </s:iterator>
		     </div>
		     </div>
		     </s:if>
		      </div>
			</section>
			
		</aside>
	</div>
	
	<div id="kong"></div> 
	</div>
	</div>
	<footer>
		<div>
			<section id="about">
				<header>
					<h3>About</h3>
				</header>
				<p> <a href="#">云游网是一个集合网络社交的旅游行程规划网站</a> </br>
				<a href="#">你的加入会使得世界变得从此不同</a>
				</p>
			</section>
			<section id="blogroll">
				<header>
					<h3>Blogroll</h3>
				</header>
				<ul>
					<li><a href="#">NETTUTS+</a></li>
					<li><a href="#">FreelanceSwitch</a></li>
					<li><a href="#">In The Woods</a></li>
					<li><a href="#">Netsetter</a></li>
					<li><a href="#">PSDTUTS+</a></li>
				</ul>
			</section>
		</div>
	</footer>


</body>
</html>