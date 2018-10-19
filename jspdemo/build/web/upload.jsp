<%-- 
    Document   : upload
    Created on : Mar 19, 2014, 6:47:32 PM
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
        <form action="uploadserv" method="post" enctype="multipart/form-data">
        <h1>Hello World!</h1>
        <input type="file" name="userimg"><br>
        <input type="submit" value="Submit">
        </form>
    </body>
</html>
