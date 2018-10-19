package pack;

import dbms.db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class message extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        db dbobj=new db();     
        if(request.getParameter("sort")!=null)
        {
            try {
                int ind=0;
                int r=5;
                if(request.getParameter("ind")!=null)
                    ind=Integer.parseInt(request.getParameter("ind").toString());
                if(request.getParameter("r")!=null)
                    r=Integer.parseInt(request.getParameter("r").toString());
                String keyn="sender";
                String field=request.getParameter("sort");
                String order=request.getParameter("order");
                if(field.equals("reciever"))
                {
                    keyn="reciever";
                    field="user";
                }
                else if(field.equals("sender"))
                {
                    field="user";
                }
                ResultSet res=dbobj.Select("message_master","user_master",keyn,"uid",order,field,ind,r);
                request.setAttribute("message_info", res);
                ResultSet rs=dbobj.Select("user_master");
                request.setAttribute("user_info", rs);
                if(field.equals("user_master.uid"))
                    field="uid";
                if(order.equals("asc"))
                {
                    if(field.equals("user"))
                        request.setAttribute("srt",keyn);
                    else
                        request.setAttribute("srt",field);
                }
                ResultSet res1=dbobj.Total("user_master");
                int t=0;
                while(res1.next())
                {
                    t=res1.getInt(1);
                }
                request.setAttribute("total", t);
                request.setAttribute("page", ((ind/r)+1));
                request.setAttribute("rows", r);
                System.out.println((ind/r)+1);
            } catch (SQLException ex) {
                Logger.getLogger(message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                int ind=0;
                int r=5;
                if(request.getParameter("ind")!=null)
                    ind=Integer.parseInt(request.getParameter("ind").toString());
                if(request.getParameter("r")!=null)
                    r=Integer.parseInt(request.getParameter("r").toString());
                ResultSet res=dbobj.Select("message_master","user_master","sender","uid","asc","mid",ind,r);
                request.setAttribute("message_info", res);
                request.setAttribute("srt","mid");
                ResultSet rs=dbobj.Select("user_master");
                request.setAttribute("user_info", rs);
                ResultSet res1=dbobj.Total("message_master");
                int t=0;
                while(res1.next())
                {
                    t=res1.getInt(1);
                }
                request.setAttribute("total", t);
                request.setAttribute("page", ((ind/r)+1));
                request.setAttribute("rows", r);
                System.out.println((ind/r)+1);
            } catch (SQLException ex) {
                Logger.getLogger(message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
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
