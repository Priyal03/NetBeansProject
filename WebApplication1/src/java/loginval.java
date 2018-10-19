import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class loginval extends HttpServlet
{
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
  PreparedStatement ps,pr;
  ResultSet rs,result;
  Connection c;
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();
  try
    { 
      Class.forName("org.postgresql.Driver");
      c=DriverManager.getConnection("jdbc:postgresql:pranav","postgres","");
      String username= req.getParameter("user");
    //  HttpSession sess = req.getSession();
   //   sess.setAttribute("username",username);
      String password=req.getParameter("pass");
  //    sess.setAttribute("password",password);
       ps = c.prepareStatement("select * from valid where username = ? and pwd = ?");
       ps.setString(1,username);
       ps.setString(2,password);
      rs = ps.executeQuery();
      pw.println("<html><body bgcolor=eeeeee><form method=\"GET\" action=\"http://localhost:8080/pranav/selectexam.html\">");
      if(rs.next())
      {

            pw.println("<center>");
            pw.println("<br><br><br><h1>You have Logged in successfully!!<h1></center><br><br>");
            pw.println("<table cellspacing=4 cellpadding=4>");
	    pw.println("<tr><td><font size=5><h2><b>Some Rules before proceeding:</b></h3></td></tr>");
            pw.println("<tr><td><font size=3><h3>1)The examination consist of 3 subjects:</h3></td></tr>");
            pw.println("<tr><td><font size=3><h3>2)C,C++,Java and you have to attempt any one.</h3></td></tr>");
            pw.println("<tr><td><font size=3><h3>3)The passing criteria would be decided on the total of all the papers.</h3></td></tr>");
            pw.println("<tr><td><font size =3><h3><b>God Bless You....</b></h3></font></td></tr>");
            pw.println("</table>");
            pw.println("<br><br><br><br><center><input type=\"submit\" value=\"SELECT EXAM\"></font></center>");
            pw.println("<a href=\"http://localhost:8080/pranav/1.html\"><font size=4>LOGOUT</font></a>");
     }
      else
       {
           pw.println("<center><h1>LOGIN FAILED!!</h1><br><br>");
           pw.println("<a href=\"http://localhost:8080/pranav/1.html\"><font size=5><h2>Retry</h2></font></a></center>");
       }
      pw.println("</body></html>");
      ps.close();
      rs.close();
      c.close();
    }
           catch(Exception e) { pw.println(e); }
  }
 }
