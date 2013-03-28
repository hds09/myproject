<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>云游</title>
	<link rel="stylesheet" href="css/master.css" type="text/css" media="screen" />
</head>
<body>

	<header>
		<h1>Where You Will Go</h1>
	</header>
	<nav>
		<ul>
			<li class="selected"><a href="#">首页</a></li>
			<li><a href="#">酒店</a></li>
			<li><a href="#">饭店</a></li>
			<li><a href="#">旅程</a></li>
			<li><a href="#">旅图</a></li>
			<li><a href="#">个人中心</a></li>
			<li class="subscribe"><a href="#"></a></li>
		</ul>
	</nav>
<section id="intro">
		<header>
			<h2>行走的力量，你是否准备好了？</h2>
		</header>
	<p style="color:blac"> 一路上走过的路遇见的人，长期在路上的人们，总是有着迷茫，下一站可以去哪里，这样行走是为追求什么？一切的一切总会要归于实处。.</p>
		<img src="images/header.jpg" alt="Flower" />  </section>

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
				<form name="form1" action="/MyJourney/login" method="post">
				<h3><font color="white">嘻嘻，顺便登陆一下呗！</font></h3>
				<p>
					<label for="name"><font color="white">姓名:</font></label>
					<input name="account" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="password"><font color="white">密码:</font></label>
					<input name="password" id="password" type="password" style="width:150px" />
				</p>
				<p> <input  id="button"  value="登陆" type="submit"  /></p>
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