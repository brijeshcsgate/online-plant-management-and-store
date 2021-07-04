<%@page import="DBConfig.JDBCFile"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ResultSet rs=null;
    try{
    rs=JDBCFile.executeQuery("select * from product");
    }
    
    catch(Exception ex){
        ex.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getSession().getAttribute("Email")==null){
                response.sendRedirect("login.jsp");
            }
        %>
        <%@include file="navbar.jsp"%>
        <h1>Product List!</h1>
        <table>
            <tr>
                <th>Image</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Description</th>
                <th>Product Brand</th>
                <th></th>
            </tr>
            <%while(rs.next()){%>
            
            <tr>
                <td><img src="<% out.print(rs.getString(13)); %>" alt="<% out.print(rs.getString(11)); %>" width="300px"/></td>
                <td><% out.print(rs.getString(3)); %></td>
                <td><% out.print(rs.getString(11)); %></td>
                <td><% out.print(rs.getString(4)); %></td>
                <td><% out.print(rs.getString(8)); %></td>
                
                <td><a href="addToCart?id=<% out.print(rs.getString(1)); %>&count=1">Add To Cart</a></td>
            </tr>
            <% }rs.close();JDBCFile.closeAll(); %>
        </table>
    </body>
</html>
