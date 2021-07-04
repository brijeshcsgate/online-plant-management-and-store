package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DBConfig.JDBCFile;
import java.sql.ResultSet;

public final class bill_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("      ");

            if(request.getSession().getAttribute("Email")==null){
                response.sendRedirect("login.html");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            String email=request.getSession().getAttribute("Email").toString();
            int cartId=0;
            ResultSet cart=null;
            ResultSet user=null;
            try{
                user=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
                user.first();
            
                cart=JDBCFile.executeQuery("select * from cart where user_id="+user.getString(1));
                cart.first();
            
                cartId=cart.getInt(1);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
          ResultSet rs=null;
          try{
            rs=JDBCFile.executeQuery("select * from cart_line where cart_id="+cartId);
            
           
           while(rs.next()){
                   String sql="insert into order_item(order_id,"
                           + "product_id,"
                           + "product_count,"
                           + "buying_price,"
                           + "total)"
                           + "values("
                           + "(select id from order_detail  where user_id="+user.getString(1)+"),"
                           + "(select product_id from cart_line  where user_id="+user.getString(1)+"),"
                           + "(select product_count from cart_line  where user_id="+user.getString(1)+"),"
                           + "(select buying_price from cart_line  where user_id="+user.getString(1)+"),"
                           + "(select total from cart_line where user_id="+user.getString(1)+")"+")";
           JDBCFile.executeUpdate(sql);
                      
                }
            }
          catch(Exception ex){
            ex.printStackTrace();
            }
        
      out.write("\n");
      out.write("     \n");
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
