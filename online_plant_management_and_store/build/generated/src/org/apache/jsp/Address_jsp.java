package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Address_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <legend>Add Address</legend><br/><br/>\n");
      out.write("       <form action=\"address\" method=\"post\">\n");
      out.write("      User ID<input type=\"text\" name=\"user_id\" value=\"\" size=\"75\" />&nbsp;&nbsp;\n");
      out.write("      country <label for=\"country\">Country</label>\n");
      out.write("    <select id=\"country\" name=\"country\">\n");
      out.write("      <option value=\"australia\">Australia</option>\n");
      out.write("      <option value=\"canada\">Canada</option>\n");
      out.write("      <option value=\"usa\">USA</option>\n");
      out.write("    </select><br/><br/>\n");
      out.write("\n");
      out.write("      Bill Address<input type=\"text\" name=\"b_address\" value=\"\" size=\"130\" /><br/><br/>\n");
      out.write("       Ship Address<input type=\"text\" name=\"ship_address\" value=\"\" size=\"130\" /><br/><br/>\n");
      out.write("      State <label for=\"state\">State</label>\n");
      out.write("    <select id=\"state\" name=\"state\">\n");
      out.write("      <option value=\"australia\">Aust</option>\n");
      out.write("      <option value=\"canada\">Can</option>\n");
      out.write("      <option value=\"usa\">USA</option>\n");
      out.write("    </select>\n");
      out.write("\n");
      out.write("      city <label for=\"city\">City</label>\n");
      out.write("    <select id=\"city\" name=\"city\">\n");
      out.write("      <option value=\"a\">Au</option>\n");
      out.write("      <option value=\"c\">Ca</option>\n");
      out.write("      <option value=\"u\">U</option>\n");
      out.write("    </select>\n");
      out.write("\n");
      out.write("           \n");
      out.write("          Postal code<input type=\"text\" name=\"post_code\" value=\"\" />\n");
      out.write("    is Billing<input type=\"radio\" name=\"bill_active\" value=\"true\" checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            yes\n");
      out.write("  <input type=\"radio\" name=\"active\" value=\"false\"> No<br><br/>\n");
      out.write("  is Shiping<input type=\"radio\" name=\"ship_active\" value=\"true\" checked>\n");
      out.write("            yes\n");
      out.write("            <input type=\"radio\" name=\"active\" value=\"false\"> No<br><br/>\n");
      out.write("  \n");
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
