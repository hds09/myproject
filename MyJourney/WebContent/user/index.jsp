<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>云游</title>
	<link rel="stylesheet" href="../css/master.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../css/index_a.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../css/shade.css" type="text/css" media="screen" />
	<script src="../js/jquery.js" type="text/javascript"></script>
</head>
<body>

<script type="text/javascript">
//弹出隐藏层
function ShowDiv(show_div,bg_div){
document.getElementById(show_div).style.display='block';
document.getElementById(bg_div).style.display='block' ;
var bgdiv = document.getElementById(bg_div);
bgdiv.style.width = document.body.scrollWidth;
// bgdiv.style.height = $(document).height();
$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div)
{
document.getElementById(show_div).style.display='none';
document.getElementById(bg_div).style.display='none';
};
</script>
	<header>
		<h1>Where You Will Go</h1>
	</header>
	<nav>
		<ul>
			<li class="selected"><a href="#">首页</a></li>
			<li><a href="#">酒店</a></li>
			<li><a href="#">饭店</a></li>
			<li><a href="makeRoute">旅程</a></li>
			<li><a href="#">旅图</a></li>
			<li><a href="personCenter">个人中心</a></li>
			<li class="subscribe"><a href="#"></a></li>
		</ul>
	</nav>
<section id="intro">
		<header>
			<h2>行走的力量，你是否准备好了？</h2>
		</header>
	<p> 一路上走过的路遇见的人，长期在路上的人们，总是有着迷茫，下一站可以去哪里，这样行走是为追求什么？一切的一切总会要归于实处</p>
		<img src="../images/header.jpg" alt="Flower" />  </section>

	<div id="content">
			<section>
					<header id="rect">
						<h2>旅游热点推荐,<font color="red">hot</font></h2>
					</header>	
					<div id="kong"></div>
					<header id="rect">
						<h2>酒店推荐,<font color="red">hot</font></h2>
					</header>	
					<div id="kong"></div>
					<header id="rect">
						<h2>饭店推荐,<font color="red">hot</font></h2>
					</header>	
			</section>
		<aside>
		
			<section id="login">
			<s:if test="islogined==false" >
				<form name="form1" action="login" method="post">
				<h3><font color="white">嘻嘻，顺便登陆一下呗！</font></h3>
				<p>
					<label for="name"><font color="white">姓名:</font></label>
					<input name="account" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="password"><font color="white">密码:</font></label>
					<input name="password" id="password" type="password" style="width:150px" />
				</p>
				<p> <input  id="button"  value="登陆" type="submit"  /><a id="index_a" onclick="ShowDiv('MyDiv','fade')">注册</a></p>
			</form>
			</s:if>
			<s:else>
			  <h3><font color="white">嘻嘻，O(∩_∩)O欢迎你,</font><font color="red">${account}</font></h3>
				<p>
					<label for="name"><font color="white"></font></label>
				
				</p>
				
			</s:else>
			</section>
			
			
			<section id="fade" class="black_overlay">
            </section>
            <section id="MyDiv" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('MyDiv','fade')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="register" method="post">
				<h3><font color="#EE7700 ">欢迎加入我们的大家庭！</font></h3>
				<p>
					<label for="account"><font color="black">账号:</font></label>
					<input name="user.account" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="password"><font color="black">密码:</font></label>
					<input name="user.pwd" id="password" type="password" style="width:150px" />
				</p>
				<p>
					<label for="password"><font color="black">重复密码:</font></label>
					<input name="password" id="password" type="password" style="width:150px" />
				</p>
				    <table>
				    <tr>
				    <td style="width:125px;">
					<label for="sex"><font color="black">性别:</font></label>
					</td>
					<td>
					<input name="user.sex" id="sex" type="radio" value="1" style="width:30px;" checked="checked">男
					<input name="user.sex" id="sex" type="radio" value="0" style="width:30px;margin-left:0px" >女
				   </td>
				   </tr>
				    </table>
				<p>
					<label for="name"><font color="black">姓名:</font></label>
					<input name="user.name" id="name" type="text" style="width:150px" />
				</p>
				<p>
					<label for="age"><font color="black">age:</font></label>
					<input name="user.age" id="age" type="number" style="width:150px" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<input name="user.phone" id="phone" type="tel" style="width:150px" />
				</p>
				<p>
					<label for="email"><font color="black">email:</font></label>
					<input name="user.email" id="email" type="email" style="width:150px" />
				</p>
				<p> <input  id="button"  value="注册" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
			
			<section id="pioneer"><!-- 达人 -->
			<h2>达人<font color="red">秀</font></h2>
			</section>
		</aside>
	</div>
	<div id="kong"></div> 
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