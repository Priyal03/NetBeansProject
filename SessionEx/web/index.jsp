<%-- 
    Document   : index
    Created on : Mar 4, 2014, 10:23:27 AM
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
            if(request.getParameter("error")!=null)
                out.println("<h3>Incorrect username and password combination</h3>");
            if(session.getAttribute("abc")!=null)
                response.sendRedirect("home.jsp");
        %>
        <form action="login" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User</td>
                        <td><input type="text" name="user" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Submit" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
