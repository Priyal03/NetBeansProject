<%-- 
    Document   : Login
    Created on : Mar 26, 2014, 9:33:42 AM
    Author     : Priyal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
        
        <br><br>
        UserName : <input type="text" name="uname" value="" size="10" /><br><br>
        Password : <input type="password" name="pass" value="" size="10" /><br><br>
        <input type="submit" value="Login"/><br><br>
        or
        <a href="index.jsp">Register Here!!!</a>
        </form>
    </body>
</html>
