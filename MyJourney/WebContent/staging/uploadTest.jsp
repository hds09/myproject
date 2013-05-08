<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="citybatchupload" method="post" enctype="multipart/form-data">
		<span>city upload</span>
		<input type="file" name="cityXml"/>
		<input type="submit" value="add"/>
	</form>
	<form action="hotelbatchupload"  method="post" enctype="multipart/form-data">
		<span>hotel upload</span>
		<input type="file" name="hotelXml"/>
		<input type="submit" value="add"/>
	</form>
	<form action="attractionbatchupload"  method="post" enctype="multipart/form-data">
		<span>attraction upload</span>
		<input type="file" name="attractionXml"/>
		<input type="submit" value="add"/>
	</form>
	<form action="restbatchupload"  method="post" enctype="multipart/form-data">
		<span>restaurant upload</span>
		<input type="file" name="restXml"/>
		<input type="submit" value="add"/>
	</form>
	<form action="journeybatchupload"  method="post" enctype="multipart/form-data">
		<input type="file" name="journeyXml"/>
		<input type="submit" value="add"/>
	</form>
</body>
</html>