package login_ad;

import dbms.Connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class verifyAdmin extends HttpServlet 
{
    private Connection con;
    private Statement st;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            Connect c=new Connect();
            con=c.getConnect();
            String u=request.getParameter("user");
            String p=request.getParameter("password");
            st=con.createStatement();
            String str="select * FROM admin_tb where user='"+u+"'and password='"+p+"'";
            ResultSet val = st.executeQuery(str);
            HttpSession s = request.getSession();
            if(val.next())
            {
                s.setAttribute("ses", "true");
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.
                Cookie c1=new Cookie("user", u);
                Cookie c2=new Cookie("password", p);
                Cookie c3=new Cookie("aid", String.valueOf(val.getInt("aid")));
                response.addCookie(c1);
                response.addCookie(c2);
                response.addCookie(c3);
                response.setHeader("Pragma","no-cache");  
                response.setHeader("Cache-Control","no-store");  
                response.setHeader("Expires","0");  
                response.setDateHeader("Expires",-1); 
                response.sendRedirect("home.jsp");
            }
            else
                response.sendRedirect("logAdmin.jsp?log=0");
        } catch (Exception ex) 
        {
            out.print(ex.getMessage());
            //Logger.getLogger(verifyAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse hsr = (HttpServletResponse) res;
        hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        hsr.setDateHeader("Expires", 0); // Proxies.
        chain.doFilter(req, res);
}
}
