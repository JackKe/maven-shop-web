<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.user == null">
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="${pageContext.request.contextPath }/user/loginPage.action">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user/registPage.action">注册</a>|
					</li>
				</s:if>
				<s:else>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><s:property
							value="#session.user.name" />|</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a href="#">我的订单</a>|</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a href="${ pageContext.request.contextPath }/user/quit.action">退出</a>|</li>
				</s:else>

				<li><a>会员中心</a> |</li>
				<li><a>购物指南</a> |</li>
				<li><a>关于我们</a></li>
			</ul>
		</div>
		<div class="cart">
			<a href="${pageContext.request.contextPath }/cart/showCart.action">购物车</a>
		</div>
		<div class="phone">
			客服热线: <strong>96008/53277764</strong>
		</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
			<li><a href="${ pageContext.request.contextPath }/shop/index.action">首页</a> |</li>
			<s:iterator value="#session.categorys" var="category">
			<li><a href="${ pageContext.request.contextPath }/products/categoryall.action?pageIndex=0&cid=<s:property value="#category.cid" />"><s:property value="#category.cname"/> </a> |</li>
			</s:iterator>

		</ul>
	</div>

</body>
</html>