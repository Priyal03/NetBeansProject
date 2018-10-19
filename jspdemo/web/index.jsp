<%-- 
    Document   : index
    Created on : Feb 25, 2014, 9:20:47 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login!</h1>
        <form name="f1" action="page_hit" method="get">
            Enter Username:<input type="text" id="fname" name="fname" value="" />
            Enter Password:<input type="password" name="upass" value="" />
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
