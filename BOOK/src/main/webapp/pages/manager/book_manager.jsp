<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="http://localhost:8080/BOOK/">
<meta charset="UTF-8">
<title>图书管理</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="pages/manager/book_manager.jsp">图书管理</a>
				<a href="pages/manager/order_manager.jsp">订单管理</a>
				<a href="index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.pageList}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
					<td><a href="manager/bookServlet?action=remove&id=${book.id}">删除</a></td>
				</tr>	
			</c:forEach>		
			
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add&pageNow=${requestScope.page.pageCount}">添加图书</a></td>
			</tr>	
		</table>
	</div>
	
	<div id="page_nav">
		<c:if test="${requestScope.page.pageNow > 1}">
		<a href="manager/bookServlet?action=page&pageNow=1">首页</a>
		<a href="manager/bookServlet?action=page&pageNow=${requestScope.page.pageNow-1}">上一页</a>
		</c:if>
		
		【${requestScope.page.pageNow}】

		<c:if test="${requestScope.page.pageNow < requestScope.page.pageCount}">
		<a href="manager/bookServlet?action=page&pageNow=${requestScope.page.pageNow+1}">下一页</a>
		<a href="manager/bookServlet?action=page&pageNow=${requestScope.page.pageCount}">末页</a>
		</c:if>
		共${requestScope.page.pageCount}页，${requestScope.page.recordCount}条记录 到第<input value="${requestScope.page.pageNow}" name="pn" id="pn_input"/>页
		<input id="searchPage" type="button" value="确定">
	</div>

	<script src="static/script/jquery-1.7.2.js"></script>
<script>
	$(function(){
		$("#searchPage").click(function(){
			var toPage=$("#pn_input").val();
			location.href="http://localhost:8080/BOOK/manager/bookServlet?action=page&pageNow="+toPage;
		});
	});
		
</script>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>