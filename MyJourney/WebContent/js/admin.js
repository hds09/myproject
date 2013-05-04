function showField(index){
	if(index==1){
		document.getElementById('addUserDiv').style.display='block';
		document.getElementById('b_addUserDiv').style.display='none';
	}
	if(index==2){
		document.getElementById('addUserDiv').style.display='none';
		document.getElementById('b_addUserDiv').style.display='block';
	}
}
function hideField(index){
	if(index==1){
		document.getElementById('addUserDiv').style.display='none';
	}
	if(index==2){
		document.getElementById('b_addUserDiv').style.display='none';
	}
}

