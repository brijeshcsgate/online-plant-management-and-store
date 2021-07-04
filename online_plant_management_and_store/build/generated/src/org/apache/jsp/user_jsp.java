package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/navbar.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User information</title><link rel=\"stylesheet\" href=\"shop_first.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("<header>\n");
      out.write("  <h2>E-commerce web</h2>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<section>\n");
      out.write("  <nav>\n");
      out.write("       \n");
      out.write("        ");
      out.write("<ul>\n");
      out.write("    <li><a href=\"cart.jsp\">Cart</a></li>\n");
      out.write("    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("    <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("    <li><a href=\"product_form.jsp\">Upload Product</a></li>\n");
      out.write("    <li><a href=\"supplier.jsp\">Register Supplier</a></li>\n");
      out.write("    <li><a href=\"user.jsp\">Register User</a></li>\n");
      out.write("    <li><a href=\"productList.jsp\">All Products</a></li>\n");
      out.write("    <li><a href=\"Category.jsp\">Category Insert</a></li>\n");
      out.write("    <li><a href=\"Address.jsp\">Address</a></li>\n");
      out.write("</ul>");
      out.write("</nav><article>\n");
      out.write("            <fieldset><legend>User Information</legend><br/><br/>\n");
      out.write("         <form action=\"user\" method=\"post\">\n");
      out.write("            Name<input type=\"text\" name=\"p_name\" value=\"\" size=\"130\" /><br/><br/>\n");
      out.write("           email <input type=\"text\" name=\"p_email\" value=\"\" size=\"130\"/><br/><br/>\n");
      out.write("            Password<input type=\"text\" name=\"p_password\" value=\"\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            \n");
      out.write("            contact Num.<input type=\"text\" name=\"p_phone\" value=\"\" pattern=\"[6789]{1}[0-9]{9}\" /><br/><br/>\n");
      out.write("           role<input type=\"text\" name=\"p_role\" value=\"\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("             enabled<input type=\"text\" name=\"p_password\" value=\"\" /><br/><br/>\n");
      out.write("            <br/><br/><br/><br/>\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Submit\" />\n");
      out.write("            <input type=\"reset\" name=\"reset\" value=\"Reset\" />\n");
      out.write("        </form></article></section>\n");
      out.write("         <footer>\n");
      out.write("  <p>Footer</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
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
