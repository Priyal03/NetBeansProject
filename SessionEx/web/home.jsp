<%-- 
    Document   : home
    Created on : Mar 4, 2014, 10:43:03 AM
    Author     : Dhwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("abc")==null)
                response.sendRedirect("index.jsp");
        %>
        <h1>Welcome</h1>
        <a href="logout">Logout</a>
    </body>
</html>
