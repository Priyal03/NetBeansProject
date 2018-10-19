package pack;

import dbms.db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class draftinfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        db dbobj=new db();     
        int uid=0;
        Cookie a[]=request.getCookies();
        if(a!=null)
            uid=Integer.parseInt(a[3].getValue());
        System.out.println(uid);
        if(request.getParameter("sort")!=null)
        {
            String keyn="sender";
            String field=request.getParameter("sort");
            String order=request.getParameter("order");
            if(field.equals("sender"))
            {
                field="user";
            }
            ResultSet res=dbobj.Select("draft_info","user_master","sender","uid","sender",String.valueOf(uid),order,field);
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
        }
        else
        {
            ResultSet res=dbobj.Select("draft_info","user_master","reciever","uid","sender",String.valueOf(uid),"asc","did");
            request.setAttribute("message_info", res);
            request.setAttribute("srt","mid");
            ResultSet rs=dbobj.Select("user_master");
            request.setAttribute("user_info", rs);
        }
        RequestDispatcher rd=request.getRequestDispatcher("draftinfo.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
