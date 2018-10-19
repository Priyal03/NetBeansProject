<%-- 
    Document   : usebean
    Created on : Mar 26, 2014, 10:36:32 AM
    Author     : Kamlesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="u" scope="session" class="test.javabean" />
        <jsp:setProperty name="u" property="name" value="" />
        <jsp:getProperty name="u" property="name" />
       
        
    </body>
</html>
