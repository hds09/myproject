<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>云游</title>
<link rel="stylesheet" href="../css/editRoute.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../css/editShade.css" type="text/css" media="screen" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
</head>
<body>
<s:iterator value="morningPlaces" var="morningPlace">
<input type="hidden" value="<s:property value='#morningPlace.city.lat'/>,<s:property value='#morningPlace.city.lng'/>" name="morninglist" />
<input type="hidden" value="<s:property value='#morningPlace.city.name'/>" name="morningNamelist" />
</s:iterator>
<s:iterator value="afternoonPlaces" var="afternoonPlace">
<input type="hidden" value="<s:property value='#afternoonPlace.city.lat'/>,<s:property value='#afternoonPlace.city.lng'/>" name="afternoonlist" />
<input type="hidden" value="<s:property value='#afternoonPlace.city.name'/>" name="afternoonNamelist" />
</s:iterator>
<s:iterator value="dateList" var="date">
<input type="hidden" value="<s:property value='#date'/>" name="datelist" />
</s:iterator>
<s:iterator value="cities" var="city">
<input type="hidden" value="<s:property value='#city.lat'/>,<s:property value='#city.lng'/>" name="cityPointList" />
<input type="hidden" value="<s:property value='#city.name'/>" name="cityNameList" />
<input type="hidden" value="<s:property value='#city.picture'/>" name="cityPictureList" />
</s:iterator>

	<header>
		<h1>Where You Will Go</h1>
	</header>
	<nav>
		<ul>
			<li ><a href="index">首页</a></li>
			<li><a href="#">酒店</a></li>
			<li><a href="#">饭店</a></li>
			<li class="selected"><a href="makeRoute">旅程</a></li>
			<li><a href="#">旅图</a></li>
			<li><a href="personCenterSelect1">个人中心</a></li>
			<li class="subscribe"><a href="#"></a></li>
		</ul>
	</nav>
	
	<div id="content">
			<section id="mapouter">
					<header id="mapcontainer">
					<section id="head">
						<h2 style="color:white">拟定路线</h2>
					</section>
					<section id="map">
					</section>
					</header>	
					
			</section>
	
		<aside id="aside">
	     <header>
		<section id="plancontainer">
			<h1>&nbsp&nbsp您的行程计划：</h1>
			<section  id="plan">
               <div id="planhead">
               <h3><s:property value="startDate" /></h3>
		        <h3 style="margin-left:119px;font-size: 20px;font-family: monospace;">
		        <s:if test="selectnum>1">
		        <a id='a_css_pre' href="/MyJourney/user/editRoute?selectnum=<s:property value='preDay'/>">
		                前一天
		       </a>
		       </s:if>第<font color="red"><s:property value="selectnum"/></font>天
		       <s:if test="selectnum<length"><a id="a_css" href="/MyJourney/user/editRoute?selectnum=<s:property value='otherDay'/>">后一天</a>
		       </s:if>
		       <s:else>
		       <a id="a_css" onclick="f1()">后一天</a>
		       </s:else>
		       </h3>
                </div>
              <div id="plancontait">
				<p>
				    <div id="morningplace">
					<h3><label style="margin-left:10px;"><font color="black">上午:</font></label>
					去往<font color="red"><s:property value="morningStartPlace.city.name" /></font>
					</h3>
					</div>
					<div id="morningplaceOperation" style="margin-left:60px;width:200px">
			             饭店:<font color="#EE7700">
			             <s:if test="morningStartPlace.restaurant==null">
			                        未填
			             <a style="float:right"  onclick="ShowDiv('morningRescontent','morningRes')">编辑</a>
			             <a style="float:right;color:red" onclick="ShowDiv('TmorningRescontent','TmorningRes')">推荐</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="morningStartPlace.restaurant.name"/>
			             <a style="float:right"  onclick="ShowDiv('checkmorningRescontent','checkmorningRes')">查看</a></br>
			             </s:else>
			             </font>
			             
			             旅馆:<font color="#EE7700">
			             <s:if test="morningStartPlace.hotel==null">
			                        未填
			             <a style="float:right" onclick="ShowDiv('morningHotelcontent','morningHotel')">编辑</a>
			              <a style="float:right;color:red" onclick="ShowDiv('TmorningHotelcontent','TmorningHotel')">推荐</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="morningStartPlace.hotel.name"/>
			             <a style="float:right" onclick="ShowDiv('checkmorningHotelcontent','checkmorningHotel')">查看</a></br>
			             </s:else>
			             </font>
			           
			            景点:<font color="#EE7700">
			             <s:if test="morningStartPlace.attraction==null">
			                        未填
			             <a style="float:right" onclick="ShowDiv('morningAttcontent','morningAtt')">编辑</a>
			             <a style="float:right;color:red" onclick="ShowDiv('TmorningAttcontent','TmorningAtt')">推荐</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="morningStartPlace.attraction.name"/>
			              <a style="float:right" onclick="ShowDiv('checkmorningAttcontent','checkmorningAtt')">查看</a></br>
			             </s:else>
			             </font>
			            
			           交通:<font color="#EE7700">
			             <s:if test="morningStartPlace.traffic==null">
			                        未填
			             <a style="float:right" onclick="ShowDiv('morningTrafficcontent','morningTraffic')">编辑</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="morningStartPlace.traffic"/>
			             <a style="float:right" onclick="ShowDiv('checkmorningTrafficcontent','checkmorningTraffic')">查看</a></br>
			             </s:else>
			             </font>
			             
			             </div>
				</p>
				<p>
				   <div id="afternoonplace">
					<h3><label style="margin-left:10px;"><font color="black">下午:</font></label>
					去往<font color="red"><s:property value="afternoonStartPlace.city.name" /></font>
					</h3>
					</div>
					<div id="afternoonplaceOperation" style="margin-left:60px;width:200px">
				     饭店:<font color="#EE7700">
			             <s:if test="afternoonStartPlace.restaurant==null">
			                        未填
			              <a style="float:right" onclick="ShowDiv('afternoonRescontent','afternoonRes')">编辑</a>
			               <a style="float:right;color:red" onclick="ShowDiv('TafternoonRescontent','TafternoonRes')">推荐</a></br>           
			             </s:if>
			             <s:else>
			             <s:property value="afternoonStartPlace.restaurant.name"/>
			              <a style="float:right" onclick="ShowDiv('checkafternoonRescontent','checkafternoonRes')">查看</a></br>
			             </s:else>
			             </font>
			            
			             旅馆:<font color="#EE7700">
			             <s:if test="afternoonStartPlace.hotel==null">
			                        未填
			             <a style="float:right" onclick="ShowDiv('afternoonHotelcontent','afternoonHotel')">编辑</a>
			              <a style="float:right;color:red" onclick="ShowDiv('TafternoonHotelcontent','TafternoonHotel')">推荐</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="afternoonStartPlace.hotel.name"/>
			              <a style="float:right" onclick="ShowDiv('checkafternoonHotelcontent','checkafternoonHotel')">查看</a></br>
			             </s:else>
			             </font>
			            
			            景点:<font color="#EE7700">
			             <s:if test="afternoonStartPlace.attraction==null">
			                        未填
			             <a style="float:right" onclick="ShowDiv('afternoonAttcontent','afternoonAtt')">编辑</a>
			              <a style="float:right;color:red" onclick="ShowDiv('TafternoonAttcontent','TafternoonAtt')">推荐</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="afternoonStartPlace.attraction.name"/>
			             <a style="float:right" onclick="ShowDiv('checkafternoonAttcontent','checkafternoonAtt')">查看</a></br>
			             </s:else>
			             </font>
			             
			           交通:<font color="#EE7700">
			             <s:if test="afternoonStartPlace.traffic==null">
			                        未填
			             <a style="float:right" onclick="ShowDiv('afternoonTrafficcontent','afternoonTraffic')">编辑</a></br>
			             </s:if>
			             <s:else>
			             <s:property value="afternoonStartPlace.traffic"/>
			              <a style="float:right" onclick="ShowDiv('checkafternoonTrafficcontent','checkafternoonTraffic')">查看</a></br>
			             </s:else>
			             </font>
			            
			             </div>
				</p>
				</div>
                 
			</section>
			</section>
			</header>
		</aside>
	
	</div>
	<!-- 推荐弹出内容 -->
	        <section id="TmorningRes" class="black_overlay">
            </section>
            <section id="TmorningRescontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('TmorningRescontent','TmorningRes')">关闭</a>
            </div>
               <s:if test="tmpMorningRestaurant==null">
                    o(╯□╰)o，不好意思，尚无推荐。
               </s:if>
              <s:else> 
				<h3><font color="#EE7700 ">推荐饭店</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="tmpMorningRestaurant.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="tmpMorningRestaurant.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="tmpMorningRestaurant.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="tmpMorningRestaurant.address" />
				<p> <a href="/MyJourney/user/recommendMorningRestaurant" style="color:red;font-size: 20px;float:right;text-decoration: none;" >使用推荐</a></p>
            </s:else> 
            </section>
            
             <section id="TmorningHotel" class="black_overlay">
            </section>
            <section id="TmorningHotelcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('TmorningHotelcontent','TmorningHotel')">关闭</a>
            </div>
               <s:if test="tmpMorningHotel==null">
                    o(╯□╰)o，不好意思，尚无推荐。
               </s:if>
               <s:else>
				<h3><font color="#EE7700 ">推荐旅馆</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="tmpMorningHotel.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="tmpMorningHotel.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="tmpMorningHotel.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="tmpMorningHotel.address" />
				<p> <a href="/MyJourney/user/recommendMorningHotel" style="color:red;font-size: 25px;float:right;text-decoration: none;" >使用推荐</a></p>
              </s:else>
            </section>
            
             <section id="TmorningAtt" class="black_overlay">
            </section>
            <section id="TmorningAttcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('TmorningAttcontent','TmorningAtt')">关闭</a>
            </div>
               <s:if test="tmpMorningAttraction==null">
                    o(╯□╰)o，不好意思，尚无推荐。
               </s:if>
               <s:else>
				<h3><font color="#EE7700 ">推荐景点</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="tmpMorningAttraction.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="tmpMorningAttraction.price" />
				</p>
				
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="tmpMorningAttraction.address" />
				<p> <a href="/MyJourney/user/recommendMorningAttraction" style="color:red;font-size: 25px;float:right;text-decoration: none;" >使用推荐</a></p>
              </s:else>
            </section>
            
             <section id="TafternoonRes" class="black_overlay">
            </section>
            <section id="TafternoonRescontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('TafternoonRescontent','TafternoonRes')">关闭</a>
            </div>
               <s:if test="tmpAfternoonRestaurant==null">
                    o(╯□╰)o，不好意思，尚无推荐。
               </s:if>
               <s:else>
				<h3><font color="#EE7700 ">推荐饭店</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="tmpAfternoonRestaurant.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="tmpAfternoonRestaurant.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="tmpAfternoonRestaurant.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="tmpAfternoonRestaurant.address" />
				<p> <a href="/MyJourney/user/recommendAfternoonRestaurant" style="color:red;font-size: 25px;float:right;text-decoration: none;" >使用推荐</a></p>
              </s:else>
            </section>
            
             <section id="TafternoonHotel" class="black_overlay">
            </section>
            <section id="TafternoonHotelcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('TafternoonHotelcontent','TafternoonHotel')">关闭</a>
            </div>
               <s:if test="tmpAfternoonHotel==null">
                    o(╯□╰)o，不好意思，尚无推荐。
               </s:if>
               <s:else>
				<h3><font color="#EE7700 ">推荐旅馆</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="tmpAfternoonHotel.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="tmpAfternoonHotel.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="tmpAfternoonHotel.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="tmpAfternoonHotel.address" />
				<p> <a href="/MyJourney/user/recommendAfternoonHotel" style="color:red;font-size: 25px;float:right;text-decoration: none;" >使用推荐</a></p>
              </s:else>
            </section>
            
             <section id="TafternoonAtt" class="black_overlay">
            </section>
            <section id="TafternoonAttcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('TafternoonAttcontent','TafternoonAtt')">关闭</a>
            </div>
               <s:if test="tmpAfternoonAttraction==null">
                    o(╯□╰)o，不好意思，尚无推荐。
               </s:if>
               <s:else>
				<h3><font color="#EE7700 ">推荐景点</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="tmpAfternoonAttraction.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="tmpAfternoonAttraction.price" />
				</p>
				
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="tmpAfternoonAttraction.address" />
				<p> <a href="/MyJourney/user/recommendAfternoonAttraction" style="color:red;font-size: 25px;float:right;text-decoration: none;" >使用推荐</a></p>
              </s:else>
            </section>
             
	<!-- 编辑弹出内容 -->
           <section id="morningRes" class="black_overlay">
            </section>
            <section id="morningRescontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('morningRescontent','morningRes')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningRestaurant" method="post">
				<h3><font color="#EE7700 ">饭店</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<input name="morningRestaurant.name" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<input name="morningRestaurant.price" id="price" type="number" style="width:150px" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<input name="morningRestaurant.phone" id="phone" type="number" style="width:150px" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<input name="morningRestaurant.address" id="address" type="text" style="width:150px" />
				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
            
              <section id="morningHotel" class="black_overlay">
            </section>
            <section id="morningHotelcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('morningHotelcontent','morningHotel')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningHotel" method="post">
				<h3><font color="#EE7700 ">旅馆</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<input name="morningHotel.name" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<input name="morningHotel.price" id="price" type="number" style="width:150px" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<input name="morningHotel.phone" id="phone" type="number" style="width:150px" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<input name="morningHotel.address" id="address" type="text" style="width:150px" />
				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
              <section id="morningAtt" class="black_overlay">
            </section>
            <section id="morningAttcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('morningAttcontent','morningAtt')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningAttraction" method="post">
				<h3><font color="#EE7700 ">景点</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<input name="morningAttraction.name" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<input name="morningAttraction.price" id="price" type="number" style="width:150px" />
				</p>
		
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<input name="morningAttraction.address" id="address" type="text" style="width:150px" />
				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
              <section id="morningTraffic" class="black_overlay">
            </section>
            <section id="morningTrafficcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('morningTrafficcontent','morningTraffic')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningTraffic" method="post">
				<h3><font color="#EE7700 ">交通</font></h3>
				<p>
					<label for="traffic"><font color="black">方式:</font></label>
					<input name="morningTraffic" id="name" type="text" style="width:150px"/>
				</p>

				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
       <!--   下午 -->
             <section id="afternoonRes" class="black_overlay">
            </section>
            <section id="afternoonRescontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('afternoonRescontent','afternoonRes')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonRestaurant" method="post">
				<h3><font color="#EE7700 ">饭店</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<input name="afternoonRestaurant.name" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<input name="afternoonRestaurant.price" id="price" type="number" style="width:150px" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<input name="afternoonRestaurant.phone" id="phone" type="number" style="width:150px" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<input name="afternoonRestaurant.address" id="address" type="text" style="width:150px" />
				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
            
              <section id="afternoonHotel" class="black_overlay">
            </section>
            <section id="afternoonHotelcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('afternoonHotelcontent','afternoonHotel')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonHotel" method="post">
				<h3><font color="#EE7700 ">旅馆</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<input name="afternoonHotel.name" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<input name="afternoonHotel.price" id="price" type="number" style="width:150px" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<input name="afternoonHotel.phone" id="phone" type="number" style="width:150px" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<input name="afternoonHotel.address" id="address" type="text" style="width:150px" />
				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
              <section id="afternoonAtt" class="black_overlay">
            </section>
            <section id="afternoonAttcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('afternoonAttcontent','afternoonAtt')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonAttraction" method="post">
				<h3><font color="#EE7700 ">景点</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<input name="afternoonAttraction.name" id="name" type="text" style="width:150px"/>
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<input name="afternoonAttraction.price" id="price" type="number" style="width:150px" />
				</p>
		
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<input name="afternoonAttraction.address" id="address" type="text" style="width:150px" />
				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
              <section id="afternoonTraffic" class="black_overlay">
            </section>
            <section id="afternoonTrafficcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('afternoonTrafficcontent','afternoonTraffic')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonTraffic" method="post">
				<h3><font color="#EE7700 ">交通</font></h3>
				<p>
					<label for="traffic"><font color="black">方式:</font></label>
					<input name="afternoonTraffic" id="name" type="text" style="width:150px"/>
				</p>

				<p> <input  id="button"  value="确定" type="submit"  style="margin-left:200px"/></p>
			</form>
            </section>
            
            
            
            
             <section id="checkmorningRes" class="black_overlay">
            </section>
            <section id="checkmorningRescontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkmorningRescontent','checkmorningRes')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningRestaurant" method="post">
				<h3><font color="#EE7700 ">饭店</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="morningStartPlace.restaurant.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
				   <s:property value="morningStartPlace.restaurant.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="morningStartPlace.restaurant.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="morningStartPlace.restaurant.address" />
			</form>
            </section>
            
              <section id="checkmorningHotel" class="black_overlay">
            </section>
            <section id="checkmorningHotelcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkmorningHotelcontent','checkmorningHotel')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningHotel" method="post">
				<h3><font color="#EE7700 ">旅馆</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="morningStartPlace.hotel.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="morningStartPlace.hotel.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="morningStartPlace.hotel.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="morningStartPlace.hotel.address" />
			</form>
            </section>
              <section id="checkmorningAtt" class="black_overlay">
            </section>
            <section id="checkmorningAttcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkmorningAttcontent','checkmorningAtt')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningAttraction" method="post">
				<h3><font color="#EE7700 ">景点</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="morningStartPlace.attraction.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="morningStartPlace.attraction.price" />
				</p>
		
				<p>
					<label for="address"><font color="black">地址:</font></label>
				    <s:property value="morningStartPlace.attraction.address" />
			</form>
            </section>
              <section id="checkmorningTraffic" class="black_overlay">
            </section>
            <section id="checkmorningTrafficcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkmorningTrafficcontent','checkmorningTraffic')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editMorningTraffic" method="post">
				<h3><font color="#EE7700 ">交通</font></h3>
				<p>
					<label for="traffic"><font color="black">方式:</font></label>
					 <s:property value="morningStartPlace.traffic" />
				</p>
			</form>
            </section>
       <!--   下午 -->
             <section id="checkafternoonRes" class="black_overlay">
            </section>
            <section id="checkafternoonRescontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkafternoonRescontent','checkafternoonRes')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonRestaurant" method="post">
				<h3><font color="#EE7700 ">饭店</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="afternoonStartPlace.restaurant.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="afternoonStartPlace.restaurant.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="afternoonStartPlace.restaurant.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="afternoonStartPlace.restaurant.address" />
			</form>
            </section>
            
              <section id="checkafternoonHotel" class="black_overlay">
            </section>
            <section id="checkafternoonHotelcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkafternoonHotelcontent','checkafternoonHotel')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonHotel" method="post">
				<h3><font color="#EE7700 ">旅馆</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="afternoonStartPlace.hotel.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="afternoonStartPlace.hotel.price" />
				</p>
				<p>
					<label for="phone"><font color="black">电话:</font></label>
					<s:property value="afternoonStartPlace.hotel.phone" />
				</p>
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="afternoonStartPlace.hotel.address" />
			</form>
            </section>
              <section id="checkafternoonAtt" class="black_overlay">
            </section>
            <section id="checkafternoonAttcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkafternoonAttcontent','checkafternoonAtt')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonAttraction" method="post">
				<h3><font color="#EE7700 ">景点</font></h3>
				<p>
					<label for="name"><font color="black">名称:</font></label>
					<s:property value="afternoonStartPlace.attraction.name" />
				</p>
				<p>
					<label for="price"><font color="black">价格:</font></label>
					<s:property value="afternoonStartPlace.attraction.price" />
				</p>
		
				<p>
					<label for="address"><font color="black">地址:</font></label>
					<s:property value="afternoonStartPlace.attraction.address" />
			</form>
            </section>
              <section id="checkafternoonTraffic" class="black_overlay">
            </section>
            <section id="checkafternoonTrafficcontent" class="white_content">
            <div style="text-align: right; cursor: default; height: 0px;">
            <a id="index_b" style="font-size: 16px; margin-top:0px;margin-right:0px;" onclick="CloseDiv('checkafternoonTrafficcontent','checkafternoonTraffic')">关闭</a>
            </div>
             <form name="form1" style="margin-bottom: 50px;" action="editAfternoonTraffic" method="post">
				<h3><font color="#EE7700 ">交通</font></h3>
				<p>
					<label for="traffic"><font color="black">方式:</font></label>
					<s:property value="afternoonStartPlace.traffic" />
				</p>
			</form>
            </section>
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
	<script type="text/javascript">
