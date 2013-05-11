 function logon(){
	 $.post('/MyJourney/ajax/sign',{account:'fdp',password:"fdp"},function(data){
		 //alert(data.result);
		 if(data.result=="success"){
			 location.reload();
		 }
	   },'json');
 }
 function showLogin(){document.getElementById('loginDiv').style.display='block';}
 function hideLogin(){document.getElementById('loginDiv').style.display='none';}