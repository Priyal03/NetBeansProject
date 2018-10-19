/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import com.mysql.jdbc.Statement;

/**
 *
 * @author Administrator
 */
public class login extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            //processRequest(request, response);
            String username = request.getParameter("uname");
            String password = request.getParameter("upass");

            Connection conn;
            Statement st;
            ResultSet rs;

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");

            PreparedStatement pre=conn.prepareStatement("select * from login where uname=? and upass=?");
            pre.setString(1, username);
            pre.setString(2, password);
            //st = (Statement) conn.createStatement();
            rs = pre.executeQuery();
            if (rs.next()) {
                 //PrintWriter out=response.getWriter();
                 HttpSession session=request.getSession();
                 session.setAttribute("user", username);
                 response.sendRedirect("welcome");

                //if(request.getSession(false).getAttribute("user")!=null){

                //out.println("<h2>Welcome, "+session.getAttribute("user") + "</h2>");
                /*}
                else
                {
                     out.println("<h2>session not created</h2>");
                 }*/
            } else {
                /*RequestDispatcher view = request.getRequestDispatcher("signup.jsp");
                view.forward(request, response);*/
            response.sendRedirect("signup.jsp");
            }

        } catch (Exception e) {
            PrintWriter out=response.getWriter();
            out.println("Error"+e.getMessage());
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
