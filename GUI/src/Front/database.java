package Front;
import java.sql.*;
public class database 
{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    database()
    {
        try
        {
             
            //MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib folder
            //ALSO SET THE CLASSPATH
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gc","root","");
                        pst=con.prepareStatement("select uid,pass from page1 where uid=? and pass=?");
             
           }
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e);
        }
    }
        //ip:username,password
        //return boolean
    public Boolean checkLogin(String u,String pa)
    {
        try 
        {
            pst.setString(1, u); //this replaces the 1st  "?" in the query for username
            pst.setString(2, pa);    //this replaces the 2st  "?" in the query for password
            //executes the prepared statement
            rs=pst.executeQuery();
            return rs.next();
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
    }
}
