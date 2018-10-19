import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class exam1 extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)
  {
     
       PrintWriter pw=null;
       resp.setContentType("text/html");
       Connection c=null;
       int qno=0,x,q=0;
       String etype=null;
       HttpSession session=req.getSession(true);
      
      try
      {
                 pw=resp.getWriter();
         	 Class.forName("org.postgresql.Driver");
       	  	 c=DriverManager.getConnection("jdbc:postgresql:pranav","postgres","");
        	 Cookie cook[]=req.getCookies();
          	if(cook!=null)
          	{
            		   
            		q=Integer.parseInt(cook[0].getValue());
            		q++;  
          	}
         	Cookie ck=new Cookie("q",Integer.toString(q));
	         resp.addCookie(ck);
          
        	  if(q<1)
          	  {
                	qno=1;
	                etype=req.getParameter("etype");
                        session.setAttribute("etype",etype);
        	  }
           	else
          	 {
                	 etype=session.getAttribute("etype").toString();
                	 qno=Integer.parseInt(session.getAttribute("qno").toString());
                 	qno++;
           	 }
          
      		   PreparedStatement ps=null;
          	   pw.println("<html><body><form action=\"http://localhost:8080/pranav/pqr\""+"method=get>");
     
               
                   if(etype.equals("c"))
        	   {
                        if(q==3)
	                {
        	            for(int k=0;k<cook.length;k++)
                	       cook[k]=null;
                		qno=0;
                    		session.setAttribute("qno",Integer.toString(qno));
                  		pw.println("<form  method=get action=loginval><input type=submit value=FINISH></form>");
                	}
                      else
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
                        } 
          
             		       	session.setAttribute("qno",Integer.toString(qno));
		      }	        
                   }
                   else if(etype.equals("cpp"))
         	  {
                        if(q==3)
	                {
        	            for(int k=0;k<cook.length;k++)
                	       cook[k]=null;
                    		qno=0;
                    		session.setAttribute("qno",Integer.toString(qno));
                     		pw.println("<a href=selectexam.html>FINISH</a>");
                	}
                        else
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
                  			rs.close();
            			}
         		   session.setAttribute("qno",Integer.toString(qno));
        	      }	    
                  }
            
      }catch(Exception e){System.out.println("select "+e);}
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
               ps.close();
         }

       }catch(Exception e){System.out.println("insert "+e);}
      try
       {
               
           pw.println("</form></body></html>");
           
       }catch(Exception e){System.out.println("DB problem"+e);}
    
           
 }
}

