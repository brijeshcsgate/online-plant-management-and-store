package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Category_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Category</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"shop_first.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("  <h2>E-commerce web</h2>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<section>\n");
      out.write("  <nav> ");
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
      out.write("\n");
      out.write("  </nav>\n");
      out.write("  \n");
      out.write("  <article>\n");
      out.write("     <fieldset>\n");
      out.write("         <legend>Add Category</legend><br/><br/>\n");
      out.write("       <form action=\"Add_category\" method=\"post\">\n");
      out.write("           Name<input type=\"text\" name=\"c_name\" value=\"\" size=\"130\" /><br/><br/><br/>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("           Image URL<input type=\"text\" name=\"img_url\" value=\"\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("    is active<input type=\"radio\" name=\"active\" value=\"1\" checked>\n");
      out.write("            yes\n");
      out.write("  <input type=\"radio\" name=\"active\" value=\"2\"> No<br><br/><br/>\n");
      out.write("  \n");
      out.write("           <fieldset><legend>  \n");
      out.write("                Description</legend><textarea name=\"c_discreption\" rows=\"5\" cols=\"100\"></textarea>\n");
      out.write("      \n");
      out.write("          </fieldset>  <br/><br/><br/><br/><br/><br/><br/>\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Submit\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <input type=\"reset\" name=\"reset\" value=\"Reset\" />\n");
      out.write("         </form></fieldset></article>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("  <p>Footer</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("</body>\n");
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
