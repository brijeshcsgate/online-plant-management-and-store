<%@page import="DBConfig.JDBCFile"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getSession().getAttribute("Email")==null){
                response.sendRedirect("login.html");
            }
        %>
        <%
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
        %>
     
        <h1>Your Selected product Detals</h1>
        <table>
            <tr>
                <th>cart_id</th>
                <th>Product id</th>
                <th>Product Price</th>
                <th>count</th>
                <th>total</th>
                <th></th>
            </tr>
            <%while(rs.next()){%>
            
            <tr>
                <td><% out.print(rs.getString(2)); %></td>
                <td><% out.print(rs.getString(4)); %></td>
                <td><% out.print(rs.getString(3)); %></td>
                <td><% out.print(rs.getString(5)); %></td>
                     <td><% out.print(rs.getString(3)); %></td>
                
                         </tr>
                <td></td>         
               <% } %>          
                        </table>
                        <label>Grand Total:-<% out.print(cart.getString(3)); %></label>       
            <% rs.close();JDBCFile.closeAll(); %>
            <a href="Address.jsp" style="display:inline-block;pading:20px;text-decoration: none;background: yellow">Proceed Checkout</a>
    </body>
</html>
