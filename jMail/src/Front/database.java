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
            pst.setString(1, u);
            pst.setString(2, pa);            
            rs=pst.executeQuery();
            return rs.next();
        } 
        catch (SQLException e) 
        {          
            System.out.println("error while validating"+e);
            return false;
        }
    }
}
