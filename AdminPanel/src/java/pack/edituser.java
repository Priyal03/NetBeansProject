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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhwani
 */
public class edituser extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        db dbobj=new db();
        int id=Integer.parseInt(request.getParameter("id").toString());
        ResultSet res=dbobj.Select("user_master", "uid", id);
        ResultSet rs=dbobj.Select("city");
        try 
        {
            while(res.next())
            {
                int uid=res.getInt(1);
                out.print("<td><input id='demo_box_"+uid+"' class='css-checkbox' name='check' type='checkbox' checked='checked' value='"+uid+"'/>");
                out.print("<label for='demo_box_"+uid+"' name='demo_lbl_"+uid+"' class='css-label'></label></td>");
                out.print("<td>"+uid+"</td>");
                out.print("<td><input type='text' id='name"+uid+"' name='name"+uid+"' value='"+res.getString(2)+"'></td>");
                out.print("<td><input type='text' id='user"+uid+"' name='user"+uid+"' value='"+res.getString(3)+"'></td>");
                out.print("<td><input type='text' id='password"+uid+"' name='password"+uid+"' value='"+res.getString(4)+"'></td>");
                out.print("<td><select id='gen"+uid+"' name='gen"+uid+"'>");
                out.print("<option value='M'"+(res.getString(5).equals("M")?"selected='selected'":"")+">M</option>");
                out.print("<option value='F'"+(res.getString(5).equals("F")?"selected='selected'":"")+">F</option>");
                out.print("</select></td>");
                out.print("<td><select id='cty"+uid+"' name='cty"+uid+"'> ");                                           
                while(rs.next())
                {
                    out.print("<option value='"+rs.getInt(1)+"'"+(res.getInt(6)==rs.getInt(1)?"selected='selected'":"")+">"+rs.getString(3)+"</option>");
                }
                out.print("</select></td>");
                out.print("<td><input type='text' id='phone"+uid+"' name='phone"+uid+"' value='"+res.getString(7)+"'></td>");
                out.print("<td><input type='text' id='date"+uid+"' name='date"+uid+"' value='"+res.getString(8)+"'></td>");
                out.print("<td><input type='text' id='email"+uid+"' name='email"+uid+"' value='"+res.getString(9)+"'></td>");
                out.print("<td class='options-width'>");
                out.print("<a href=\"javascript:onSubmit("+uid+",'update')\" title='Save' class='icon-5 info-tooltip'></a>");
            }
        } catch (SQLException ex) {
        Logger.getLogger(edituser.class.getName()).log(Level.SEVERE, null, ex);
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
