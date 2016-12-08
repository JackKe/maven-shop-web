<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>网上商城</title>
<link href="${ pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/css/product.css" rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/jqueryui/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/jquery/jquery-1.9.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/jqueryui/jquery-ui.min.js" type="text/javascript"></script>
<style type="text/css">
	<!--
	 .ui-dialog-titlebar { display:none; } 
	 	
	.showimage{
	width: 50px;
	height: 50px;
	}
	/* li{
	float: left;
	}
	a{
	text-decoration: none;
	} */
	-->
	</style>
<script type="text/javascript">
$(function(){
	$("#increase").click(function(){
		var num = $("#quantity").val();
		num = parseInt(num) + 1;
		$("#quantity").val(num);
	});
	
	$("#decrease").click(function(){
		var num = $("#quantity").val();
		num = parseInt(num);
		if(num != 0)
		  $("#quantity").val(num - 1);
	});
	
 	 $("#dialog").dialog({
		autoOpen : false,
		width : 400,
		height : 80,
		modal : true,
		//隐藏默认的关闭按钮
		open : function(event, ui) {
			$(".ui-dialog-titlebar-close", $(this).parent()).hide();
		},
		show : {//显示动画效果
			effect : "blind",
			duration : 1000
		},
		hide : {//关闭动画效果
			effect : "explode",
			duration : 1000
		}
	});
 	 
	$("#addCart").click(function(){
		var _username = "${session.user.username}";
		var  _pid = "${model.pid}";
		var _count = $("#quantity").val();
		alert(_username+","+_pid+","+_count)
		var url = "${pageContext.request.contextPath}/cart/saveCart.action";
		var args = {"username":_username,"pid":_pid,"count":_count,"time":new Date()};
		$.getJSON(url,args,function(data){
				if(!data.flag){
					$("#success").hide();
				    $("#failed").show();
				}
				$("#dialog").dialog("open");
				
				setTimeout(function(){//5秒后隐藏
					$("#dialog").dialog("close");
				}, 5000);				
		});
	});
	
});

</script>

</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a> <img
					src="${ pageContext.request.contextPath }/image/r___________renleipic_01/logo.gif"
					alt="传智播客" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${ pageContext.request.contextPath }/image\r___________renleipic_01/header.jpg" alt="正品保障"
					title="正品保障" height="50" width="320" />
			</div>
		</div>
		<%@ include file="menu.jsp"%>
	</div>
	<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
			<s:iterator value="#session.categorys" var="category">
				<dl>
					<dt>
						<a href="${ pageContext.request.contextPath }/products/categoryall.action?pageIndex=0&cid=<s:property value="#category.cid" />"><s:property value="#category.cname" /></a>
					</dt>
					<s:iterator value="#category.categoryseconds" var="categorysecond">
					<dd>
						<a href="${ pageContext.request.contextPath }/products/categorysecondall.action?pageIndex=0&csid=<s:property value="#categorysecond.csid" />"><s:property value="#categorysecond.csname" /> </a>
					</dd>
					</s:iterator>
					
				</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">

			<div class="productImage">
				<a title="" style="outline-style: none; text-decoration: none;"
					id="zoom"
					href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg"
					rel="gallery">
					<div class="zoomPad">
						<img style="opacity: 1;" title="" class="medium"
							src="${ pageContext.request.contextPath }/image/<s:property value="model.image" />" />
						<div
							style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
							class="zoomPup"></div>
						<div
							style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
							class="zoomWindow">
							<div style="width: 368px;" class="zoomWrapper">
								<div style="width: 100%; position: absolute; display: none;"
									class="zoomWrapperTitle"></div>
								<div style="width: 0%; height: 0px;" class="zoomWrapperImage">
									<img
										src="${ pageContext.request.contextPath }/image/<s:property value="model.image" />"
										style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;" />
								</div>
							</div>
						</div>
						<div
							style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;"
							class="zoomPreload">Loading zoom</div>
					</div>
				</a>

			</div>
			<div class="name">
				<s:property value="model.pname" />
			</div>
			<div class="sn">
				<div>
					编号：
					<s:property value="model.pid" />
				</div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥：<s:property value="model.shop_price" />元/份
						</strong> 参 考 价：
						<del>
							￥
							<s:property value="model.market_price" />
							元/份
						</del>
					</dd>
				</dl>
				<dl>
					<dt>促销:</dt>
					<dd>
						<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
					</dd>
				</dl>
				<dl>
					<dt></dt>
					<dd>
						<span> </span>
					</dd>
				</dl>
			</div>
			<div class="action">

				<dl class="quantity">
					<dt>购买数量:</dt>
					<dd>
						<input id="quantity" name="quantity" value="1" maxlength="4"
							onpaste="return false;" type="text" />
						<div>
							<span id="increase" class="increase">&nbsp;</span> <span
								id="decrease" class="decrease">&nbsp;</span>
						</div>
					</dd>
					<dd>件</dd>
				</dl>
				<div class="buy">
					<input id="addCart" class="addCart" value="加入购物车" type="button" />

				</div>
			</div>
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">商品介绍</a></li>

				</ul>
			</div>

			<div id="introduction" name="introduction" class="introduction">
				<div class="title">
					<strong><s:property value="model.pdesc" /></strong>
				</div>
				<div>
					<img
						src="${ pageContext.request.contextPath }/image/<s:property value="model.image" />" />
				</div>
			</div>



		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势"
					title="我们的优势" height="52" width="950" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
	<div id="dialog">
		<div id="success">
		<ul style="list-style: none;">
		<li style="float: left;" ><img src="${pageContext.request.contextPath }/image/shop_success.png" class="showimage" /></li>
		<li style="padding-left: 10px;padding-top: 15px;float: left;"><strong><h2>添加购物车成功！</h2></strong></li>
		<li style="float: left;" ><img src="${pageContext.request.contextPath }/image/shopping_cart.png" class="showimage" /></li>
		<li style="padding-left: 10px;padding-top: 15px;float: left;"><a href="${pageContext.request.contextPath }/cart_showCart.action"><strong style="color: green;"><h2>去结算</h2></strong></a></li>
		</ul>
		</div>
		<div id="failed" style="display: none;">
		<ul style="list-style: none;">
		<li style="float: left;" ><img src="${pageContext.request.contextPath }/image/sign_error.png" class="showimage" /></li>
		<li style="padding-left: 10px;padding-top: 15px;float: left;"><strong><h2>添加购物失败！</h2></strong></li>
		</ul>
		</div>
	</div>
	
</body>
</html>