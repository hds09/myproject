<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<head>
<script type="text/javascript">
	function changePhoto(photo){
		document.getElementById("photo").src = photo.value;
	}
</script>
</head>
<div>
	<form action="/MyJourney/pic/createHeadPhoto" method="post" enctype="multipart/form-data">
		<img id="photo" alt="" src="${daren.image }" width="200" height="200"><br>
		<input width="200px;" type="file" name="photo" onchange="changePhoto(this)"/><br>
		<input value="上传" type="submit"/>
	</form>
</div>