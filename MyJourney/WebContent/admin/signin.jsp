<html>
	<head>
		<link rel="stylesheet" href="../css/admin_lgn.css" type="text/css"/>
	</head>
	<body>
		<div id="container">
			<div class="global_header">
				<div class="header_left">
					<img src="../images/sdd09/admin_key.jpg"/><span>MyJourney Admin Portal</span>
				</div>
				<div class="header_right" align="right">
					<span class="version">version 0.0.1</span>
				</div>
			</div>
			
				
			<div id="login_wrap">
				<div id="login_form">
					<span class="l_p">
						Access the backend system
					</span>
					<form name="form1" action="adminlogin" method="post">
						<span class="l_pp">User Name</span><br/>
						<input type="text" name="email"/>
						<br/>
						<span class="l_pp">Password</span><br/>
						<input type="password" name="password"/>
						<div id="login_sbmt" align="right">
							<input type="submit" value="Log In"/>
						</div>
					</form>
				</div>
			</div>	
		</div>
		
	</body>
</html>