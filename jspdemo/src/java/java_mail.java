

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.*;


public class java_mail extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            final String from = "kamleshchandnani07@gmail.com";
            final String to = "kamlesh.chandnani@gmail.com";
            final String pass = "kamleshc";

            //for ssl type use following code
/*
             * prop.put("mail.smtp.socketFactory.port", "465");
             prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
             prop.put("mail.smtp.port", "465");
             */
            
            
            //for tls
            /* 
             * prop.put("mail.smtp.socketFactory.port", "587");
             prop.put("mail.smtp.starttls.enable","true");
             prop.put("mail.smtp.port", "587");
             */
            
            //create instance of property class
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            //prop.put("mail.smtp.starttls.enable","true");
            //prop.put("mail.smtp.connectiontimeout", 10000);
            prop.put("mail.smtp.port", "465");




            //set authentication
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            });

            //setup message
            Message msg = new MimeMessage(session);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
           // msg.addRecipient(Message.RecipientType.CC, new InternetAddress("neelghodasara@yahoo.com"));
            msg.setSubject("Mail test");
            msg.setFrom(new InternetAddress("Kamlesh"));
            msg.setText("This is java mail api test!!");
            msg.setHeader("header", "Header Check");

            //prepare a transport 
            Transport.send(msg);

            out.println("mail sent successfully..");



            /* TODO output your page here. You may use following sample code. */
            /* out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet java_mail</title>");            
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet java_mail at " + request.getContextPath() + "</h1>");
             out.println("</body>");
             out.println("</html>");*/
        } catch (Exception e) {
            out.println("Error" + e.getMessage());
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
