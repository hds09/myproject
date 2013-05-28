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
<s:iterator value="citylist" var="city">
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
		    <li><a href="Hotels">酒店</a></li>
			<li><a href="Restaurants">饭店</a></li>
			<li class="selected"><a href="makeRoute">旅程</a></li>
			<li><a href="/MyJourney/pic/picwall">旅图</a></li>
			<li><a href="userJourneyManagement">管理</a></li>
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
	
		<aside>
	     <header>
		<section id="plancontainer">
			<h2>&nbsp&nbsp您的行程计划：</h2>
			<form name="form" action="submitRoute" method="post">
			<section  id="plan">
               <div id="planhead">
               <h3>行程名称:<input type="text" value="" name="routeName" id="routeName" width="100px"/></h3>
               <h3>行程性质:<input type="radio" value="0" name="state" id="state" checked="checked"/>个人<input type="radio" value="1" name="state" id="state2" />组队</h3>
               <h3>起始日期:<input name="Date" id="startDate" type="date"  onblur="setchange()"></h3>
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
				 <input  id="cancel"  value="取消" type="button"  onclick="reset()" />
				  <input  id="submit"  value="提交" type="submit"  onclick="f1()"/>
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
var totalldays=1;
var day=1;
var morningList = new Array();
var afternoonList = new Array();
var date;
var beijingPoint=new BMap.Point(116.404, 39.915);
var cityPointList=document.getElementsByName("cityPointList");
var cityNameList=document.getElementsByName("cityNameList");
var cityPictureList=document.getElementsByName("cityPictureList");
var citylength=cityPointList.length;
for(var i=0;i<citylength;i++){
	var tmpString=cityPointList[i].value;
	var Stringlist=new Array();
	Stringlist=tmpString.split(",");
	var point=new BMap.Point(Stringlist[0],Stringlist[1]);
	//create(map,new BMap.Point(116.404,39.915),cityPictureList[i].value,cityNameList[i].value);
	create(map,point,cityPictureList[i].value,cityNameList[i].value);
}  
//控件
/* var beijingPoint=new BMap.Point(116.404, 39.915);
var chengduPoint=new BMap.Point(104.06,30.67);
var xiamenPoint =new BMap.Point(118.1,24.46);
var xianggangPoint=new BMap.Point(114.1,22.2);
var hangzhouPoint=new BMap.Point(120.19,30.26);
create(map,beijingPoint,"BeiJing","北京");
create(map,chengduPoint,"ChengDu","成都");
create(map,xiamenPoint,"XiaMen","厦门");
create(map,xianggangPoint,"XiangGang","香港");
create(map,hangzhouPoint,"HangZhou","杭州"); */
initDate();
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
function create(map,centerpoint,imagename,placename){
	var marker = new BMap.Marker(centerpoint);        // 创建标注  
	map.addOverlay(marker);      
	var over=new SquareOverlay(centerpoint,120,"#ffffff",imagename,placename);
	over.show();
	map.addOverlay(over);
   
	over.addEventListener('click',function(){
	 	 var morning=document.getElementById("morning");
	   	var afternoon=document.getElementById("afternoon");
	   	 if(morning.value==""){
	   	morning.value=placename;
	   	}else if(afternoon.value==""){
	   		afternoon.value=placename;
	   	}else{
	   		alert("您已经添加完当日的行程");
	   		}
	}); 
	over.addEventListener('mouseover',function(){
		over.up();
		
	});
}

