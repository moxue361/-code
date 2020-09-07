<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
    </head>

    <body>
        <% request.setAttribute("key","123"); %>
            <%= request.getAttribute("key")%>
                ${key}
                <%= 99%>

                    不是吧这也行？？
    </body>

    </html>