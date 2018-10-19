import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;


 public class registration extends HttpServlet
       {
        public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
        try
        {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
         PreparedStatement ps;
         Connection c;
          try{
              Class.forName("org.postgresql.Driver");
              c = DriverManager.getConnection("jdbc:postgresql:pranav","postgres","");
              String user=req.getParameter("user");
              String first=req.getParameter("first");
              String last=req.getParameter("last");
              String city = req.getParameter("city");
              String mob=req.getParameter("mob");
              String gender=req.getParameter("gender");
              String email=req.getParameter("EMAIL");
              String pass=req.getParameter("pass");
              String repass=req.getParameter("repass");
              int f=1,f1=1,f2=1,f3=1,f4=1,f5=1,f6=1,f7=1,f8=1,f9=1;
              pw.println("<html><body bgcolor=\"ffb751\">");
              if(user.length()>9)
                f8=0;
              if(pass.length()>9)
                f9=0;
              for(int i=0;i<user.length();i++)
              {
 if(!(first.charAt(i)>='A' && first.charAt(i)<='Z' || first.charAt(i)>='a' && first.charAt(i)<='z') || first.length()==0)
                {
                  f8=0;
                  break;
                }
              }

              for(int i=0;i<first.length();i++)
              {
 if(!(first.charAt(i)>='A' && first.charAt(i)<='Z' || first.charAt(i)>='a' && first.charAt(i)<='z') || first.length()==0)
                {
                  f=0;  
                  break;
                }
              }
             for(int i=0;i<last.length();i++)
              {
    if(!(last.charAt(i)>='A' && last.charAt(i)<='Z' || last.charAt(i)>='a' && last.charAt(i)<='z'))
                {
                  f1=0;
                  break;
                }
              }

 
            for(int i=0;i<city.length();i++)
              {
    if(!(city.charAt(i)>='A' && city.charAt(i)<='Z' || city.charAt(i)>='a' && city.charAt(i)<='z'))
                {
                  f2=0;
                  break;
                }
              }
            int j=0;
            while(j<mob.length())
           {
            if(!(Character.isDigit(mob.charAt(j))))
             {
              f4=0;
              break;
             }
         
             j++;
           }
            String regex = "[a-z][a-z][0-9]+@[a-z0-9]+.[com|co.in]";

				if(email.matches(regex))
                         	{
				f5=0;
				}
   
	   for(int i=0,k=0;i<pass.length();i++,k++) 
           {
             if(pass.charAt(i)!=repass.charAt(k))
             {
               f6=0;
               break;
             }
           }			
          
          if(f==0||f1==0||f2==0||f4==0||f5==0||f6==0||f8==0||f9==0)
                pw.println("<blink>Error registering!!!</blink><br><br>");
          if(f==0)
                pw.println("<h3>.....Invalid first name!!</h3><br>");
          if(f1==0)
                pw.println("<h3>.....Invalid last name!!</h3><br>");
          if(f2==0)
                pw.println("<h3>.....Invalid city name!!</h3><br>");
          if(f4==0)
                pw.println("<h3>.....Invalid mobile!!</h3><br>");
          if(f5==0)
                pw.println("<h3>.....Invalid email-id!!</h3><br>");
          if(f6==0)
                pw.println("<h3>.....Your password and Retype password does not match!!</h3><br>");
          if(f8==0)
                pw.println("<h3>.....Invalid Username!!!</h3><br>");
          if(f9==0)
                pw.println("<h3>.....The password length should be minimum of 6 characters!!</h3><br>");
          
           if(f==0||f1==0||f2==0||f4==0||f5==0||f6==0||f8==0||f9==0)
             {
          pw.println("<center><a href=\"http://localhost:8080/pranav/REGISTRATION.html\">Dont Be OverSmart!</a></center><br>");
             }
           
            if(f==1 && f1==1 && f2==1 &&  f4==1 && f8==1 && f9==1)
            {
            ps = c.prepareStatement("insert into valid values(?,?,?,?,?,?,?,?)");
            ps.setString(1,user);
            ps.setString(2,first);
            ps.setString(3,last);
            ps.setString(4,city);
            ps.setString(5,mob);
            ps.setString(6,gender);
            ps.setString(7,pass);
            ps.setString(8,repass);
            
            ps.executeUpdate();
            ps.close();
            pw.println("<center><h2><br>You have been registered to our site!</h2><br>");
            pw.println("<font size=8>And Now You Can Login !!</font><br><br>");
            pw.println("<a href=\"http://localhost:8080/pranav/1.html\">LOGIN</a>");
            pw.println("</center>");
            }
           c.close();
       }

       catch(Exception e)
       {
        pw.println(e);
       }
  }catch(Exception e){}
}
}
