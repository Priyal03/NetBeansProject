/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import dbms.db;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhwani
 */
public class delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        db dbobj=new db();
        if(request.getParameter("delete")!=null)
        {
            if(request.getParameter("check")==null)
            {
                int mid=Integer.parseInt(request.getParameter("mid"));
                dbobj.Update("message_master", mid, "flag", new Integer(0));
            }
            else
            {
                String aid[]=(String [])(request.getParameterValues("check"));
                for(int i=0;i<aid.length;i++)
                {
                    int mid=Integer.parseInt(aid[i]);
                    out.print(mid+"<br>");
                    dbobj.Update("message_master", mid, "flag", new Integer(0));
                }
                response.sendRedirect("inbox");
            }
        }
        else if(request.getParameter("sent")!=null||request.getParameter("trash")!=null)
        {            
            if(request.getParameter("check")==null)
            {
                int mid=Integer.parseInt(request.getParameter("mid"));
                dbobj.Delete("message_master", mid);
            }
            else
            {
                String aid[]=(String [])(request.getParameterValues("check"));
                for(int i=0;i<aid.length;i++)
                {
                    int mid=Integer.parseInt(aid[i]);
                    out.print(mid+"<br>");
                    dbobj.Delete("message_master", mid);
                }
                response.sendRedirect("inbox");
            }
        }
        else
        {
            int mid=Integer.parseInt(request.getParameter("mid"));
            dbobj.Update("message_master", mid, "flag", new Integer(0));
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
