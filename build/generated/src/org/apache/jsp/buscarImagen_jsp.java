package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buscarImagen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Busca una imagen</title>\n");
      out.write("    </head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1>Busca una imatge</h1>\n");
      out.write("        <br><br>\n");
      out.write("        <h2>Escull els camps de cerca de la imatge</h2>\n");
      out.write("        <form method =\"post\" action=\"buscarImagen\">\n");
      out.write("            <div>Titol</div>\n");
      out.write("            <input type=\"text\" name=\"titulo\" placeholder=\"Titol de la foto\">\n");
      out.write("            \n");
      out.write("            <div>Data Creació</div>\n");
      out.write("            <input type =\"date\" name=\"fecha\" placeholder=\"Descripció breu de la foto\">\n");
      out.write("            \n");
      out.write("            <div>Paraula clau</div>\n");
      out.write("            <input type=\"text\" name=\"paraulaclau\" placeholder=\"Paraules clau de la foto\">\n");
      out.write("            \n");
      out.write("             <div>Autor</div>\n");
      out.write("            <input type =\"text\" name=\"author\" placeholder=\"Autor de la foto\">\n");
      out.write("\n");
      out.write("            <input type =\"submit\" value=\"Busca!\">\n");
      out.write("                     \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <a href=\"menu.jsp\"><h4>Tornar al menu!</h4></a>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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
