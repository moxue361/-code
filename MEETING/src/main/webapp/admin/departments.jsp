<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/MEETING/">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <%@ include file="/head.jsp"%>
        <div class="page-body">
            <%@ include file="/leftMenu.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form method="POST" action="admin/addDep">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input name="departmentname" type="text" id="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${deps}" var="dep">
                        <tr>
                            <td>${dep.departmentid}</td>
                            <td id="${dep.departmentid}">${dep.departmentname}</td>
                            <td>
                                <input class="clickbutton" id="edit${dep.departmentid}" type="button" value="编辑" onclick="edit('${dep.departmentid}')">
                                <input style="display: none;" class="clickbutton" id="cancel${dep.departmentid}" type="button" value="取消" onclick="cancel('${dep.departmentid}','${dep.departmentname}')">
                                <a  href="admin/delDep?depId=${dep.departmentid}">删除</a>
                            </td>
                            
                        </tr>
                        
                    </c:forEach>
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
        function edit(depId) {
            var td=$("#"+depId);
            var editBtn=$("#edit"+depId);
            var cancelBtn=$("#cancel"+depId);
            if(cancelBtn.css("display")=="none"){
                editBtn.val("确定");
                cancelBtn.css("display","inline");  
                td.html('<input type="text" value='+td.text()+'>');
            }else{
                var val = td.children('input').val();
                $.post("admin/updateDep",{id:depId,name:val},function(msg){
                    if(msg=="success"){
                        editBtn.val("编辑");
                        cancelBtn.css("display","none");
                        td.html(val);
                    }
                    else{
                        alert("输入有误");
                    }
                },"text")
            }
        }   
        function cancel(depId,depName) {
            var td=$("#"+depId);
            var editBtn=$("#edit"+depId);
            var cancelBtn=$("#cancel"+depId);
            editBtn.val("编辑");
            cancelBtn.css("display","none");  
            td.html(depName);
           
        }   
    </script>
</html>