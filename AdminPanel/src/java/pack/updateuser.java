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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateuser extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            db dbobj=new db();
            int id=Integer.parseInt(request.getParameter("id").toString());
            String n=request.getParameter("name").toString();
            String u=request.getParameter("user").toString();
            String p=request.getParameter("password").toString();        
            String g=request.getParameter("gen").toString();
            int ct=Integer.parseInt(request.getParameter("cty").toString());
            String ph=request.getParameter("phone").toString();
            String date=request.getParameter("date").toString();
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
            dbobj.Update("user_master", id, al);
            ResultSet res=dbobj.Select("user_master", "uid", id);
            ResultSet rs=dbobj.Select("city", "cityid", ct);
            res.next();
            rs.next();
            out.print("<td><input id='demo_box_"+id+"' class='css-checkbox' name='check' type='checkbox' value='"+id+"'/>");
            out.print("<label for='demo_box_"+id+"' name='demo_lbl_"+id+"' class='css-label'></label></td>");
            out.print("<td>"+id+"</td>");
            out.print("<td>"+n+"</td>");
            out.print("<td>"+u+"</td>");
            out.print("<td>"+p+"</td>");
            out.print("<td>"+g+"</td>");
            out.print("<td>"+rs.getString(3)+"</td>");
            out.print("<td>"+ph+"</td>");
            out.print("<td>"+date+"</td>");
            out.print("<td>"+e+"</td>");
            out.print("<td class='options-width'>");
            out.print("<a href=\"javascript:onSubmit("+id+",'edit')\" title='Edit' class='icon-1 info-tooltip'></a>");
            out.print("<a href=\"javascript:onSubmit("+id+",'delete')\" title='Delete' class='icon-2 info-tooltip'></a>");
            if(res.getInt(10)==1)
                out.print("<a href='' title='Disable' class='icon-5 info-tooltip'></a></td>");
            else
                out.print("<a href='' title='Enable' class='icon-3 info-tooltip'></a></td>");
        } catch (SQLException ex) {
            Logger.getLogger(updateuser.class.getName()).log(Level.SEVERE, null, ex);
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
