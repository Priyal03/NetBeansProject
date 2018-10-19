/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con;
        Statement st;
        ResultSet rs;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
            
            st = con.createStatement();
            rs = st.executeQuery("Select * from test");
            
            while (rs.next()) {
               //System.out.println("xyz");
                System.out.println("Id:" + rs.getInt("id"));
                System.out.println("Name:" + rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }
}