function f1(){

	 var morning=document.getElementById("morning");
	 var afternoon=document.getElementById("afternoon");
	 morningList.push(morning.value);
	 afternoonList.push(afternoon.value);
	 var planDiv=document.getElementById("plan");
	var div=document.createElement("div");
	var length=morningList.length;
	//alert("length:"+length);
	for(var i=0;i<length;i++){
		var inputMorning=document.createElement("input");
		inputMorning.setAttribute("type","hidden");
		inputMorning.setAttribute("name","morninglist");
		//alert("morninglist:"+morningList[i]);
		inputMorning.setAttribute("value",morningList[i]);
		div.appendChild(inputMorning);
		
		var inputAfternoon=document.createElement("input");
		inputAfternoon.setAttribute("type","hidden");
		inputAfternoon.setAttribute("name","afternoonlist");
		inputAfternoon.setAttribute("value",afternoonList[i]);
		div.appendChild(inputAfternoon);
	}
	var m=date.getMonth()+1;
	var dateToString=changeDateFormat(date.getFullYear(),m,date.getDate());
	var input=document.createElement("input");
	input.setAttribute("type","hidden");
	input.setAttribute("name","startDate");
	input.setAttribute("value",dateToString);


	div.appendChild(input);
	
	planDiv.appendChild(div);
	document.form1.action="submitRoute";
    document.submit(); 
	/*  var morningString=document.getElementById("morningString");
	 var afternoonString=document.getElementById("afternoonString");
	 var tmpmorning=morningList[0];
	 var tmpafternoon=afternoonList[0];
	 													
	 var length=morningList.length;
	 for(var i=1;i<length;i++){
		 tmpmorning=tmpmorning+"/"+morningList[i];
		 tmpafternoon=tmpafternoon+"/"+afternoonList[i];
	 }
	 morningString.value=tmpmorning;
	 afternoonString.value=tmpafternoon;
	 
	 document.form.action="submitRoute";
    document.submit(); */
}
function creatMorningInput(morning){

	return input;
}
function creatAfternoonInput(afternoon){
	var input=document.getElementById("input");
	input.setAttribute("type","hiden");
	input.setAttribute("name","afternoonlist");
	input.setAttribute("value",afternoon);
	return input;
}
function setchange(){
	if(day==1){
		date=new Date(document.getElementById("startDate").value);
	}
}
function initDate(){
	var date1=new Date();
	var m=date1.getMonth()+1;
	var currentDate=changeDateFormat(date1.getFullYear(),m,date1.getDate());
	document.getElementById("startDate").value=currentDate;
	date=new Date();

}
function changeDateFormat(year,month,day){
	var result="";
	var monthString="";
	var dayString="";
	if(month<10){
		monthString="0";
	}
	if(day<10){
		dayString="0";
	}
	monthString=monthString+month;
	dayString=dayString+day;
	result=year+"-"+monthString+"-"+dayString;
	return result;
}

