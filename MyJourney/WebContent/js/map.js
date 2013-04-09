var map = new BMap.Map("map");          // 创建地图实例
var point = new BMap.Point(116.404, 39.915);  // 创建点坐标

//控件
map.centerAndZoom(point, 15);   
map.addControl(new BMap.NavigationControl());  //平移缩放
map.addControl(new BMap.ScaleControl());  //比例尺
//map.addControl(new BMap.OverviewMapControl());  //缩略图

//标注

function addMarker(point){  
	// 创建图标对象  
	var myIcon = new BMap.Icon("image/marker.jpg", new BMap.Size(23, 25), {  
	// 指定定位位置。  
	// 当标注显示在地图上时，其所指向的地理位置距离图标左上  
	   // 角各偏移10像素和25像素。您可以看到在本例中该位置即是  
	   // 图标中央下端的尖角位置。  
	   offset: new BMap.Size(10, 25),  
	   // 设置图片偏移。  
	   // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您  
	   // 需要指定大图的偏移位置，此做法与css sprites技术类似。  
	   imageOffset: new BMap.Size(10,-10)   // 设置图片偏移  
	 });    
	 // 创建标注对象并添加到地图  
	 var marker = new BMap.Marker(point, {icon: myIcon});  
	 map.addOverlay(marker);  
	}  
addMarker(point);
var marker = new BMap.Marker(point);        // 创建标注  
map.addOverlay(marker);      
// 初始化地图，设置中心点坐标和地图级别


/* marker.enableDragging();  
marker.addEventListener("dragend", function(e){  
 alert("当前位置：" + e.point.lng + ", " + e.point.lat);  
})  */ 
/* var html = ['<div class="tck_title" id="tck_title">',
            '<div id="mc" class="title_zi">帝国大厦</div>', 
            '<div class="tck_neirong">',
            '<div class="nr_1">', 
            '<div class="nr_top">',
            '<div class="ne_top_l"><img onclick="xuanze_suoluetu(1);" src="http://archive.cnblogs.com/a/2817966/img_vv/nopic.png" rel="nofollow"/>', 
            '<div class="ne_top_r">', 
            '<div class="r_dizhi" id="address">地址：潍坊市世纪泰华</div>', 
            '<div class="r_weizi">', 
            '</div>', 
            '</div>', 
            '</div>', 
            '<div id="tc_content" class="nr_middle">',
            '</div>',
            '<div class="nr_down" id="tc_pages">', 
            '</div>', 
            '</div>'];  */
            var html = '<div class="tck_title" id="tck_title">'
                        +'<div id="mc" class="title_zi">天安门</div>'
                          +'<div class="tck_neirong">'
                            +'<div class="nr_1">'
                               +'<div class="nr_top">'
                                 +'<div class="ne_top_l">'
                                   +'<img src="image/anmen.jpg" rel="nofollow"/>'
                                   +'<div class="ne_top_r">'
                                     +'<div class="r_dizhi" id="address">地址：xxx街xxx号</div>'
                                       +'<div class="r_weizi"><input type="button" value="加入计划" onclick="function1()" /></div>'
                                     +'</div>'
                                   +'</div>'
                                   +'<div id="tc_content" class="nr_middle"></div>'
                                   +'<div class="nr_down" id="tc_pages"></div>'
                                 +'</div>';  
        /*  alert("ok1");
          var infoBox = new BMapLib.InfoBox(map,html); 
            alert("ok2");
            infoBox.open(point); */
          function  function1(){
           	 alert(point.lng+","+point.lat);
            } 
          var opts = {  
            		 width : 250,     // 信息窗口宽度  
            		 height: 250,     // 信息窗口高度  
            		 title : "Hello"  // 信息窗口标题  
            		 
            		}  
            var infoWindow= new BMap.InfoWindow(html,opts);
            infoWindow.disableCloseOnClick();
            
            map.openInfoWindow(infoWindow,point); 
            map.enableScrollWheelZoom();
           /*  map.addEventListener("click",function(e){
              	 alert(point.lng+","+point.lat);
              	});
            infoWindow.addEventListener("click",function(e){
           	 alert(point.lng+","+point.lat);
           	}); */
        