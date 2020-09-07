<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <base href="http://localhost:8080/MEETING/">
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">   
        </style>
    </head>
    <body>
        <%@ include file="/head.jsp"%>
        <div class="page-body">
            <%@ include file="/leftMenu.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索员工
                </div>
                <form id="form">
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input name="employeename" type="text" id="employeename" maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input name="username" type="text" id="accountname" maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status" value="1" checked="checked"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="查询" onclick="search(1)"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number"></span>条结果，
                            分成<span class="info-number"></span>页显示，
                            当前第<span class="info-number"></span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页"/>
                            <input type="button" class="clickbutton" value="上页"/>
                            <input type="button" class="clickbutton" value="下页"/>
                            <input type="button" class="clickbutton" value="末页"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转" onclick="goPage()"/>
                        </div>
                    </div>
                </div>
                <table id="empsTable" class="listtable">
                    <!-- <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr> -->
                   <!-- <c:forEach items="${pageInfo}" var="emp">
                       <tr>
                           <td>${emp.employeename}</td>
                           <td>${emp.username}</td>
                           <td>${emp.phone}</td>
                           <td>${emp.email}</td>
                           <td>
                               <a class="clickbutton" href="#">关闭账号</a>
                           </td>
                       </tr>
                   </c:forEach> -->
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
    <script src="jquery-1.7.2.js"></script>
    <script>
        $(function(){
            search(1);
        });
        function goPage(){
            var num=$("#pagenum").val();
            var max=$(".info-number")[1].innerText;
            if(num>max || num<1)alert("页数错误");
            else search(num);
            
        }
        function search(page) {
            $.post("admin/search?page="+page,$("#form").serialize(),function(pageInfo){
                $(".info-number")[0].innerText=pageInfo.total;
                $(".info-number")[1].innerText=pageInfo.pages;
                $(".info-number")[2].innerText=pageInfo.pageNum;
                $(".header-nav input")[0].onclick=function(){search(pageInfo.navigateFirstPage);}
                $(".header-nav input")[1].onclick=function(){search(pageInfo.prePage);}
                $(".header-nav input")[2].onclick=function(){search(pageInfo.nextPage);}
                $(".header-nav input")[3].onclick=function(){search(pageInfo.navigateLastPage);}
                var empsTable=$("#empsTable");
                empsTable.empty();
                empsTable.prepend($("<tr class='listheader'><th>姓名</th><th>账号名</th><th>联系电话</th><th>电子邮件</th><th>操作</th></tr>"))
                for (let i = 0; i < pageInfo.list.length; i++) {
                    const emp = pageInfo.list[i];                    
                    var ele=$("<tr><td>"+emp.employeename+"</td><td>"+emp.username+"</td><td>"+emp.phone+"</td><td>"+emp.email+"</td><td><a class='clickbutton' href='admin/removeEmp?id="+emp.employeeid+"'>关闭账号</a></td></tr>");
                    empsTable.append(ele);
                }
            },"json"
                )
        }
    </script>
</html>