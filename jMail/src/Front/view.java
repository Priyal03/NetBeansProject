package Front;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Priyal
 */
public class view 
{
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        Connection conn;
        String sql;
        String eid[]=new String[20];
        String uname[]=new String[20];
        String other[]=new String[20];     
        Class.forName("com.mysql.jdbc.Driver");
        
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gc","root","");
        try 
        {
            sql = "select uid,un,oth from page1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            for(int i=0;i<3;i++)
            {
                while( rs.next() )
                {
                    eid[i]=rs.getString("uid");
                    uname[i]=rs.getString("un");
                    other[i]=rs.getString("oth");
                }
            }
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        conn.close();
    }
} 