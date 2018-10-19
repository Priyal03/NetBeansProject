<%-- 
    Document   : test
    Created on : Mar 27, 2014, 2:43:04 AM
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
        <form action="test1" method="POST">
            <input type="submit" value="submit" name="s1" />
        </form>


        <% int msg = (int) response.getStatus();
            response.reset();
            if (msg == 200) {
                out.print("successssssssss");
            } else {
                out.print("abc");
            }
        %>
        <!--<c:remove var="test" scope="request" />-->
        
    </body>
</html>
