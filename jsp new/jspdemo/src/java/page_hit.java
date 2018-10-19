/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kamlesh
 */
public class page_hit extends HttpServlet {

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
        int count = 0;
        try {
            boolean flag = false;
            Cookie[] cook = request.getCookies();

            int index = 0;
            if (cook != null) {
                for (int i = 0; i < cook.length; i++) {
                    String cookiname = cook[i].getName();
                    if (cookiname.equals("hitcount")) {
                        flag = true;
                        index = i;

                    } else {
                        flag = false;

                    }
                }
                if (flag == true) {
                    count = Integer.parseInt(cook[index].getValue());
                    count++;
                    String cnt = String.valueOf(count);
                    cook[index].setValue(cnt);
                    cook[index].setMaxAge(60*60);
                    response.addCookie(cook[index]);
                }

            } else {
                Cookie cookienew = new Cookie("hitcount", "1");
                cookienew.setMaxAge(60*60);
                response.addCookie(cookienew);
                count++;
                
                

            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page_hit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You visited this page:" + count + " times</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servleti response
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
