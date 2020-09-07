<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
    </head> 
    <body>
        <h1 align="center">九九乘法表</h1>
        <table align="center" width="700p" >
        <% for(int i=1;i<10;i++){ %>
            <tr>
            <% for(int j=1;j<=i;j++){ %> 
                <td><%=j + "x" + i +"=" + (i*j) %></td>
            
            <%  }  %>

            </tr>
        <%
            } 
        %>   
    </table>
    </body>

    </html>