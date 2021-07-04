package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DBConfig.JDBCFile;
import java.io.PrintWriter;
import java.sql.ResultSet;

public final class chekout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Chekout form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("    <div class=\"row\">\n");
      out.write("  <div class=\"col-75\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <form action=\"\">\n");
      out.write("      ");

            if(request.getSession().getAttribute("Email")==null){
                response.sendRedirect("login.html");
            }
        
      out.write("\n");
      out.write("        ");

            String email=request.getSession().getAttribute("Email").toString();
            int cartId=0;
            ResultSet cart=null;
            try{
                ResultSet user=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
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
            }
          catch(Exception ex){
            ex.printStackTrace();
            }
        
      out.write("\n");
      out.write("     \n");
      out.write("        <h1>Your Selected product Detals</h1>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>cart_id</th>\n");
      out.write("                <th>Product id</th>\n");
      out.write("                <th>Product Price</th>\n");
      out.write("                <th>count</th>\n");
      out.write("                <th>total</th>\n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("            ");
while(rs.next()){
      out.write("\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>");
 out.print(rs.getString(2)); 
      out.write("</td>\n");
      out.write("                <td>");
 out.print(rs.getString(4)); 
      out.write("</td>\n");
      out.write("                <td>");
 out.print(rs.getString(3)); 
      out.write("</td>\n");
      out.write("                <td>");
 out.print(rs.getString(5)); 
      out.write("</td>\n");
      out.write("                     <td>");
 out.print(rs.getString(3)); 
      out.write("</td>\n");
      out.write("                \n");
      out.write("                         </tr>\n");
      out.write("                <td></td>         \n");
      out.write("               ");
 } 
      out.write("          \n");
      out.write("                        </table>\n");
      out.write("                        <label>Grand Total:-");
 out.print(cart.getString(3)); 
      out.write("</label>       \n");
      out.write("            ");
 rs.close();JDBCFile.closeAll(); 
      out.write("\n");
      out.write("  \n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-50\">\n");
      out.write("            <h3>Billing Address</h3>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"col-50\">\n");
      out.write("            <h3>Payment</h3>\n");
      out.write("            <label for=\"fname\">Accepted Cards</label>\n");
      out.write("            <div class=\"icon-container\">\n");
      out.write("              <i class=\"fa fa-cc-visa\" style=\"color:navy;\"></i>\n");
      out.write("              <i class=\"fa fa-cc-amex\" style=\"color:blue;\"></i>\n");
      out.write("              <i class=\"fa fa-cc-mastercard\" style=\"color:red;\"></i>\n");
      out.write("              <i class=\"fa fa-cc-discover\" style=\"color:orange;\"></i>\n");
      out.write("            </div>\n");
      out.write("            <label for=\"cname\">Name on Card</label>\n");
      out.write("            <input type=\"text\" id=\"cname\" name=\"cardname\" placeholder=\"John More Doe\">\n");
      out.write("            <label for=\"ccnum\">Credit card number</label>\n");
      out.write("            <input type=\"text\" id=\"ccnum\" name=\"cardnumber\" placeholder=\"1111-2222-3333-4444\">\n");
      out.write("            <label for=\"expmonth\">Exp Month</label>\n");
      out.write("            <input type=\"text\" id=\"expmonth\" name=\"expmonth\" placeholder=\"September\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-50\">\n");
      out.write("                <label for=\"expyear\">Exp Year</label>\n");
      out.write("                <input type=\"text\" id=\"expyear\" name=\"expyear\" placeholder=\"2018\">\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-50\">\n");
      out.write("                <label for=\"cvv\">CVV</label>\n");
      out.write("                <input type=\"text\" id=\"cvv\" name=\"cvv\" placeholder=\"352\">\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          \n");
      out.write("        <label>\n");
      out.write("          <input type=\"checkbox\" checked=\"checked\" name=\"sameadr\"> Shipping address same as billing\n");
      out.write("        </label>\n");
      out.write("        <input type=\"submit\" value=\"Continue to checkout\" class=\"btn\">\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  </div>\n");
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