//自定义覆盖物
var currentIndex=1;
function SquareOverlay(center, length, color,imagename,placename) {
    this._center = center;
    this._length = length;
    this._color = color;
    this._imagename=imagename;
    this._placename=placename;
}
// 继承API的BMap.Overlay  
SquareOverlay.prototype = new BMap.Overlay();
SquareOverlay.prototype.initialize = function (map) {
    // 保存map对象实例  
    this._map = map;
    // 创建div元素，作为自定义覆盖物的容器  
    var div = document.createElement("div");
    div.style.position = "absolute";
    div.id="over";
    
 
    // 可以根据参数设置元素外观  
    div.style.width = this._length-30 + "px";
    div.style.height = this._length + "px";
    div.style.background = this._color;
    div.innerHTML="<div id='"+this._imagename+"'></div><h3 style='text-align:center'>"+this._placename+"</h3>";
    // 将div添加到覆盖物容器中  
   
    map.getPanes().markerPane.appendChild(div);
    // 保存div实例  
     var imagediv=document.getElementById(this._imagename);
    imagediv.style.height="60px";
    imagediv.style.width="80px";
    imagediv.style.marginLeft="5px";
    imagediv.style.marginTop="10px";
    imagediv.style.cursor="pointer";
    div.style.zIndex=currentIndex;
   imagediv.style.background="url('../images/"+this._imagename+".PNG') no-repeat";
    this._div = div;
    // 需要将div元素作为方法的返回值，当调用该覆盖物的show、  
    // hide方法，或者对覆盖物进行移除时，API都将操作此元素。  
    return div;
}
SquareOverlay.prototype.draw = function () {
    // 根据地理坐标转换为像素坐标，并设置给容器 
      var position = this._map.pointToOverlayPixel(this._center);
      this._div.style.left = position.x - this._length / 2 + "px";
      this._div.style.top = position.y - this._length -30 + "px";       
}

