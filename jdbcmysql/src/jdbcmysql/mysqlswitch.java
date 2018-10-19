/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcmysql;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class mysqlswitch {

    public static void main(String[] args) {
        // TODO code application logic here
        Connection con;
        Statement st;
        ResultSet rs;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");

            st = con.createStatement();
            //
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
            System.out.println("Enter Your Choice\n1.Insert\n2.update\n3.delete\n4.select\n5.create db\n6.create table");
            int ch = Integer.parseInt(br.readLine());
            int chngs;

switch(ch){
    case 1:
       chngs=st.executeUpdate("insert into test values(3,'kamlesh')");
        System.out.println("affected rows::"+chngs);
        break;
    case 2:
        chngs=st.executeUpdate("update test set name='kc' where id=1");
        System.out.println("affected rows::"+chngs);
        break;
    case 3:
        chngs=st.executeUpdate("delete from test where id=3");
        System.out.println("affected rows::"+chngs);
        break;
    case 4:
        rs = st.executeQuery("Select * from test");
        while (rs.next()) {
                //System.out.println("xyz");
                System.out.println("Id:" + rs.getInt("id"));
                System.out.println("Name:" + rs.getString("name"));
            }
        break;
    case 5:
       // chngs=st.executeUpdate("drop DATABASE kc");
        chngs=st.executeUpdate("CREATE DATABASE kc");
        System.out.println("affected rows::"+chngs);
        break;
    case 6:
        //chngs=st.executeUpdate("drop table kc1");
        chngs=st.executeUpdate("CREATE table kc.kc1(id int(10),name varchar(10))");
        System.out.println("affected rows::"+chngs);
        break;
    default:

}
            }
            
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }
}
