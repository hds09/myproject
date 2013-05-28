<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container" style="width:1140px;margin:20px auto;">
	<div class="travels_title pt20 fn-pr">
    	<!--标题编辑-->
    	<div class="travels_title_na fn-pr z-index100 fn-clearfix">
   		<h1 class="J-album-name font-yahei darkgray333 ml30 mr30 fn-fl">${journey.journeyName }</h1>
   		<script type="text/javascript" charset="utf-8">
		(function(){
		var p = [], w=210, h=65,
		lk = {
		url:location.href, /*喜欢的URL(不含如分页等无关参数)*/
		title:'云游', /*喜欢标题(可选)*/
		description:'云游网', /*喜欢简介(可选)*/
		image:'http://169.254.133.57:8080/MyJourney/images/yunyou.jpg' /*喜欢相关图片的路径(可选)*/
		};
		for(var i in lk){
		p.push(i + '=' + encodeURIComponent(lk[i]||''));
		}
		document.write('<iframe style="position: absolute;top: 10px;right:80px;" scrolling="no" frameborder="0" allowtransparency="true" src="http://www.connect.renren.com/like/v2?'+p.join('&')+'" style="width:'+w+'px;height:'+h+'px;"></iframe>');
		})();
	</script>
	<script type="text/javascript" src="http://widget.renren.com/js/rrshare.js"></script>
	<a name="xn_share" style="position: absolute;top: 10px;right:100px;" onclick="shareClick()" type="button_large" href="javascript:;"></a>
	<script type="text/javascript">
		function shareClick() {
			var rrShareParam = {
				resourceUrl : 'http://169.254.133.57:8080/MyJourney/pic/album?albumId=${journey.id}',	//分享的资源Url
				srcUrl : '',	//分享的资源来源Url,默认为header中的Referer,如果分享失败可以调整此值为resourceUrl试试
				pic : 'http://169.254.133.57:8080/MyJourney/images/yunyou.jpg',		//分享的主题图片Url
				title : '云游网',		//分享的标题
				description : '最潮的旅游规划分享站'	//分享的详细描述
			};
			rrShareOnclick(rrShareParam);
		}
	</script>
		</div>
   		<div class="font-tahoma f12 darkgray666 ml30 mt5 fn-clearfix z-index99">
    		<div class="userName mr10 fn-fl textarea_lineH"><em class="darkgray999">by</em> <a href="#">${journey.user.name }</a></div>
			<div class="f12 fn-fl textarea_lineH mr10">共${journey.places.size() }个地方</div>
			<div class="album_textarea_is fn-pr fn-fl">
				<div id="maddressName" class="fn-clearfix">
					<span class="textarea_lineH fn-fl">状态：</span>
					<span class="J-destination textarea_lineH fn-fl">
						<s:if test="#journey.state==1">
							进行中
						</s:if>
						<s:elseif test="#journey.state==0">
							未开始
						</s:elseif>
						<s:else>
							已结束
						</s:else>
					</span>
				</div>
			</div>
     	</div>
        <div class="travels_line png24"></div>
  </div>
	<!--主体-->
	<div class="travels_main fn-clearfix fn-pr">
    	<div id="shortcut" class="travels_left mt15 fn-fl ml30" style="top: 237px;">
			<div class="travels_days mb10 f16 fb white png24">共${place.images.size() }张图片</div>
			<!--随页面滚动的天数list-->
			<div class="shorcut-nav-main fn-pr">
				<div class="shortcut-nav fn-pa" style="top: 0px;">
				<ul>
					<s:iterator value="journey.places" var="pl" status="i">
						<s:if test="#i.index == page">
							<li><a class="line_gray hili" href="album?albumId=${journey.id }&page=${i.index}" title="">${pl.city.name }</a></li>
						</s:if>
						<s:else>
	               			<li><a class="line_gray" href="album?albumId=${journey.id }&page=${i.index}" title="">${pl.city.name }</a></li>
	               		</s:else>
					</s:iterator>
				</ul>
				</div>
			</div>
        </div>
        <!--右侧主体内容-->
    	<div class="travels_right fn-fr mr30 mt15 fn-pr">
        	<div class="travels_right_day fn-pa png24"></div>
            <!--第几天标题-->
            <div class="travels_right_day_t fn-pa font-yahei darkgray666">第${page+1 }个地方 :${place.city.name }</div>
            <div style="height:37px;"></div>
            <!--第一条 插入文字/插入图片 不参与循环-->
            <s:iterator value="images" var="image">
           		<div class="J-hidden"></div>
           		<div class="travels_right_cont fn-pr fn-tc">
	                <a href="" class="travels_right_img  fn-pr">
	                	<span class="travels_arrows fn-pa" style="width:782px"></span>
	            		<img class="qpic" src="${image.imagepath }" width="782" height="499">
	                </a>
            	</div>
            </s:iterator>
            <s:if test="images.size()==0">
            	<div class="J-hidden"></div>
           		<div class="travels_right_cont fn-pr fn-tc">
                	<span class="travels_arrows fn-pa" style="width:782px"></span>
            		<img class="qpic" src="/MyJourney/createAlbum/resource/default.jpg" width="782" height="499" alt="请上传图片">
            	</div>
            </s:if>
        </div><!--travels_right end-->
    </div><!--travels_main end-->
</div><!--container end-->