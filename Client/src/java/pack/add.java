/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import dbms.db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhwani
 */
public class add extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String n=request.getParameter("name").toString();
            String u=request.getParameter("user").toString();
            String p=request.getParameter("password").toString();        
            String g=request.getParameter("gen").toString();
            int ct=Integer.parseInt(request.getParameter("cty").toString());
            String ph=request.getParameter("phone").toString();
            int d=Integer.parseInt(request.getParameter("d").toString());
            int m=Integer.parseInt(request.getParameter("m").toString());
            int y=Integer.parseInt(request.getParameter("y").toString());
            String date=y+"/"+(m<10?"0"+m:m+"")+"/"+(d<10?"0"+d:d+"");
            String e=request.getParameter("email").toString();
            ArrayList<Object> al=new ArrayList<Object>();
            al.add(n);
            al.add(u);
            al.add(p);
            al.add(g);
            al.add(new Integer(ct));
            al.add(ph);
            al.add(date);
            al.add(e);
            al.add(0);
            db dbobj=new db();
            dbobj.Insert("user_master", al);
            ArrayList<Object> a=new ArrayList<Object>();
            ResultSet rs=dbobj.Query("select uid from user_master order by uid desc limit 1");
            ResultSet res=dbobj.Select("message_master", "mid", 1);
            rs.next();
            res.next();
            a.add(new Integer(1));
            a.add(new Integer(rs.getInt("uid")));
            a.add(res.getString("subject"));
            a.add(res.getString("msg"));
            a.add(new Integer(1));
            a.add("CURRENT_TIMESTAMP");
            dbobj.Insert("message_master", a);
            request.setAttribute("add", "true");
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
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
