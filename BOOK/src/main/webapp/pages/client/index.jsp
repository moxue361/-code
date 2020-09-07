<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="http://localhost:8080/BOOK/">
<meta charset="UTF-8">
<title>书城首页</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<!-- 如果用户没有登录 -->
				<c:if test="${empty sessionScope.user}">
				<a href="pages/user/login.jsp">登录</a> | 
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>

				<!-- 已经已经登录 -->
				<c:if test="${not empty sessionScope.user}">
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
				</c:if>

				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="GET">
					<input type="hidden" name="pageNow" value="${requestScope.page.pageNow}">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value=""> 元 - 
						<input id="max" type="text" name="max" value=""> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>
			<c:forEach items="${requestScope.page.pageList}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button>加入购物车</button>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<div id="page_nav">
			<c:if test="${requestScope.page.pageNow > 1}">
			<a href="client/bookServlet?action=page&pageNow=1">首页</a>
			<a href="client/bookServlet?action=page&pageNow=${requestScope.page.pageNow-1}">上一页</a>
			</c:if>
			
			【${requestScope.page.pageNow}】
	
			<c:if test="${requestScope.page.pageNow < requestScope.page.pageCount}">
			<a href="client/bookServlet?action=page&pageNow=${requestScope.page.pageNow+1}">下一页</a>
			<a href="client/bookServlet?action=page&pageNow=${requestScope.page.pageCount}">末页</a>
			</c:if>
			共${requestScope.page.pageCount}页，${requestScope.page.recordCount}条记录 到第<input value="${requestScope.page.pageNow}" name="pn" id="pn_input"/>页
			<input id="searchPage" type="button" value="确定">
		</div>
	
		<script src="static/script/jquery-1.7.2.js"></script>
	<script>
		$(function(){
			$("#searchPage").click(function(){
				var toPage=$("#pn_input").val();
				location.href="http://localhost:8080/BOOK/client/bookServlet?action=page&pageNow="+toPage;
			});
		});
			
	</script>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>