<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<base href="">
    <div class="page-sidebar">
        <div class="sidebar-menugroup">
            <div class="sidebar-grouptitle">个人中心</div>
            <ul class="sidebar-menu">
                <li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
                <li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
                <li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
            </ul>
        </div>
        <div class="sidebar-menugroup">
            <div class="sidebar-grouptitle">人员管理</div>
            <ul class="sidebar-menu">
                <li class="sidebar-menuitem"><a href="register">员工注册</a></li>
            <c:if test="${user.role==1}">
                <li class="sidebar-menuitem"><a href="admin/departments">部门管理</></li>
                <li class="sidebar-menuitem"><a href="admin/approveaccount">注册审批</a></li>
                <li class="sidebar-menuitem"><a href="admin/searchemployees">搜索员工</a></li>
            </c:if>
            </ul>
        </div>
        <div class="sidebar-menugroup">
            <div class="sidebar-grouptitle">会议预定</div>
            <ul class="sidebar-menu">
            <c:if test="${user.role==1}">
                <li class="sidebar-menuitem"><a href="admin/addmeetingroom.jsp">添加会议室</a></li>
            </c:if>
                <li class="sidebar-menuitem"><a href="meetingrooms">查看会议室</a></li>
                <li class="sidebar-menuitem"><a href="bookmeeting">预定会议</a></li>
                <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
            </ul>
        </div>
    </div>