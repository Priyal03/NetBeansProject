<%-- 
    Document   : errorchk
    Created on : Mar 26, 2014, 9:17:15 AM
    Author     : Kamlesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%= 1/0 %>
    </body>
</html>
