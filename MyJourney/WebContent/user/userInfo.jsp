<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>云游</title>
<link rel="stylesheet" href="../css/userInfo.css" type="text/css" media="screen" />

</head>
<body>
<script type="text/javascript">
//弹出隐藏层
function selectItem(num){
	//alert("ok");
	clearCSS();
	
	var itemId="menuitem"+num;
	var item=document.getElementById(itemId);
	item.style.background="#C4E1FF";
	item.style.color="#D26900";

	
	
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
</script>
<header style="margin-left:180px;">
		<h1>Where You Will Go</h1>
	</header>
	<nav>
		<ul>
			<li><a href="index">首页</a></li>
			<li><a href="#">酒店</a></li>
			<li><a href="#">饭店</a></li>
			<li><a href="makeRoute">旅程</a></li>
			<li><a href="#">旅图</a></li>
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
	          </div>
	          <div id="headright">
	          <h4>欢迎回来</h4>
	          <a href="#" style="text-decoration: none;color:#484891">hds</a></br>
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
		     <table style="margin-left:100px;">
		     <tr>
		     <td >
		          账号:
		     </td>
		     <td>
		         hds <s:property value="" />
		     </td>
		     </tr>
		     <tr>
		     <td>
		            密码：
		     </td>
		     <td>
		     <div style="font-size:14px;font-family: sans-serif;">●●●●●●</div>
		     </td>
		     </tr>
		     </table>
		     </div>
		     </div>		    
		     </s:if>
		    <s:if test="selectnum==2" >
	          <div id="itemContent2">
	        <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>个人信息
	          
		     </div>
		     </s:if>
		     <s:if test="selectnum==3">
		      <div id="itemContent3">
		    <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>账号绑定
		      
		     </div>
		     </s:if>
		     <s:if test="selectnum==4">
		      <div id="itemContent4">
		      <a href="#" style="text-decoration: none;color:#D26900">个人中心</a>>>我的攻略
		      
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