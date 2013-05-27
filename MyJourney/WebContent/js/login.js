 function logon(){
	 var a = $("#name").val();
	 var p = $("#password").val();
	 $.post('/MyJourney/ajax/sign',{account:a,password:p},function(data){
	   },'json').error(function(){alert("登录失败")}).complete(function(){location.reload()});
	 hideLogin();
 }
 function showLogin(){document.getElementById('loginDiv').style.display='block';}
 function hideLogin(){document.getElementById('loginDiv').style.display='none';}