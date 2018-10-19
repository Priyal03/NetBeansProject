<%-- 
    Document   : index
    Created on : Mar 26, 2014, 9:13:33 AM
    Author     : Priyal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <body>

        <form action="Register" method="POST">Name :     
            <input type="text" name="name" value="" size="10" /><br><br>
            UserName : <input type="text" name="uname" value="" size="10" /><br><br>
            Password : <input type="password" name="pass" value="" size="10" /><br><br>
            Age :    <input type="text" name="age" value="" size="2" /><br><br>
            City :   <select name="city">
                <option>Vapi</option>
                <option>Rajkot</option>
                <option>Vadodara</option>
                <option>Surat</option>
            </select><br><br>
            Gender :    
            Male <input type="radio" name="gen" value="Male" />
            Female <input type="radio" name="gen" value="Female" /><br><br>
            Contact No :     <input type="text" name="contact" value="" size="10" /><br><br>
            <input type="submit" value="Submit" /> or
            <input type="reset" value="Reset" />
        </form>
        
    </body>
</html>