// 实现显示方法  
SquareOverlay.prototype.show = function () {
    if (this._div) {
        this._div.style.display = "";
    }
}
SquareOverlay.prototype.up=function(){
	
	currentIndex++;
	this._div.style.zIndex=currentIndex;
}
// 实现隐藏方法  
SquareOverlay.prototype.hide = function () {
    if (this._div) {
        this._div.style.display = "";
    }
}

SquareOverlay.prototype.addEventListener = function(event,fun){  
	this._div['on'+event] = fun;  
	
	} 
//自定义结束


var map = new BMap.Map("map");          // 创建地图实例
//var point = new BMap.Point(116.404, 39.915);  // 创建点坐标
var beijingPoint=new BMap.Point(116.404, 39.915);
var pointList=new Array();//new 一个list用来存放point信息

var morningList = document.getElementsByName("morninglist");
//var morningNameList=document.getElementsByName("morningNamelist");
var afternoonList = document.getElementsByName("afternoonlist");
//var afternoonNameList=document.getElementByName("afternoonNameList");
var dateList = document.getElementsByName("datelist");
var cityPointList=document.getElementsByName("cityPointList");
var cityNameList=document.getElementsByName("cityNameList");
var cityPictureList=document.getElementsByName("cityPictureList");
var totalldays=morningList.length;
var day=1;
var length=morningList.length;
var citylength=cityPointList.length;

