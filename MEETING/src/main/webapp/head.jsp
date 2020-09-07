<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <div class="header-banner">
        <img src="images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Cool-Meeting会议管理系统
    </div>
    <div class="header-quicklink">
        <c:if test="${not empty user.username}">
           <strong> 欢迎您，${user.employeename}</strong><a href="changepassword.jsp">[修改密码]</a>
        </c:if>
    </div>
</div>
