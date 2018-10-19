package dbms;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db
{
    private final Connection con;
    private PreparedStatement ps;
    private Statement st;
    public db()
    {
        Connect c=new Connect();
        con=c.getConnect();
    }
    public static Timestamp getTimestamp()
    {
        Date d=new Date();
        return new Timestamp(d.getTime());
    }
    public static Time getTime()
    {
        Date d=new Date();
        return new Time(d.getTime());
    }
    public void Insert(String tb,ArrayList<Object> al)
    {
        try 
        {
            String str="insert into "+tb+" values(NULL,";
            for(int i=0;i<al.size();i++)
                str+="?,";
            str=str.substring(0, str.length()-1);
            str+=")";            
            ps=con.prepareStatement(str);
            for(int i=0;i<al.size();i++)
            {
                String s=al.get(i).toString();
                if(s.equalsIgnoreCase("CURRENT_TIMESTAMP"))
                {
                    Timestamp t=getTimestamp();
                    ps.setTimestamp(i+1, t);
                }
                else
                {
                    s=(al.get(i).getClass()).toString();
                    s=s.replaceAll("class java.lang.", "");
                    System.out.println(s);
                    if(s.equals("Long"))
                       ps.setLong(i+1, (Long)al.get(i));
                    else if(s.equals("Integer"))
                       ps.setInt(i+1, (Integer)al.get(i));
                    else if(s.equals("Float"))
                       ps.setFloat(i+1, (Float)al.get(i));
                    else if(s.equals("Double"))
                       ps.setDouble(i+1, (Double)al.get(i));
                    else if(s.equals("String"))
                       ps.setString(i+1, al.get(i).toString());
                }                
            }
            System.out.println(ps.toString());
            if(ps.executeUpdate()==1)
                System.out.println("Succesful");
            else
                System.out.println("failed");
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Insert(String tb,ArrayList<Object> al,String a)
    {
        try 
        {
            String str="insert into "+tb+" values(";
            for(int i=0;i<al.size();i++)
                str+="?,";
            str=str.substring(0, str.length()-1);
            str+=")";            
            ps=con.prepareStatement(str);
            for(int i=0;i<al.size();i++)
            {
                String s=al.get(i).toString();
                if(s.equalsIgnoreCase("CURRENT_TIMESTAMP"))
                {
                    Timestamp t=getTimestamp();
                    ps.setTimestamp(i+1, t);
                }
                else if(s.length()<1)
                {
                    ps.setObject(i+1, null);
                }
                else
                {
                    s=(al.get(i).getClass()).toString();
                    s=s.replaceAll("class java.lang.", "");
                    System.out.println(s);
                    if(s.equals("Long"))
                       ps.setLong(i+1, (Long)al.get(i));
                    else if(s.equals("Integer"))
                       ps.setInt(i+1, (Integer)al.get(i));
                    else if(s.equals("Float"))
                       ps.setFloat(i+1, (Float)al.get(i));
                    else if(s.equals("Double"))
                       ps.setDouble(i+1, (Double)al.get(i));
                    else if(s.equals("String"))
                       ps.setString(i+1, al.get(i).toString());
                }                
            }
            System.out.println(ps.toString());
            if(ps.executeUpdate()==1)
                System.out.println("Succesful");
            else
                System.out.println("failed");
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet Total(String tb)
    {
        try 
        {
            st=con.createStatement();
            ResultSet res = st.executeQuery("select count(*) from "+tb);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Query(String sql)
    {
        try 
        {
            st=con.createStatement();
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb)
    {
        try 
        {
            st=con.createStatement();
            ResultSet res = st.executeQuery("select * from "+tb);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb,String tb2,String p1,String p2)
    {
        try 
        {
            st=con.createStatement();
            ResultSet res = st.executeQuery("select * from "+tb+" left join "+tb2+" on "+tb+"."+p1+"="+tb2+"."+p2);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb,String n_id,int id)
    {
        try 
        {
            st=con.createStatement();
            String s="select * from "+tb+" where "+n_id+"="+id;
            ResultSet res = st.executeQuery(s);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb,String field,String value)
    {
        try 
        {
            st=con.createStatement();
            String s="select * from "+tb+" where "+field+"="+value+"";
            //System.out.println(s);
            ResultSet res = st.executeQuery(s);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb,String tb2,String p1,String order,String field)
    {
        try 
        {
            st=con.createStatement();
            String sql="select * from "+tb+" left join "+tb2+" on "+tb+"."+p1+"="+tb2+"."+p1+" order by "+field+" "+order;
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb,String tb2,String p1,String p2,String order,String field)
    {
        try 
        {
            st=con.createStatement();
            String sql="select * from "+tb+" left join "+tb2+" on "+tb+"."+p1+"="+tb2+"."+p2+" order by "+field+" "+order;
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Select(String tb,String tb2,String p1,String p2,String fld,String value,String order,String field)
    {
        try 
        {
            st=con.createStatement();
            String sql="select * from "+tb+" left join "+tb2+" on "+tb+"."+p1+"="+tb2+"."+p2+" where "+fld+"="+value+" order by "+field+" "+order;
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void Delete(String tb,int id)
    {
        try 
        {
            st=con.createStatement();
            ResultSet res = st.executeQuery("SHOW KEYS FROM "+tb+" WHERE Key_name = 'PRIMARY'");
            res.next();
            String n=res.getString(5);
            String str="delete from "+tb+" where "+n+"="+id;
            System.out.println(str);
            ps=con.prepareStatement(str);
            if(ps.executeUpdate(str)==1)
                System.out.println("Delete Successful");
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update(String tb,int id,ArrayList<Object> al)
    {
        ResultSet res=null;
        try 
        {
            st=con.createStatement();
            res = st.executeQuery("describe "+tb);
            String q="update "+tb+" set ";
            String qq="";
            while(res.next())
            {
                if(res.isFirst())
                    qq=" where "+res.getString(1)+"="+id;
                else
                    q+=res.getString(1)+"=?, ";
            }
            q=q.substring(0, q.length()-2);
            q+=qq; 
            ps=con.prepareStatement(q);
            for(int i=0;i<al.size();i++)
            {
                String s=al.get(i).toString();
                s=(al.get(i).getClass()).toString();
                s=s.replaceAll("class java.lang.", "");
                //System.out.println(s);
                if(s.equals("Long"))
                   ps.setLong(i+1, (Long)al.get(i));
                else if(s.equals("Integer"))
                   ps.setInt(i+1, (Integer)al.get(i));
                else if(s.equals("Float"))
                   ps.setFloat(i+1, (Float)al.get(i));
                else if(s.equals("Double"))
                   ps.setDouble(i+1, (Double)al.get(i));
                else if(s.equals("String"))
                   ps.setString(i+1, al.get(i).toString());               
                //System.out.println(ps.toString());
            }
            System.out.println(ps.toString());
            if(ps.executeUpdate()==1)
                System.out.println("Succesful");
            else
                System.out.println("failed");
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update(String tb,int id,String field,Object value)
    {
        ResultSet res=null;
        try 
        {
            st=con.createStatement();
            res = st.executeQuery("SHOW KEYS FROM "+tb+" WHERE Key_name = 'PRIMARY'");
            res.next();
            String n=res.getString(5);
            String q="update "+tb+" set "+field+"=? where "+n+"="+id;
            ps=con.prepareStatement(q);
            String s=value.toString();
            s=(value.getClass()).toString();
            s=s.replaceAll("class java.lang.", "");
            //System.out.println(s);
            if(s.equals("Long"))
               ps.setLong(1, (Long)value);
            else if(s.equals("Integer"))
               ps.setInt(1, (Integer)value);
            else if(s.equals("Float"))
               ps.setFloat(1, (Float)value);
            else if(s.equals("Double"))
               ps.setDouble(1, (Double)value);
            else if(s.equals("String"))
               ps.setString(1, value.toString());               
            System.out.println(ps.toString());
            if(ps.executeUpdate()==1)
                System.out.println("Succesful");
            else
                System.out.println("failed");
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet Select(String tb,String tb2,String p1,String p2,String order,String field,int ind,int r)
    {
        try 
        {
            st=con.createStatement();
            String sql="(select * from "+tb+" left join "+tb2+" on "+tb+"."+p1+"="+tb2+"."+p2+" limit "+ind+", "+r+") order by "+field+" "+order;
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
            return res;
        } 
        catch (Exception ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
