<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>云游</title>
	<link rel="stylesheet" href="../css/makeRoute.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../css/index_a.css" type="text/css" media="screen" />
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
	<script src="../js/jquery.js" type="text/javascript"></script>
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
			<li class="selected"><a href="makeRoute">旅程</a></li>
			<li><a href="#">旅图</a></li>
			<li><a href="#">个人中心</a></li>
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
	
		<aside>
	     <header>
		<section id="plancontainer">
			<h1>&nbsp&nbsp您的行程计划：</h1>
			<form action="">
			<section id="plan">
               <div id="planhead">
		        <h3 style="margin-left:119px;font-size: 20px;font-family: monospace;">第<font color="red">1</font>天<a id="a_css" onclick="addDay()">加一天</a></h3>
                </div>
             <div id="plancontait">
				<p>
					<label style="margin-left:10px;"><font color="black">上午:</font></label>
					<input name="morning" id="morning" type="text" style="width:200px"/>
				</p>
				<p>
					<label style="margin-left:10px;"><font color="black">下午:</font></label>
					<input name="afternoon" id="afternoon" type="text" style="width:200px" />
				</p>
				</div>
				<section id="planfoot">
				 <input  id="cancel"  value="取消" type="submit"  onclick="reset()" />
				  <input  id="submit"  value="提交" type="submit"  />
				</section>
			
			</section>
			</form>
			</section>
			</header>
		</aside>
	
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
	
<script type="text/javascript">
//自定义覆盖物
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
    div.innerHTML="<div id='image'></div><h3 style='text-align:center'>"+this._placename+"</h3>";
    // 将div添加到覆盖物容器中  
   
    map.getPanes().markerPane.appendChild(div);
    // 保存div实例  
     var imagediv=document.getElementById("image");
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
// 实现隐藏方法  
SquareOverlay.prototype.hide = function () {
    if (this._div) {
        this._div.style.display = "none";
    }
}

SquareOverlay.prototype.addEventListener = function(event,fun){  
	this._div['on'+event] = fun;  
	} 
//自定义结束


var map = new BMap.Map("map");          // 创建地图实例
var point = new BMap.Point(116.404, 39.915);  // 创建点坐标
var totalldays=1;
var day=1;
var morningList = new Array();
var afternoonList = new Array();
//控件
map.centerAndZoom(point, 5);   
map.addControl(new BMap.NavigationControl());  //平移缩放
map.addControl(new BMap.ScaleControl());  //比例尺
//map.addControl(new BMap.OverviewMapControl());  //缩略图
    map.enableScrollWheelZoom();    
//标注
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
//addMarker(point);
//创建北京
 var marker = new BMap.Marker(point);        // 创建标注  
map.addOverlay(marker);      
var over=new SquareOverlay(map.getCenter(),120,"#ffffff","BeiJing","北京");
over.show();
map.addOverlay(over);
//创建

over.addEventListener('click',function1); 
function reset(){
	 var morning=document.getElementById("morning");
	 var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	 totalldays=1;
	 day=1;
	 morning.value="";
	 afternoon.value="";
	 var length=morningList.length;
	morningList.splice(0,length);
	afternoonList.s.splice(0,length);
	 planhead.innerHTML="<h3 style='margin-left:1190px;font-size: 20px;font-family: monospace;'>第<font color='red'>1</font>天<a id='a_css' onclick='addDay()'>加一天</a></h3>"
}
function addDay(){
	 totalldays=totalldays+1;
	 day=day+1;
	 var morning=document.getElementById("morning");
	 var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	// var plancontait=document.getElementById("plancontait");
	
	 morningList.push(morning.value);
	 afternoonList.push(afternoon.value);
	 var tmp=morningList[0];
     planhead.innerHTML="<h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='addDay()'>加一天</a></h3>";
    // document.getElementById("a_css_pre").onclick = (function(morningList){
    //	 return preDay(morningList);
   //  })(morningList);
     
		morning.value="";
		afternoon.value="";
}
function preDay(){
    day=day-1;
    var tmp=morningList[0];
	var morning=document.getElementById("morning");
	var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	 
	morningList[day]=morning.value;
	afternoonList[day]=afternoon.value;
	if(day==1){
		planhead.innerHTML="<h3 style='margin-left:119px;font-size: 20px;font-family: monospace;'>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='otherDay()'>后一天</a></h3>";
	}else{
		planhead.innerHTML="<h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='otherDay()'>后一天</a></h3>";
	}
	var tmp2=day-1;
	morning.value=morningList[tmp2];
	afternoon.value=afternoonList[tmp2];
}
function otherDay(){
	var morning=document.getElementById("morning");
	var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	 var tmp=day-1;
	 morningList[tmp]=morning.value;
	 afternoonList[tmp]=afternoon.value;
	 day=day+1;
	 if(day==totalldays){
		 planhead.innerHTML="<h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='addDay()'>加一天</a></h3>";
	 }else{
		 planhead.innerHTML="<h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='otherDay()'>后一天</a></h3>";
	 }
	 var tmp2=day-1;
	 morning.value=morningList[tmp2];
	 afternoon.value=afternoonList[tmp2];
}
function  function1(){
  	 var morning=document.getElementById("morning");
  	var afternoon=document.getElementById("afternoon");
  	 if(morning.value==""){
  	morning.value=point.lng+","+point.lat;
  	}else if(afternoon.value==""){
  		afternoon.value=point.lng+","+point.lat;
  	}else{
  		alert("您已经添加完当日的行程");
  		}
   } 
/*  var html = '<div class="tck_title" id="message">'
                        +'<div id="mc" class="title_zi">天安门</div>'
                          +'<div class="tck_neirong">'
                            +'<div class="nr_1">'
                               +'<div class="nr_top">'
                                 +'<div class="ne_top_l">'
                                   +'<img src="../images/anmen.jpg" rel="nofollow"/>'
                                   +'<div class="ne_top_r">'
                                     +'<div class="r_dizhi" id="address">地址：xxx街xxx号</div>'
                                       +'<div class="r_weizi"><input type="button" value="加入计划" onclick="function1()" /></div>'
                                     +'</div>'
                                   +'</div>'
                                   +'<div id="tc_content" class="nr_middle"></div>'
                                   +'<div class="nr_down" id="tc_pages"></div>'
                                 +'</div>';  
          function  function1(){
           	 var morning=document.getElementById("morning");
           	var afternoon=document.getElementById("afternoon");
           	 if(morning.value==""){
           	morning.value=point.lng+","+point.lat;
           	}else if(afternoon.value==""){
           		afternoon.value=point.lng+","+point.lat;
           	}else{
           		alert("您已经添加完当日的行程");
           		}
            } 
          var opts = {  
            		 width : 100,  
            		 height: 130, 
          }  
            var infoWindow= new BMap.InfoWindow(html,opts);
            infoWindow.disableCloseOnClick();
            
            map.openInfoWindow(infoWindow,point); 
         */
</script>


</body>
</html>