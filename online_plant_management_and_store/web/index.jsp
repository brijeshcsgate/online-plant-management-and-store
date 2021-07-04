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
        <title>home page</title>
        <link rel="stylesheet" href="shop_first.css">
    </head>
    <body>
        <header>E-Commerce</header>
      <section>  <nav> <%@include file="navbar.jsp"%></nav>
          <article>
              
                       <h1>Product List!</h1>
        <table width="600px">
            <tr>
            <%
                int count=0;
                while(rs.next()){%>
            
            
                <td><img src="<% out.print(rs.getString(13)); %>" alt="<% out.print(rs.getString(11)); %>" width="300px"/>
                <% out.print(rs.getString(3)); %><br/>
                <% out.print(rs.getString(11)); %><br/>
                <% out.print(rs.getString(4)); %><br/>
                <% out.print(rs.getString(8)); %><br/>
                
                <a href="productList.jsp">Add To Cart</a></td>
            <% if(count%3==0){ out.print("</tr><tr>");} %>
            <% count++; }rs.close();JDBCFile.closeAll(); %>
                </tr>
        </table>
   
    
          </article>
    </section>      <footer>footer</footer>
    </body>
</html>
