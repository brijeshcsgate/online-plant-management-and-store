<%@page import="DBConfig.JDBCFile"%>
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
            ResultSet user=null;
            ResultSet address=null;
            try{
                user=JDBCFile.executeQuery("select * from user_detail where email='"+email+"'");
                user.first();
                
                cart=JDBCFile.executeQuery("select * from cart where user_id="+user.getString(1));
                cart.first();
                
                address=JDBCFile.executeQuery("select * from address where user_id="+user.getString(1));
                address.last();
                
                cartId=cart.getInt(1);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
          ResultSet rs=null;
          try{
            rs=JDBCFile.executeQuery("select * from cart_line where cart_id="+cartId);
            
           
           while(rs.next()){
                   String sql="insert into order_item("
                           + "order_id,"
                           + "product_id,"
                           + "product_count,"
                           + "buying_price,"
                           + "total)"
                           + "values("
                           + "(select id from order_detail  where user_id="+user.getString(1)+" limit 1),"
                           + rs.getString(4)+","
                           + rs.getString(5)+","
                           + rs.getString(6)+","
                           + rs.getString(3)+")";
           JDBCFile.executeUpdate(sql);
           //out.print("done");
                }
            }
          catch(Exception ex){
            ex.printStackTrace();
            }
        %>
        
        <pre>
            Email:-<% out.println(email); %>
            User Name:-<% out.println(user.getString(2)); %>
            Contact Number:-<% out.println(user.getString(8)); %>
            Address:-
                Billing Address:-<% out.println(address.getString(3)); %>
                Shipping Address:-<% out.println(address.getString(4)); %>
                    
                    Country:-<% out.println(address.getString(7)); %>
                    State:-<% out.println(address.getString(6)); %>
                    City:-<% out.println(address.getString(5)); %>
                    Pin-Code:-<% out.println(address.getString(8)); %>


                    <%
                         ResultSet orderDetail=JDBCFile.executeQuery("select * from order_detail  where user_id="+user.getString(1));
                        orderDetail.last();
                        ResultSet bill=JDBCFile.executeQuery("SELECT name,brand,buying_price,product_count,total FROM order_item as o INNER join product as p on o.product_id=p.id WHERE order_id=(select id from order_detail  where user_id="+user.getString(1)+" limit 1) ");
                       
                      
                    %>
                   
        </pre>
                    <table width="100%" border="1px">
                        <tr>
                            <th>Product Name</th>
                            <th>Brand</th>
                            <th>Buying price</th>
                            <th>Quantity</th>
                            <th>Sub Total</th>
                        </tr>
                        <%
                        while(bill.next()){
                        %>
                        <tr>
                            <td><% out.print(bill.getString(1)); %></td>
                            <td><% out.print(bill.getString(2)); %></td>
                            <td><% out.print(bill.getString(3)); %></td>
                            <td><% out.print(bill.getString(4)); %></td>
                            <td><% out.print(bill.getString(5)); %></td>
                        </tr>
                        <% } %>
                        
                        
                    </table>
                         <label>Grand Total:-<% out.print(orderDetail.getString(3)); %></label>
    </body>
</html>
