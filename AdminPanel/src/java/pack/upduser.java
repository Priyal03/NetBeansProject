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

/**
 *
 * @author dhwani
 */
public class upduser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(request.getParameterValues("check")==null)
            response.sendRedirect("viewuser");
        else
        {
            db dbobj=new db();
            String aid[]=(String [])(request.getParameterValues("check"));
            if(request.getParameter("edit")!=null)
            {
                ArrayList<Integer> al;
                al = new ArrayList<Integer>();
                for(int i=0;i<aid.length;i++)
                    al.add(Integer.parseInt(aid[i]));
                request.setAttribute("al", al);
            }
            else if(request.getParameter("delete")!=null)
            {
                for(int i=0;i<aid.length;i++)
                {
                    int id=Integer.parseInt(aid[i]);
                    dbobj.Delete("user_master", id);
                }
            }
            else if(request.getParameter("update")!=null)
            {
                for(int i=0;i<aid.length;i++)
                {
                    int id=Integer.parseInt(aid[i]);
                    String n=request.getParameter("name"+id).toString();
                    String u=request.getParameter("user"+id).toString();
                    String p=request.getParameter("password"+id).toString();        
                    String g=request.getParameter("gen"+id).toString();
                    int ct=Integer.parseInt(request.getParameter("cty"+id).toString());
                    String ph=request.getParameter("phone"+id).toString();
                    String date=request.getParameter("date"+id).toString();
                    String e=request.getParameter("email"+id).toString();
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
                }
            }
            RequestDispatcher rd=request.getRequestDispatcher("viewuser");
                rd.forward(request, response);
            //for(int i=0;i<aid.length;i++)
              //  out.print(aid[i]+"<br>");
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