//create(map,new BMap.Point(116.404, 39.915),"BeiJing","北京");
 for(var i=0;i<citylength;i++){
	var tmpString=cityPointList[i].value;
	var Stringlist=new Array();
	Stringlist=tmpString.split(",");
	var point=new BMap.Point(Stringlist[0],Stringlist[1]);
	//create(map,new BMap.Point(116.404,39.915),cityPictureList[i].value,cityNameList[i].value);
	create(map,point,cityPictureList[i].value,cityNameList[i].value);
} 
for(var i=0;i<length;i++){  
	var tmpString1=morningList[i].value;
	var morningStringlist=new Array();
	morningStringlist=tmpString1.split(",");
	var morningpoint=new BMap.Point(morningStringlist[0],morningStringlist[1]);
	pointList.push(morningpoint);
	var tmpString2=afternoonList[i].value;
	var afternoonStringlist=new Array();
	afternoonStringlist=tmpString2.split(",");
	var afternoonpoint=new BMap.Point(afternoonStringlist[0],afternoonStringlist[1]);
	pointList.push(afternoonpoint);   
}  //将后台传过来的journey信息转换为地图的point，并存入pointlist

var polyline = new BMap.Polyline(pointList,{strokeColor:"red", strokeWeight:6, strokeOpacity:1} );//创建折线
map.addOverlay(polyline);  
//控件

