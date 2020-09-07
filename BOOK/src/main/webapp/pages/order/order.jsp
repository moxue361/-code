<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="http://localhost:8080/BOOK/">
<meta charset="UTF-8">
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<div>
				<!-- 如果用户没有登录 -->
				<c:if test="${empty sessionScope.user}">
				<a href="pages/user/login.jsp">登录</a> | 
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>

				<!-- 已经已经登录 -->
				<c:if test="${not empty sessionScope.user}">
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
				<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
				</c:if>

				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<tr>
				<td>2015.04.23</td>
				<td>90.00</td>
				<td>未发货</td>
				<td><a href="#">查看详情</a></td>
			</tr>	
			
			<tr>
				<td>2015.04.20</td>
				<td>20.00</td>
				<td>已发货</td>
				<td><a href="#">查看详情</a></td>
			</tr>	
			
			<tr>
				<td>2014.01.23</td>
				<td>190.00</td>
				<td>已完成</td>
				<td><a href="#">查看详情</a></td>
			</tr>		
		</table>
		
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>