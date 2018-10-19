<%-- 
    Document   : statejsp
    Created on : Jun 15, 2013, 1:32:41 AM
    Author     : dhwani
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
            RequestDispatcher rd=request.getRequestDispatcher("state");
            rd.include(request, response);
        %>
    </body>
</html>
