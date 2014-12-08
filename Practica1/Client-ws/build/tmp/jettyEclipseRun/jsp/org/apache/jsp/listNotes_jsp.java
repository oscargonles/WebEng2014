package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listNotes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Notas</title>\r\n");
      out.write("</head>\r\n");

	String respuesta=(String) request.getAttribute("listNotes");

      out.write("\r\n");
      out.write("<div><span style=\"float:right\"><b>LISTADO DE NOTAS</b><br>");
      out.print(respuesta );
      out.write("</span>\r\n");
      out.write("<fieldset>\r\n");
      out.write("<h1 >Creacion rapida de notas</h1>\r\n");
      out.write("\t<form method=\"get\" action=\"hi\" >\r\n");
      out.write("\t\t<p><label >Task:</label></p>\r\n");
      out.write("                        <input name=\"task\" type=\"text\" id=\"task\">\r\n");
      out.write("        <p><label>Context:</label></p>\r\n");
      out.write("                        <input name=\"context\" type=\"text\" id=\"context\">\r\n");
      out.write(" \t\t<p><label>Project:</label></p>\r\n");
      out.write("                        <input name=\"proyect\" type=\"text\" id=\"proyect\">              \r\n");
      out.write("        <p><label>Priority:</label></p>\r\n");
      out.write("        \t<input name=\"priority\" type=\"number\" id=\"priority\">\r\n");
      out.write("        <p><input type=\"submit\" id=\"submit\" onclick=\"pregunta()\" name=\"submit\" value=\"Crear\" class=\"boton\"></p>\r\n");
      out.write("\t</form>\r\n");
      out.write("</fieldset>\r\n");
      out.write("<fieldset>\r\n");
      out.write("<h2>Eliminacion de notas</h2>\r\n");
      out.write("\t<form method=\"get\" action=\"hi\">\r\n");
      out.write("\t<select name=\"menu\">\r\n");
      out.write("\t  <option selected=\"selected\" value=\"Task\">Task</option>\r\n");
      out.write("\t  <option value=\"Context\">Context</option>\r\n");
      out.write("\t  <option value=\"Project\">Project</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input name=\"campo\" type=\"text\" id=\"campo\">\r\n");
      out.write("    <p><input type=\"submit\" id=\"submit\" name=\"submit\" value=\"Aceptar\" class=\"boton\"></p>\r\n");
      out.write("    <p><input type=\"submit\" id=\"submit\" name=\"submit\" value=\"Borrar todo\" class=\"boton\"></p>\r\n");
      out.write("    </form>\r\n");
      out.write("</fieldset>\r\n");
      out.write("<fieldset>\r\n");
      out.write("<h3>Filtrado de notas</h3>\r\n");
      out.write("\t<form method=\"get\" action=\"hi\">\r\n");
      out.write("\t<select name=\"menu\">\r\n");
      out.write("\t  <option selected=\"selected\" value=\"Task\">Task</option>\r\n");
      out.write("\t  <option value=\"Context\">Context</option>\r\n");
      out.write("\t  <option value=\"Project\">Project</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input name=\"campo\" type=\"text\" id=\"campo\">\r\n");
      out.write("    <p><input type=\"submit\" id=\"submit\" name=\"submit2\" value=\"Aceptar Filter\" class=\"boton\"></p>\r\n");
      out.write("    <p><input type=\"submit\" id=\"submit\" name=\"submit2\" value=\"Lista completa\" class=\"boton\"></p>\r\n");
      out.write("    </form>\r\n");
      out.write("</fieldset>\r\n");
      out.write("</div>\r\n");
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
