<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.sql.*"%>

<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="myds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/db" user="root" password=""/>
        <sql:query dataSource="${myds}" var="resultset">
            select * from login;
        </sql:query>
            <table border="1">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${resultset.rows}">
                    <tr>
                        <td><c:out value="${row.uname}"/></td>
                        <td><c:out value="${row.upass}"/></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

    </body>
</html>
