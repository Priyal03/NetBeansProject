/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user_login;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dhwani
 */
public class verify extends HttpServlet {
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
            String str="select * FROM user_master where user='"+u+"'and password='"+p+"'";
            ResultSet val = st.executeQuery(str);
            HttpSession s = request.getSession();
            if(val.next())
            {
                if(val.getInt("status")==1)
                {
                    s.setAttribute("ses", "true");
                    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                    response.setDateHeader("Expires", 0); // Proxies.
                    Cookie c1=new Cookie("user", u);
                    Cookie c2=new Cookie("password", p);
                    Cookie c3=new Cookie("uid", ((new Integer(val.getInt("uid"))).toString()));
                    response.addCookie(c1);
                    response.addCookie(c2);
                    response.addCookie(c3);
                    response.setHeader("Pragma","no-cache");  
                    response.setHeader("Cache-Control","no-store");  
                    response.setHeader("Expires","0");  
                    response.setDateHeader("Expires",-1); 
                    response.sendRedirect("inbox");
                }
                else
                    response.sendRedirect("login.jsp?dis=0");
            }
            else
                response.sendRedirect("login.jsp?log=0");
        } catch (Exception ex) 
        {
            out.print(ex.getMessage());
            //Logger.getLogger(verifyAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse hsr = (HttpServletResponse) res;
        hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        hsr.setDateHeader("Expires", 0); // Proxies.
        chain.doFilter(req, res);
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
