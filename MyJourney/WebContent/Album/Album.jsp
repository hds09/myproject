<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>旅图——相册</title>
</head>
<body>
           人人喜欢
	<script type="text/javascript" charset="utf-8">
		(function(){
		var p = [], w=210, h=65,
		lk = {
		url:''||location.href, /*喜欢的URL(不含如分页等无关参数)*/
		title:''||document.title, /*喜欢标题(可选)*/
		description:'', /*喜欢简介(可选)*/
		image:'' /*喜欢相关图片的路径(可选)*/
		};
		for(var i in lk){
		p.push(i + '=' + encodeURIComponent(lk[i]||''));
		}
		document.write('<iframe scrolling="no" frameborder="0" allowtransparency="true" src="http://www.connect.renren.com/like/v2?'+p.join('&')+'" style="width:'+w+'px;height:'+h+'px;"></iframe>');
		})();
	</script>
	人人分享
	<script type="text/javascript" src="http://widget.renren.com/js/rrshare.js"></script>
	<a name="xn_share" onclick="shareClick()" type="button_large" href="javascript:;"></a>
	<script type="text/javascript">
		function shareClick() {
			var rrShareParam = {
				resourceUrl : '',	//分享的资源Url
				srcUrl : '',	//分享的资源来源Url,默认为header中的Referer,如果分享失败可以调整此值为resourceUrl试试
				pic : '',		//分享的主题图片Url
				title : '',		//分享的标题
				description : ''	//分享的详细描述
			};
			rrShareOnclick(rrShareParam);
		}
	</script>
	人人转发
	<script type="text/javascript">
		window.__fwdCfg = {
		"api_key" : "0c5d96cdb0714935a873b58e47c59a75"
		};
	</script>
	<script type="text/javascript" src="http://widget.renren.com/js/forward.js" async="true"></script>
	
	<a href="http://www.renren.com/SysHome.do?origURL=http%3A%2F%2Fwidget.renren.com%2Fredirect%3Fredirect_uri%3Dhttp%253A%252F%252Fwww.renren.com%252F321212399%253Fss%253D17095%2526origin%253D92001%26biz_type%3Dplugin_follow%26app_id%3D180932%26action%3Dlogin_suc" target="_blank"><img src="http://signature.xnimg.cn/badge/signature/sig/321212399/5b9e0fe2858c28d9ce9d2e4c82b44a5c/0/0.png"/></a>
</body>
</html>