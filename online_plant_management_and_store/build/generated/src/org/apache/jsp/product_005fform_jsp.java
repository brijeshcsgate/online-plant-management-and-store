package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import DBConfig.JDBCFile;

public final class product_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Create Product Category</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"shop_first.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <h2>E commerce web</h2>\n");
      out.write("        </header>\n");
      out.write("        <section>  \n");
      out.write("        <nav>   \n");
      out.write("           ");
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
      out.write("    \n");
      out.write("        </nav>     \n");
      out.write("        <article>              \n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Product Information</legend><br/>   \n");
      out.write("                <form action=\"product\" method=\"get\" border=\"10px\">\n");
      out.write("                    <pre>\n");
      out.write("                    Product name<input type=\"text\" name=\"p_name\" value=\"\" />\n");
      out.write("                    Product Brand<input type=\"text\" name=\"p_brand\"/>  \n");
      out.write("                    Category  <select name=\"p_category\">\n");
      out.write("                    ");
 
                        ResultSet rs=JDBCFile.executeQuery("select id,name from category");
                        while(rs.next()){
                    
      out.write("    \n");
      out.write("                    <option value=\"");
out.print(rs.getString(1));
      out.write('"');
      out.write('>');
out.print(rs.getString(2));
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    Product Quantity<input type=\"text\" name=\"p_quantity\" value=\"\" />\n");
      out.write("                    Product Price<input type=\"text\" name=\"p_price\" value=\"\" />\n");
      out.write("                    Supplier id<input type=\"text\" name=\"Supplier_id\" value=\"\" />\n");
      out.write("          \n");
      out.write("                    <fieldset>\n");
      out.write("                        <legend>Description</legend>\n");
      out.write("                        <textarea name=\"p_discription\" rows=\"5\" ></textarea>\n");
      out.write("                    </fieldset>  \n");
      out.write("                    <input type=\"submit\" name=\"submit\" value=\"Submit\" /><br/><br/>\n");
      out.write("                    </pre>\n");
      out.write("                </form>\n");
      out.write("            </fieldset>     \n");
      out.write("        \n");
      out.write("           </article>\n");
      out.write("         </section>\n");
      out.write("        <footer><p>Footer</p></footer>\n");
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
