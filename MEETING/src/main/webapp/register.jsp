<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
       <%@ include file="head.jsp"%>
        <div class="page-body">
            <%@ include file="leftMenu.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 员工注册
                </div>
                <form action="doRegister" method="POST">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input value="${employees.employeename}" name="employeename" type="text" id="employeename" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input value="${employees.username}" name="username" type="text" id="accountname" maxlength="20"/>
                                    <div style="color: red;">${registerErr}</div>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input value="${employees.password}" name="password" type="password" id="password" maxlength="20" placeholder="请输入6位以上的密码"/>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input name="rePassword" type="password" id="confirm" maxlength="20" onchange="check()"/>
                                    <div style="color: red;" id="confirmInfo"></div>
                                </td>
                                 
                            </tr>
                           
                            <tr>
                                <td>联系电话：</td>
                                <td>    
                                    <input value="${employees.phone}" name="phone" type="text" id="phone" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input value="${employees.email}" name="email" type="text" id="email" maxlength="20"/>
                                </td>
                            </tr>
							<td>所在部门：</td>
                                <td>
                                    <select name="departmentid">
                                        <c:forEach items="${deps}" var="dep">
                                            <option value="${dep.departmentid}">${dep.departmentname}</option>
                                        </c:forEach>
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="注册"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
    <script>
        function check() {
            var password=document.getElementById("password");
            var confirm=document.getElementById("confirm");
            var confirmInfo=document.getElementById("confirmInfo");
            if (password.value!=confirm.value) {
                confirmInfo.textContent="两次密码不一致"
            }else{
                confirmInfo.textContent=""
            }
        }
    </script>
</html>