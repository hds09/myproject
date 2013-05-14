<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人人登录</title>
</head>
<body>
<!-- 人人网跨域文件 -->
<script src="http://static.connect.renren.com/js/v1.0/XdCommReceiver.jsp" type="text/javascript"></script>
${name }
<img alt="人人头像" src="${headurl }">
 <a href="https://graph.renren.com/oauth/authorize?client_id=${client_id }&response_type=code&redirect_uri=${redirect_url }&display=page">
        <img style="border:0px" src="../sns/RENREN.png"/></a>
<%--第二个人人登录按钮，测试权限处理 --%>
<a href="https://graph.renren.com/oauth/authorize?client_id=${client_id }&response_type=code&redirect_uri=${redirect_url }&display=page&scope=read_user_album+read_user_feed">
<img style="border:0px" src="../sns/RENREN.png"/></a>

</body>
</html>