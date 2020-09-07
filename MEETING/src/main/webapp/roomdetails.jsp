<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>ss
<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <%@ include file="head.jsp"%>
        <div class="page-body">
            <%@ include file="leftMenu.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议室信息
                </div>
                <form action="admin/updateRoom" method="POST">
                    <input type="hidden" name="roomid" value="${room.roomid}">
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input name="roomnum" id="roomnumber" type="text" value="${room.roomnum}" maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input name="roomname" id="capacity" type="text" value="${room.roomname}" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input name="capacity" id="capacity" type="text" value="${room.capacity}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>

                                <td>
                                <c:if test="${room.status==1}">
                                    <input type="radio" id="status1" name="status" checked="checked" value="1"/><label for="status1">启用</label>
                                    <input type="radio" id="status0" name="status" value="0"/><label for="status0">已占用</label>
                                </c:if>
                                <c:if test="${room.status==0}">
                                    <input type="radio" id="status1" name="status"  value="1"/><label for="status1">启用</label>
                                    <input type="radio" id="status0" name="status" checked="checked" value="0"/><label for="status0" >已占用</label>
                                </c:if>
                                    
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea name="description" id="description" maxlength="200" rows="5" cols="60" >${room.description}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
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
</html>