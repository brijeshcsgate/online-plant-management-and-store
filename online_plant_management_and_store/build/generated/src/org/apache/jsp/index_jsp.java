package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DBConfig.JDBCFile;
import java.io.PrintWriter;
import java.sql.ResultSet;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    ResultSet rs=null;
    try{
    rs=JDBCFile.executeQuery("select * from product");
    }
    
    catch(Exception ex){
        ex.printStackTrace();
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>home page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"shop_first.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>E-Commerce</header>\n");
      out.write("      <section>  <nav> ");
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
      out.write("</nav>\n");
      out.write("          <article>\n");
      out.write("              \n");
      out.write("                       <h1>Product List!</h1>\n");
      out.write("        <table width=\"600px\">\n");
      out.write("            ");
while(rs.next()){
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("                <td><img src=\"");
 out.print(rs.getString(13)); 
      out.write("\" alt=\"");
 out.print(rs.getString(11)); 
      out.write("\" width=\"300px\"/>\n");
      out.write("                ");
 out.print(rs.getString(3)); 
      out.write("<br/>\n");
      out.write("                ");
 out.print(rs.getString(11)); 
      out.write("<br/>\n");
      out.write("                ");
 out.print(rs.getString(4)); 
      out.write("<br/>\n");
      out.write("                ");
 out.print(rs.getString(8)); 
      out.write("<br/>\n");
      out.write("                \n");
      out.write("                <a href=\"productList.jsp\">Add To Cart</a></td>\n");
      out.write("            \n");
      out.write("            ");
 }rs.close();JDBCFile.closeAll(); 
      out.write("\n");
      out.write("        </table>\n");
      out.write("   \n");
      out.write("    \n");
      out.write("          </article>\n");
      out.write("    </section>      <footer>footer</footer>\n");
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
