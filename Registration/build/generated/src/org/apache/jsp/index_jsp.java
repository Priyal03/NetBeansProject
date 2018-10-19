package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration Form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <form action=\"Register\" method=\"POST\">Name :     \n");
      out.write("            <input type=\"text\" name=\"name\" value=\"\" size=\"10\" /><br><br>\n");
      out.write("            UserName : <input type=\"text\" name=\"uname\" value=\"\" size=\"10\" /><br><br>\n");
      out.write("            Password : <input type=\"password\" name=\"pass\" value=\"\" size=\"10\" /><br><br>\n");
      out.write("            Age :    <input type=\"text\" name=\"age\" value=\"\" size=\"2\" /><br><br>\n");
      out.write("            City :   <select name=\"city\">\n");
      out.write("                <option>Vapi</option>\n");
      out.write("                <option>Rajkot</option>\n");
      out.write("                <option>Vadodara</option>\n");
      out.write("                <option>Surat</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Gender :    \n");
      out.write("            Male <input type=\"radio\" name=\"gen\" value=\"Male\" />\n");
      out.write("            Female <input type=\"radio\" name=\"gen\" value=\"Female\" /><br><br>\n");
      out.write("            Contact No :     <input type=\"text\" name=\"contact\" value=\"\" size=\"10\" /><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Submit\" /> or\n");
      out.write("            <input type=\"reset\" value=\"Reset\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
