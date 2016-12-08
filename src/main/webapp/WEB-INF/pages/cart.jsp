<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>购物车</title>

<link href="${ pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/css/cart.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/jquery/jquery-1.9.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/jquery/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
    	$("#effectivePoint").click(function(){
    		var val1 = $("#test").innerHTML;
    		alert(val1);
    	});
    	
    	/* $(".delete").click(function(){
    		var obj_tr = this.parentNode.parentNode;
    		var obj = this.parentNode.childNodes[1];
    		var cartid = obj.value;
    		var url = "${pageContext.request.contextPath}/cart_removeCart";
    		var args = {"cartid":cartid , "time":new Date()};
    		$.getJSON(url,args,function(data){
    			alert(data.flag)
    			$("#test").val("123");
    			obj_tr.remove();
    		});
    	}); */
    });
</script>
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="http://localhost:8080/mango/"> <img
					src="${ pageContext.request.contextPath }/image/r___________renleipic_01/logo.gif" alt="传智播客" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${ pageContext.request.contextPath }/image/header.jpg" width="320" height="50" alt="正品保障"
					title="正品保障" />
			</div>
		</div>		
		<%@ include file="menu.jsp" %>
	</div>
	<div class="container cart">
		<div class="span24">
			<div class="step step1"></div>
			<table>
				<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<s:iterator value="model.result" var="cart">
					<tr>
						<td width="60"><input type="hidden" name="id" value="22" />
							<img src="${ pageContext.request.contextPath }/image/<s:property value="#cart.product.image" />" /></td>
						<td><a target="_blank"><s:property value="#cart.product.pname" /></a></td>
						<td>￥<s:property value="#cart.product.shop_price" /></td>
						<td class="quantity" width="60"><s:property value="#cart.count" /></td>
						<td width="140"><span class="subtotal">￥<s:property value="#cart.product.shop_price * #cart.count" /></span></td>
						<td><a href="${ pageContext.request.contextPath }/cart/removeCart.action?cartid=<s:property value="#cart.cartid" />" class="delete">删除</a><input type="text" value="<s:property value="#cart.cartid" />" style="display: none;" /></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<dl id="giftItems" class="hidden" style="display: none;">
			</dl>
			<div class="total">
				<em id="promotion"></em> 
				<em> 登录后确认是否享有优惠 </em> 
				赠送积分: <em id="effectivePoint"><label id="test"><s:property value="model.totalPrices" /></label></em>
				 商品金额: <strong id="effectivePrice">￥<s:property value="model.totalPrices" /> 元</strong>
			</div>
			<div class="bottom">
				<a href="${ pageContext.request.contextPath }/cart/deleteAll.action" id="clear" class="clear">清空购物车</a> 
				<a href="${ pageContext.request.contextPath }/orders/submitOrder.action" id="submit" class="submit">提交订单</a>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${ pageContext.request.contextPath }/image/footer.jpg" width="950" height="52" alt="我们的优势"
					title="我们的优势" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>招贤纳士</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>服务声明</a> |</li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>