<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="../css/myroutes.css" type="text/css"/>
		<link rel="stylesheet" href="../css/master.css" type="text/css"/>
		<link rel="stylesheet" href="../css/jquery-ui-1.10.2.custom.css" type="text/css"/>
		<script src="../js/myroutes.js" type="text/javascript"></script>
		<script src="../js/jquery.js" type="text/javascript"></script>
		<script src="../js/jquery-ui-1.10.2.custom.js"></script>
		<script type="text/javascript">
			$(function() {
				$( "#endDateinput" ).datepicker();
				$( "#startDateinput" ).datepicker();
				$( "#s_startDate" ).datepicker();
				$( "#s_endDate" ).datepicker();
				$(".star").hover(
					function(){
						$(this).css('background-image',"url('../images/sdd09/1.jpg')");
						$(this).prevAll().css('background-image',"url('../images/sdd09/1.jpg')");
						$(this).nextAll().css('background-image',"url('../images/sdd09/2.jpg')");
					}
				);
			});

		</script>
	</head>
	<body>
		<header>
			<h1>Where You Will Go</h1>
		</header>
		<nav>
			<ul>
				<li ><a href="index">首页</a></li>
				<li><a href="#">酒店</a></li>
				<li><a href="#">饭店</a></li>
				<li><a href="makeRoute">旅程</a></li>
				<li class="selected"><a href="makeRoute">旅程管理</a></li>
				<li><a href="#">个人中心</a></li>
				<li class="subscribe"><a href="#"></a></li>
			</ul>
		</nav>
		<div id="containAll">
			<div id="text_div" align="right"><span class="showQuickPublish" onclick="showQP()">快速发布[+]</span></div>
			<div id="quick_publish_div" style="display:none">
				<div class="seperator"></div>
				<div id="quick_publish">
					<form>
						<div id="destination">
							<label class="clabel">目的地</label>
							<input id="destinationinput" class="ainput"/>
						</div>
						<div id="startDate">
							<label class="clabel">开始时间</label>
							<input id="startDateinput" class="ainput"/>
						</div>
						<div id="endDate">
							<label class="clabel">结束时间</label>
							<input id="endDateinput" class="ainput"/>
						</div>
						<div id="tripName">
							<label class="clabel">为旅途起一个名字</label>
							<input id="tripNameinput" class="ainput"/>
						</div>
						<div id="type">
							<label class="clabel">类型</label>
							<input type="radio" name="triptype" value="private" checked>个人旅行，不公开
							<input type="radio" name="triptype" value="public"> 开放为结伴旅行
						</div>
						<div id="sbmt" align="right">
							<input type="submit" class="button" value="发布" />
							<a href="">取消</a>
						</div>
					</form>
				</div>
			</div>
			<div id="text_div2"><span>我的行程</span></div>
			<div class="seperator"></div>
			<!-- menu-->
			<div id="cter">
				<div id="left_navi" align="center">
					<ul>
						<li class="trip_type_selected" onclick="changeDiv(1)">我的个人旅程</li>
						<li class="trip_type_diselected" onclick="changeDiv(2)">结伴行程</li>
					</ul>
				</div>
				<div id="contents">
					<div id="j_tab">
						<ul id="tab" class="tabmenu">
						  <li class="active tab_item" onclick="makeActive(0)"><a>所有</a></li>
						  <li class="tab_item" onclick="makeActive(1)"><a>已结束</a></li>
						  <li class="tab_item" onclick="makeActive(2)"><a>近期</a></li>
						  <li class="active tab_item" onclick="makeActive(3)" style="display:none"><a>所有</a></li>
						  <li class="tab_item" onclick="makeActive(4)" style="display:none"><a>关于我的</a></li>
						  <li class="tab_item" onclick="makeActive(5)" style="display:none"><a>搜索结伴</a></li>
						</ul>
					</div>
					<div id="search_div">
						<span onclick="sndSearchField()" id="search_text">搜索<img id="s_arrow" src="../images/sdd09/arr_d.jpg" /></span>		
					</div>
					<div id="search_field" style="display:none">
						<form>
							<div id="s_name">
								<span class="s_text">旅行名关键字</span>
								<input class="s_input" />
							</div>
							<div id="s_time">
								<span class="s_text">时间范围</span>
								<input id="s_startDate" class="s_input" /><span class="s_text"> 至  </span><input id="s_endDate" class="s_input" />
							</div>
							<div id="s_cities">
								<span class="s_text">沿途城市(至多添加5个)</span>
								<span class="s_text2">添加</span>
							</div>
							<div id="s_status">
								<span class="s_text">状态</span>
								<select name="status">
								<option value="finished"><span class="s_text">已结束</span></option>
								<option value="ongoing"><span class="s_text">进行中</span></option>
								<option value="pending"><span class="s_text">未开始</span></option>
								</select>
							</div>
							<div id="s_rate">
								<span class="s_text" >评分</span>
								<select name="rate">
								<option value="finished" class="s_text"><span class="s_text">从低到高</span></option>
								<option value="ongoing" class="s_text"><span class="s_text">从高到低</span></option>
								</select>
							</div>
							<div class="sep"></div>
							<div id="s_people">
								<span class="s_text">参加人数</span>
								<select name="rate">
								<option value="finished"><span class="s_text">从低到高</span></option>
								<option value="ongoing"><span class="s_text">从高到低</span></option>
								</select>
							</div>
							<div id="s_form_submit" align="right">
								<input type="submit" value="搜索" class="s_sbmt"/>
							</div>
							<div class="sep"></div>
						</form>
					</div>
					<div id="j_result" class="changeableTab">
						<!--this section should be updated asynchronously according to user clicking on different tabs
							expected to be implemented by AJAX -->
						<!--hard-coding data-->
						<div class="resultRow">
							<div class="row_sep2"></div>
							<div class="rrow_content">
								<div class="journey_title">
									<span class="title"><a>戈壁行</a></span>
									<br/>
									<span class="date">从:2013-04-12</span>
									<br/>
									<span class="date">至:2013-04-15</span>
								</div>
							</div>
							<div class="status">
								<span class="finished">已结束</span>
								<span class="for_details"><a href="">详情</a></span>
							</div>
							<div class="rrow_right" align="center">
								<span class="record_text">行程记录</span><br/>
								<span class="record_text">查看相似行程</span>
							</div>
							<div class="my_rate" align="center">
								<div><span class="p_trip_rate" onclick="showhidePField(1)">+展开评论</span></div>
							</div>
							<div class="trip_action">
								
								<span class="trip_action_text"><a href="">分享</a></span>
								<span class="trip_action_text"><a href="">删除</a></span>
							</div>
							<div id="p_trip_commentField1" class="rate_field" style="display:none">
								<form>
									<div class="rateinput">
										<ul class="stars">
											<li class="star" onclick="setRate(1)"></li>
											<li class="star" onclick="setRate(2)"></li>
											<li class="star" onclick="setRate(3)"></li>
											<li class="star" onclick="setRate(4)"></li>
											<li class="star" onclick="setRate(5)"></li>
											<li class="star" onclick="setRate(6)"></li>
											<li class="star" onclick="setRate(7)"></li>
											<li class="star" onclick="setRate(8)"></li>
											<li class="star" onclick="setRate(9)"></li>
											<li class="star" onclick="setRate(10)"></li>
										<ul>
									</div>
									<div class="commentinput" align="left">
										<textarea type="text" class="comments_field"></textarea>
									</div>
									<div class="action" align="right">
										<span class="action_text" onclick="hidePField(1)">取消</span>
										<span class="action_text" onclick="hidePField(1)">提交</span>
									</div>
								</form>
							</div>
							<div class="row_sep"></div>
						</div>
						
						
					</div>
					<div id="team_results" class="changeableTab" style="display:none">
						<div id="team_header">
							           	                                          
						</div>
						<div id="team_row">
							<div class="resultRow">
								<div class="row_sep2"></div>
								<div class="rrow_content">
									<div class="journey_title">
										<span class="title"><a onclick="openCenterDiv()">黄山三日游</a></span>
										<br/>
										<span class="date">从:2013-04-12</span>
										<br/>
										<span class="date">至:2013-04-15</span>
									</div>
								</div>
								<div class="status">
									<span class="finished">已结束</span>
								</div>
								<div class="rrow_right">
									<div class="number" align="center">16</div>
									<div class="participants" align="center">成员</div>
								</div>
								<div class="rrow_rate">
									<div class="rate" align="center">4.5</div>
									<div class="participants" align="center">成员评分</div>
								</div>
								<div class="my_rate">
									<div><span onclick="showField(1)">我的评价</span></div>
								</div>
								<div id="commentField1" class="rate_field" style="display:none">
									<form>
										<div class="rateinput">
											<ul class="stars">
												<li class="star" onclick="setRate(1)"></li>
												<li class="star" onclick="setRate(2)"></li>
												<li class="star" onclick="setRate(3)"></li>
												<li class="star" onclick="setRate(4)"></li>
												<li class="star" onclick="setRate(5)"></li>
												<li class="star" onclick="setRate(6)"></li>
												<li class="star" onclick="setRate(7)"></li>
												<li class="star" onclick="setRate(8)"></li>
												<li class="star" onclick="setRate(9)"></li>
												<li class="star" onclick="setRate(10)"></li>
											<ul>
										</div>
										<div class="commentinput" align="left">
											<textarea type="text" class="comments_field"></textarea>
										</div>
										<div class="action" align="right">
											<span class="action_text" onclick="hideField(1)">取消</span>
											<span class="action_text" onclick="hideField(1)">提交</span>
										</div>
									</form>
								</div>
								<div class="row_sep"></div>
							</div>
							<div class="resultRow">
								<div class="row_sep2"></div>
								<div class="rrow_content">
									<div class="journey_title">
										<span class="title"><a onclick="openCenterDiv()">西藏之旅</a></span>
										<br/>
										<span class="date">开始时间:2013-04-15</span>
										<br/>
									</div>
								</div>
								<div class="status">
									<span class="ongoing">进行中</span>
								</div>
								<div class="rrow_right">
									<div class="number" align="center">28</div>
									<div class="participants" align="center">成员</div>
								</div>
								<div class="rrow_rate">
									<div class="rate" align="center">4.8</div>
									<div class="participants" align="center">成员评分</div>
								</div>
								<div class="my_rate">
									<div><span onclick="showField(2)">我的评价</span></div>
								</div>
								<div id="commentField2" class="rate_field" style="display:none">
									<form>
										<div class="rateinput">
											<ul class="stars">
												<li class="star" onclick="setRate(1)"></li>
												<li class="star" onclick="setRate(2)"></li>
												<li class="star" onclick="setRate(3)"></li>
												<li class="star" onclick="setRate(4)"></li>
												<li class="star" onclick="setRate(5)"></li>
												<li class="star" onclick="setRate(6)"></li>
												<li class="star" onclick="setRate(7)"></li>
												<li class="star" onclick="setRate(8)"></li>
												<li class="star" onclick="setRate(9)"></li>
												<li class="star" onclick="setRate(10)"></li>
											<ul>
										</div>
										<div class="commentinput" align="left">
											<textarea type="text" class="comments_field"></textarea>
										</div>
										<div class="action" align="right">
											<span class="action_text" onclick="hideField(2)">取消</span>
											<span class="action_text" onclick="hideField(2)">提交</span>
										</div>
									</form>
								</div>
								<div class="row_sep"></div>
							</div>
							<div class="resultRow">
								<div class="row_sep2"></div>
								<div class="rrow_content">
									<div class="journey_title">
										<span class="title"><a onclick="openCenterDiv()">凤凰古城</a></span>
										<br/>
										<span class="date">开始时间:2013-05-15</span>
										<br/>
									</div>
								</div>
								<div class="status">
									<span class="notStarted">未开始</span>
								</div>
								<div class="rrow_right">
									<div class="number" align="center">18</div>
									<div class="participants" align="center">成员</div>
								</div>
								<div class="rrow_rate">
									<div class="rate" align="center">NA</div>
									<div class="participants" align="center">成员评分</div>
								</div>
								<div class="my_rate">
									<div><span onclick="showField(3)">我的评价</span></div>
								</div>
								
								<div id="commentField3" class="rate_field" style="display:none">
									<form>
										<div class="rateinput">
											<ul class="stars">
												<li class="star" onclick="setRate(1)"></li>
												<li class="star" onclick="setRate(2)"></li>
												<li class="star" onclick="setRate(3)"></li>
												<li class="star" onclick="setRate(4)"></li>
												<li class="star" onclick="setRate(5)"></li>
												<li class="star" onclick="setRate(6)"></li>
												<li class="star" onclick="setRate(7)"></li>
												<li class="star" onclick="setRate(8)"></li>
												<li class="star" onclick="setRate(9)"></li>
												<li class="star" onclick="setRate(10)"></li>
											<ul>
										</div>
										<div class="commentinput" align="left">
											<textarea type="text" class="comments_field"></textarea>
										</div>
										<div class="action" align="right">
											<span class="action_text" onclick="hideField(3)">取消</span>
											<span class="action_text" onclick="hideField(3)">提交</span>
										</div>
									</form>
								</div>
								<div class="row_sep"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="text_div3">
				<span>为您推荐</span>
			</div>
			<div class="seperator"></div>
			<div id="rec_trip">
				<div class="rec_text_div"><span class="rec_text">猜您感兴趣的旅程</span></div>
				<div id="rec_trip_rows">
					<div class="rec_trip_row">
						<span class="trip_title"><a href="">西南5日行</a></span>
						<span class="trip_time">2013/5/1 至 2013/5/3</span>
					</div>
				</div>
			</div>
			<div id="rec_people">
				<span>"志同道合"的驴友</span>
			</div>
			<div id="globalFooter">
			</div>
			<div id="center_div" style="display:none">
				<div id="center_div_header" align="right">
					<span onclick="closeCenterDiv()">关闭</span>
				</div>
				<div>
					<div id="img_slider">
						<div class="prev">
							<img src="../images/sdd09/prev.jpg" onclick="showPreviousPicture()"/>
						</div>
						<ul id="img_list">
							<li class="present img"><img src="../images/sdd09/tp1.jpg" class="img1"/></li>
							<li class="hidden img"><img src="../images/sdd09/tp2.jpg" class="img1"/></li>
							<li class="hidden img"><img src="../images/sdd09/tp3.jpg" class="img1"/></li>
						</ul>
						<div class="next">
							<img src="../images/sdd09/next.jpg" onclick="showNextPicture()"/>
						</div>
						<div class="v_sep"></div>
					</div>
					<div id="trip_info">
						<span class="trip_info_title">黄山三日游</span>
						<div class="trip_info_details">
							<div class="text_info">
								<span class="text_info_text">出发地</span>
							</div>
							<div class="rate_info">
								
							</div>
						</div>
					</div>
					<div id="team_member_line"><span onclick="showMembers()">展开查看成员列表</span></div>
					<div id="team_member" style="display:none">
						<div class="member_row">
							user1
						</div>
						<div class="member_row">
							user2
						</div>
						<div class="member_row">
							user3
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<footer>
	</footer>
</html>