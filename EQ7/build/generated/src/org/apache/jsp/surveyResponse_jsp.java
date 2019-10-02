package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;

public final class surveyResponse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Survey Response JSP</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                font-size: 14px;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            p{\n");
      out.write("                font-size: 14px;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            h2{\n");
      out.write("                font-size: 18px;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            <h2>Survey</h2>\n");
      out.write("            <p>Here is a summary of your survey inputs.</p>\n");
      out.write("            ");

                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("/WEB-INF/surveyList.txt");
                File file = new File(path);
                PrintWriter output = new PrintWriter(new FileWriter(file, true));
                output.println(firstName + "|" + lastName + "|" + emailAddress);
                output.close();
            
      out.write("\n");
      out.write("            <h2>Your information: </h2>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>First Name: </td>\n");
      out.write("                    <td>");
      out.print( firstName);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Last Name: </td>\n");
      out.write("                    <td>");
      out.print( lastName);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Email Address: </td>\n");
      out.write("                    <td>");
      out.print( emailAddress);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <h2>You heard about us from ");
      out.print( request.getParameter("heardUs"));
      out.write("</h2>\n");
      out.write("            ");
           
                String checkbox = request.getParameter("receiveInfo");
                if(checkbox != null){    
            
      out.write("\n");
      out.write("            <h2>You would like to receive announcements about new CDs.</h2>\n");
      out.write("            ");

                }
                else{
            
      out.write("\n");
      out.write("            <h2>You would not like to receive announcements about new CDs.\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            <br /><br />\n");
      out.write("            We can contact you by ");
      out.print( request.getParameter("contactMe"));
      out.write(".\n");
      out.write("            <br />\n");
      out.write("            <p>Thank you for taking the survey.</p>\n");
      out.write("            <form action=\"survey.html\">\n");
      out.write("                <input type=\"submit\" value=\"submit\"\n");
      out.write("            </form>\n");
      out.write("            <br /><br />Click to return to the survey page.\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
