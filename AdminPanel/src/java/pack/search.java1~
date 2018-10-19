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

public class search extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        db dbobj=new db();
        String tb;
        String txt;
        tb=request.getParameter("opt");
        txt=request.getParameter("txt");        
        out.println(tb);
        out.println(txt);
        if(request.getParameter("sort")!=null)
        {
            try {
                int ind=0;
                int r=5;
                if(request.getParameter("ind")!=null)
                    ind=Integer.parseInt(request.getParameter("ind").toString());
                if(request.getParameter("r")!=null)
                    r=Integer.parseInt(request.getParameter("r").toString());
                request.setAttribute("page", ((ind/r)+1));
                request.setAttribute("rows", r);
                String field=request.getParameter("sort");
                String order=request.getParameter("order");
                ResultSet res = dbobj.SelectLike(tb, txt,order,field,ind,r);
                if(tb.equals("user_master"))
                    request.setAttribute("user_info", res);
                else
                    request.setAttribute("message_info", res);
                ResultSet rs=dbobj.Select("city");
                request.setAttribute("city_info", rs);
                if(order.equals("asc"))
                    request.setAttribute("srt",field);
                ResultSet res1=dbobj.Total(tb, txt);
                int t=0;
                while(res1.next())
                {
                    t=res1.getInt(1);
                }
                request.setAttribute("total", t);
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
        else
        {
            try {
                int ind=0;
                int r=5;
                String field="";
                if(tb.equals("user_master"))
                    field="uid";
                else
                    field="mid";
                if(request.getParameter("ind")!=null)
                    ind=Integer.parseInt(request.getParameter("ind").toString());
                if(request.getParameter("r")!=null)
                    r=Integer.parseInt(request.getParameter("r").toString());
                ResultSet res = dbobj.SelectLike(tb, txt,"asc",field,ind,r);
                if(tb.equals("user_master"))
                    request.setAttribute("user_info", res);
                else
                    request.setAttribute("message_info", res);
                ResultSet rs=dbobj.Select("city");
                ResultSet res1=dbobj.Total(tb,txt);
                int t=0;
                while(res1.next())
                {
                    t=res1.getInt(1);
                }
                request.setAttribute("total", t);
                request.setAttribute("page", ((ind/r)+1));
                request.setAttribute("rows", r);
                System.out.println((ind/r)+1);
                request.setAttribute("city_info", rs);
                if(res!=null)
                    System.out.print("Yes");
                else
                    System.out.print("No");
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
        request.setAttribute("opt", tb);
        request.setAttribute("txt", txt);
        RequestDispatcher rd;
        if(tb.equals("user_master"))
            rd=request.getRequestDispatcher("searchuser.jsp");
        else
            rd=request.getRequestDispatcher("searchmessage.jsp");
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
