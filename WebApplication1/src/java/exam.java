import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class exam extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)
  {
     
       PrintWriter pw=null;
       resp.setContentType("text/html");
       Connection c=null;
       int qno=-1,x;
       String etype=null;
       HttpSession session=req.getSession(true);
      
       try
       {
         etype=req.getParameter("etype");
       }catch(Exception e)
        {etype=session.getAttribute("etype").toString();}
      
       try
       {
          pw=resp.getWriter();
          pw.println("<html><body>"+"<form action=\"http://localhost:8080/pranav/abc\""+"method=get>");
          Class.forName("org.postgresql.Driver");
          c=DriverManager.getConnection("jdbc:postgresql:pranav","postgres","");
       }catch(Exception e){System.out.println("DB problem"+e);}

       try
       {
         qno=Integer.parseInt(session.getAttribute("qno").toString());
       }catch(Exception e){System.out.println("Session "+e);}

       try
       {
         String ans=req.getParameter("ans");
         if(ans!=null)
         {
               PreparedStatement ps=c.prepareStatement("insert into uans values(?,?)");
               ps.setInt(1,qno);
               ps.setString(2,ans);
               x=ps.executeUpdate();
         }

       }catch(Exception e){System.out.println("insert "+e);}
       
      try
      {
          if(qno==-1)
             qno=1;
          PreparedStatement ps=null;
          if(etype.equals("c"))
          {
             ps=c.prepareStatement("select * from cexam where qno=?");
             ps.setInt(1,qno);
             ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                  pw.println("<h2>"+rs.getInt(1)+" "+rs.getString(2)+"<br>");
                  pw.println("<input type=radio name=ans value=a1>A</input>"+rs.getString(3)+"<br>");
                  pw.println("<input type=radio name=ans value=a2>B</input>"+rs.getString(4)+"<br>");
                  pw.println("<input type=radio name=ans value=a3>C</input>"+rs.getString(5)+"<br>");
                  pw.println("<input type=radio name=ans value=a4>D</input>"+rs.getString(6)+"<br>");
                  pw.println("<br><input type=submit value=next>"); 
                  pw.println("</form></body></html>");
            } 
            session.setAttribute("qno",Integer.toString(qno));
            session.setAttribute("etype",etype);
            qno++;
         }
         else if(etype.equals("cpp"))
         {
             ps=c.prepareStatement("select * from cppexam where qno=?");
             ps.setInt(1,qno);
             ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                  pw.println("<h2>"+rs.getInt(1)+" "+rs.getString(2)+"<br>");
                  pw.println("<input type=radio name=ans value=a1>A</input>"+rs.getString(3)+"<br>");
                  pw.println("<input type=radio name=ans value=a2>B</input>"+rs.getString(4)+"<br>");
                  pw.println("<input type=radio name=ans value=a3>C</input>"+rs.getString(5)+"<br>");
                  pw.println("<input type=radio name=ans value=a4>D</input>"+rs.getString(6)+"<br>");
                  pw.println("<br><input type=submit value=next>");
                  pw.println("</form></body></html>");
            }
            qno++;
            session.setAttribute("qno",Integer.toString(qno));
            session.setAttribute("etype",etype);

         }
      }catch(Exception e){System.out.println("select "+e);}
 }
}