function DateAddDay(date){
	var tomo = new   Date((date/1000+86400*1)*1000);
	return tomo;
}
function DateMinusDay(date){
	var yester = new  Date((date/1000-86400*1)*1000);
	return yester;
}
function reset(){
	 initDate();
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
	 planhead.innerHTML="<h3>行程名称:<input type='text' value='' name='routeName' id='routeName' /></h3><h3>行程性质:<input type='radio' value='0' name='state' id='state' checked='checked'/>个人<input type='radio' value='1' name='state' id='state' />组队</h3><h3>起始日期<input name='Date' id='startDate' type='date' onblur='setchange()' ></h3><h3 style='margin-left:1190px;font-size: 20px;font-family: monospace;'>第<font color='red'>1</font>天<a id='a_css' onclick='addDay()'>加一天</a></h3>"
}
function addDay(){
	if(day==1){
		date=new Date(document.getElementById("startDate").value);
	
	}
	 var dateId=document.getElementById("startDate");
	 var tmp=new Date(dateId.value);
	 var tomo=DateAddDay(tmp);
	 var m=tomo.getMonth()+1;
	 var tmpString=changeDateFormat(tomo.getFullYear(),m,tomo.getDate());
	 totalldays=totalldays+1;
	 day=day+1;
	 var morning=document.getElementById("morning");
	 var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	 var routeName=document.getElementById("routeName");
	 var state=document.getElementById("state");
	 var statehtml="";
	 if(!state.checked){
		 statehtml="<h3>行程性质:<input type='radio' value='0' name='state' id='state' />个人<input type='radio' value='1' name='state' id='state2' checked='checked'/>组队</h3>";
	 }else{
		 statehtml="<h3>行程性质:<input type='radio' value='0' name='state' id='state' checked='checked'/>个人<input type='radio' value='1' name='state' id='state2' />组队</h3>";
	 }
	// var plancontait=document.getElementById("plancontait");
	
	 morningList.push(morning.value);
	 afternoonList.push(afternoon.value);
	 var tmp=morningList[0];
     planhead.innerHTML="<h3>行程名称:<input type='text' value='"+routeName.value+"' name='routeName' id='routeName' /></h3>"+statehtml+"<h3>起始日期<input name='Date' id='startDate' type='date'onblur='setchange()'></h3><h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='addDay()'>加一天</a></h3>";
    // document.getElementById("a_css_pre").onclick = (function(morningList){
    //	 return preDay(morningList);
   //  })(morningList);
     
		morning.value="";
		afternoon.value="";
		document.getElementById("startDate").value=tmpString;
}
function preDay(){
    day=day-1;
    var tmp=morningList[0];
	var morning=document.getElementById("morning");
	var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	 var dateId=document.getElementById("startDate");
	 var routeName=document.getElementById("routeName");
	 var tmp=new Date(dateId.value);
	 var yester=DateMinusDay(tmp);
	 var tmpString=changeDateFormat(yester.getFullYear(),yester.getMonth()+1,yester.getDate());
	 var state=document.getElementById("state");
	 var statehtml="";
	 if(!state.checked){
		 statehtml="<h3>行程性质:<input type='radio' value='0' name='state' id='state' />个人<input type='radio' value='1' name='state' id='state2' checked='checked'/>组队</h3>";
	 }else{
		 statehtml="<h3>行程性质:<input type='radio' value='0' name='state' id='state' checked='checked'/>个人<input type='radio' value='1' name='state' id='state2' />组队</h3>";
	 }
	morningList[day]=morning.value;
	afternoonList[day]=afternoon.value;
	if(day==1){
		planhead.innerHTML="<h3>行程名称:<input type='text' value='"+routeName.value+"' name='routeName' id='routeName' /></h3>"+statehtml+"<h3>起始日期<input name='Date' id='startDate' type='date' onblur='setchange()'></h3><h3 style='margin-left:119px;font-size: 20px;font-family: monospace;'>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='otherDay()'>后一天</a></h3>";
	}else{
		planhead.innerHTML="<h3>行程名称:<input type='text' value='"+routeName.value+"' name='routeName' id='routeName' /></h3>"+statehtml+"<h3>起始日期<input name='Date' id='startDate' type='date' onblur='setchange()'></h3><h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='otherDay()'>后一天</a></h3>";
	}
	var tmp2=day-1;
	morning.value=morningList[tmp2];
	afternoon.value=afternoonList[tmp2];
	document.getElementById("startDate").value=tmpString;
}
function otherDay(){
	if(day==1){
		date=new Date(document.getElementById("startDate").value);
	
	}
	 var dateId=document.getElementById("startDate");
	 var tmp=new Date(dateId.value);
	 var tomo=DateAddDay(tmp);
	 
	 var tmpString=changeDateFormat(tomo.getFullYear(),tomo.getMonth()+1,tomo.getDate());
	var morning=document.getElementById("morning");
	var afternoon=document.getElementById("afternoon");
	 var planhead=document.getElementById("planhead");
	 var routeName=document.getElementById("routeName");
	 var state=document.getElementById("state");
	 var statehtml="";
	 if(!state.checked){
		 statehtml="<h3>行程性质:<input type='radio' value='0' name='state' id='state' />个人<input type='radio' value='1' name='state' id='state2' checked='checked'/>组队</h3>";
	 }else{
		 statehtml="<h3>行程性质:<input type='radio' value='0' name='state' id='state' checked='checked'/>个人<input type='radio' value='1' name='state' id='state2' />组队</h3>";
	 }
	 var tmp=day-1;
	 morningList[tmp]=morning.value;
	 afternoonList[tmp]=afternoon.value;
	 day=day+1;
	 if(day==totalldays){
		 planhead.innerHTML="<h3>行程名称:<input type='text' value='"+routeName.value+"' name='routeName' id='routeName' /></h3>"+statehtml+"<h3>起始日期<input name='Date' id='startDate' type='date' onblur='setchange()'></h3><h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='addDay()'>加一天</a></h3>";
	 }else{
		 planhead.innerHTML="<h3>行程名称:<input type='text' value='"+routeName.value+"' name='routeName' id='routeName' /></h3>"+statehtml+"<h3>起始日期<input name='Date' id='startDate' type='date' onblur='setchange()'></h3><h3 style='margin-left:0px;font-size: 20px;font-family: monospace;'><a id='a_css_pre' onclick='preDay()'>前一天</a>第<font color='red'>"+day+"</font>天<a id='a_css' onclick='otherDay()'>后一天</a></h3>";
	 }
	 var tmp2=day-1;
	 morning.value=morningList[tmp2];
	 afternoon.value=afternoonList[tmp2];
	 document.getElementById("startDate").value=tmpString;
}

</script>


</body>
</html>