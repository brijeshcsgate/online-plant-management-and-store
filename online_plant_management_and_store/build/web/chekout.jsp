<%@page import="DBConfig.JDBCFile"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chekout form</title>
    </head>
    <body>
      
    <div class="row">
  <div class="col-75">
    <div class="container">
      
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
  <form action="bill.jsp">
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352">
              </div>
            </div>
          
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label>
        <input type="submit" value="Continue to checkout" class="btn">
      </form>
    </div>
  </div>
  </div>

    </body>
</html>
