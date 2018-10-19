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
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhwani
 */
public class send extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        try {
            
            db dbobj=new db();
            int uid=0;
            Cookie a[]=request.getCookies();
            if(a!=null)
                uid=Integer.parseInt(a[3].getValue());
            if(request.getParameter("send")!=null)
            {
                if(request.getParameter("did")!=null)
                    dbobj.Delete("draft_info", Integer.parseInt(request.getParameter("did")));
                String r=request.getParameter("reciever");
                String u=r.substring(0, r.indexOf("@"));
                System.out.println(u);
                ResultSet rs = dbobj.Query("select uid from user_master where user='"+u+"'");
                rs.next();
                int rc=rs.getInt("uid");
                String s=request.getParameter("subject");
                String ar=request.getParameter("area");
                ArrayList<Object> al=new ArrayList<Object>();
                al.add(new Integer(uid));
                al.add(new Integer(rc));            
                al.add(s);
                al.add(ar);
                al.add(new Integer(1));
                al.add("CURRENT_TIMESTAMP");
                dbobj.Insert("message_master", al);
            }
            else if(request.getParameter("draft")!=null)
            {
                String r=null,s=null,ar=null;
                if(request.getParameter("reciever")!=null)
                {
                    r=request.getParameter("reciever");
                }
                if(request.getParameter("subject")!=null)
                    s=request.getParameter("subject");
                if(request.getParameter("area")!=null)
                    ar=request.getParameter("area");
                ArrayList<Object> al=new ArrayList<Object>();
                al.add(new Integer(uid));
                al.add(r);            
                al.add(s);
                al.add(ar);
                al.add("CURRENT_TIMESTAMP");
                dbobj.Insert("draft_info", al);
            }
            response.sendRedirect("inbox");
        }
        
        catch (Exception ex) {
            Logger.getLogger(send.class.getName()).log(Level.SEVERE, null, ex);
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
