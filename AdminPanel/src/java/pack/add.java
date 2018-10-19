/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import dbms.db;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        request.setAttribute("add", "true");
        RequestDispatcher rd=request.getRequestDispatcher("viewuser");
        rd.forward(request, response);
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
