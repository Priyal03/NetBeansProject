<%-- 
    Document   : Att
    Created on : Mar 3, 2014, 12:48:15 PM
    Author     : Priyal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title> Attachment </title>
    </head>
    <body>
        <form action="Att.jsp" method="POST">
            <table border="0" align="left" cellpadding="5">
                <tbody>
                    <thead><tr> <td colspan="3" align="center">
                    <b> Attachment </b> </td> </tr> </thead>
                    <tr>
                        <td> To </td> <td> : </td>
                        <td> <input type="text" name="to" value="" /> </td>
                    </tr>
                    <tr>
                        <td> Subject </td> <td> : </td>
                        <td> <input type="text" name="subject" value="" /> </td>
                    </tr>
                    <tr>
                        <td> Message </td> <td> : </td>
                        <td> <textarea name="message" rows="8" cols="30">
                        </textarea></td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center">
                        <input type="submit" value="Send Mail" />
                              
                        <input type="reset" value="Reset" />
                        <td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