map.centerAndZoom(beijingPoint, 5);   
map.addControl(new BMap.NavigationControl());  //平移缩放
map.addControl(new BMap.ScaleControl());  //比例尺
//map.addControl(new BMap.OverviewMapControl());  //缩略图
map.enableScrollWheelZoom();   

//标注

//addMarker(point);
//创建北京

 //var marker = new BMap.Marker(point);        // 创建标注  
//map.addOverlay(marker);      
//var over=new SquareOverlay(map.getCenter(),120,"#ffffff","BeiJing","北京");
//over.show();
//map.addOverlay(over);
//创建
function f1(){
	alert("已经是最后一天");
}
function create(map,centerpoint,imagename,placename){
	var marker = new BMap.Marker(centerpoint);        // 创建标注  
	map.addOverlay(marker);      
	var over=new SquareOverlay(centerpoint,120,"#ffffff",imagename,placename);
	over.show();
	map.addOverlay(over);
	over.addEventListener('mouseover',function(){
		over.up();
		
	});
	
}
function addMarker(point){  
	// 创建图标对象  
	var myIcon = new BMap.Icon("../images/marker.jpg", new BMap.Size(10,10), {   
	   offset: new BMap.Size(10, 25),  
	   // 设置图片偏移。  
	   // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您  
	   // 需要指定大图的偏移位置，此做法与css sprites技术类似。  
	   imageOffset: new BMap.Size(10,10)   // 设置图片偏移  
	 });    
	 // 创建标注对象并添加到地图  
	 var marker = new BMap.Marker(point, {icon: myIcon});  
	 map.addOverlay(marker);  
	}  

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
</body>
</html>