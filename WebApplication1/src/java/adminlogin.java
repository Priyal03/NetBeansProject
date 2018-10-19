import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class adminlogin extends HttpServlet
{
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
  PreparedStatement ps;
  ResultSet rs;
  Connection c;
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();
  try
    { 
      Class.forName("org.postgresql.Driver");
      c=DriverManager.getConnection("jdbc:postgresql:pranav","postgres","");
      String username= req.getParameter("user");
      String password=req.getParameter("pass");
       ps = c.prepareStatement("select * from admin where username = ? and pass= ?");
       ps.setString(1,username);
       ps.setString(2,password);
      rs = ps.executeQuery();
       pw.println("<html><body bgcolor=\"eed5ff\"> <form method=\"get\" action=\"http://localhost:8080/pranav/selectexam\">");
      if(rs.next())
      {
            pw.println("<center><h1>You have logged in successfully!!<h1></center><br><br>");
            pw.println("<center><a href=\"http://localhost:8080/servlets-examples/selectexam1\"><h3>You can select an exam!</h3></a></center>");
                                                                                                                            
                                                                                                                  
pw.println("<center><a href=http://localhost:8080/pranav/selectviewrep>VIEW REPORTS</center></a><br><br>");
 pw.println("<h2><i>To make changes in the question bank click on the following button</h2></i>");
pw.println("<center><input type=\"submit\" value=\"SELECT EXAM \"></center>");


      }
            else
       {
           pw.println("<center><h1>LOGIN FAILED!!</h1><br><br>");
           pw.println("<a href=\"http://localhost:8080/pranav/admin.html\">Retry</a></center>");

       }
      pw.println("</body></form></html>");
    ps.close();
           rs.close();
           c.close();
           }
           catch(Exception e)
           {
            pw.println(e);
            }
            }
            }
