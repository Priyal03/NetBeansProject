
package dbms;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect 
{
    private Connection cn;
    public Connection getConnect()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
        return cn;
    }
}
