var flag=1;
var quick_publish_hide=0;
var p_trip_rate=1;
var show_hide_search_area=1;
var currDiv=1;
var currMenu=1;
function makeActive(index){
	if(currMenu==2){
		var nodelist=document.getElementsByClassName("tab_item");
		for (var i=0;i<nodelist.length;i++){
			if(i==index){
				nodelist.item(i).className="active tab_item";
			}else{
				nodelist.item(i).className="tab_item";
			}
		}
		if(index==0){
			changeDiv(2);
		}else{
			changeDiv(3);
		}
	}
	return false;
};


function changeDiv(index){
	if(index==1){
		document.getElementById('j_result').style.display='block';
		document.getElementById('team_results').style.display='none';
		document.getElementById('all_tj_results').style.display='none';
		var tmp1=$('.trip_type_selected');
		var tmp2=$('.trip_type_diselected');
		tmp1.removeClass().addClass('trip_type_diselected');
		tmp2.removeClass().addClass('trip_type_selected');
		var nodelist=document.getElementsByClassName("tab_item");
		nodelist.item(1).style.display='none';
		nodelist.item(0).className="active tab_item";
		currDiv=1;
		currMenu=1;
	}else if(index==2){
		document.getElementById('j_result').style.display='none';
		document.getElementById('team_results').style.display='block';
		document.getElementById('all_tj_results').style.display='none';
		if(currMenu==1){
			var tmp1=$('.trip_type_selected');
			var tmp2=$('.trip_type_diselected');
			tmp1.removeClass().addClass('trip_type_diselected');
			tmp2.removeClass().addClass('trip_type_selected');
		}
		
		var nodelist=document.getElementsByClassName("tab_item");
		nodelist.item(0).className="active tab_item";
		nodelist.item(1).className="tab_item";
		nodelist.item(1).style.display='block';
		currDiv=2;
		currMenu=2;
	}else{
		document.getElementById('j_result').style.display='none';
		document.getElementById('team_results').style.display='none';
		document.getElementById('all_tj_results').style.display='block';
		var nodelist=document.getElementsByClassName("tab_item");
		nodelist.item(0).className="tab_item";
		nodelist.item(1).className="active tab_item";
		nodelist.item(1).style.display='block';
		currDiv=3;
		currMenu=2;
	}
};

function showField(index){
	var id='#'+'commentField'+index;
	$(id).show(500);
};

function hideField(index){
	var id='#'+'commentField'+index;
	$(id).hide(500);
};

function showhidePField(index){
	if($('.p_trip_rate').text()=='+展开评论'){
		showPField(index);
	}else{
		hidePField(index);
		
	}
};
function hidePField(index){
	var id='#'+'p_trip_commentField'+index;
	$(id).hide(500);
	$('.p_trip_rate').text('+展开评论');
};
function showPField(index){
	var id='#'+'p_trip_commentField'+index;
	$(id).show(500);
	$('.p_trip_rate').text('-收起评论');
};
function closeCenterDiv(id){
	var id='#center_div'+id;
	$(id).hide(200);
};

function openCenterDiv(id){
	var id='#center_div'+id;
	$(id).show(200);
};

function showNextPicture(){
	var nodelist=document.getElementsByClassName("img");
	for (var i=0;i<nodelist.length;i++){
		if(nodelist.item(i).className=='present img'){
			nodelist.item(i).className='hidden img';
			var next=(i+1)%(nodelist.length);
			nodelist.item(next).className='present img';
			break;
		}
	}
};

function showPreviousPicture(){
	var nodelist=document.getElementsByClassName("img");
	for (var i=0;i<nodelist.length;i++){
		if(nodelist.item(i).className=='present img'){
			nodelist.item(i).className='hidden img';
			if(i==0){
				nodelist.item(nodelist.length-1).className='present img';
			}else{
				nodelist.item(i-1).className='present img';
			}
			break;
		}
	}
};

function showMembers(){
	if(flag==1){
		$('#team_member').show(300);
		$('#team_member_line > span').text('收起');
		flag=2;
	}else{
		$('#team_member').hide(300);
		$('#team_member_line > span').text('展开查看成员列表');
		flag=1;
	}
};

function showQP(){
	if(quick_publish_hide==0){
		$('#quick_publish_div').show(200);
		$('.showQuickPublish').text('快速发布[-]');
		quick_publish_hide=1;
	}else{
		$('#quick_publish_div').hide(200);
		$('.showQuickPublish').text('快速发布[+]');
		quick_publish_hide=0;
	}
	
};

function sndSearchField(){
	if(show_hide_search_area==1){
		document.getElementById('s_arrow').src='../images/sdd09/arr.jpg';
		show_hide_search_area=2;
		$('#search_field').show(100);
	}else{
		document.getElementById('s_arrow').src='../images/sdd09/arr_d.jpg';
		show_hide_search_area=1;
		$('#search_field').hide(100);
	}
}
