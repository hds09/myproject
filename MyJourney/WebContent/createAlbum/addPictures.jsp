<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<div id="uploadDialog" style="">
	
	<form action="/MyJourney/pic/createAlbum"  method="post" enctype="multipart/form-data">
		<input  name="placeId" type="hidden"/>
		<input  type="file" name="picList"/><br>
		<input class="gbutton" value="上传" type="submit"/><br>
	</form>
</div>