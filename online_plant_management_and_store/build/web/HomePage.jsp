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
      <section> 
          <article>
              
                       <h1>Product List!</h1>
                     

                       
                       
                       
                       
        <table width="600px">
            <%
                int count=0;
                while(rs.next()){%>
            
                  <div class="card">
                       <img src="<% out.print(rs.getString(13)); %>" alt="<% out.print(rs.getString(11)); %>" width="100px"/>
  <h1><% out.print(rs.getString(3)); %></h1>
  <p class="price"><% out.print(rs.getString(11)); %><br/>
                </p>
  <p><% out.print(rs.getString(4)); %></p>
  <p><button><a href="productList.jsp">Add To Cart</a></button></p>
</div>
  <% if(count%3==0){ out.print("<br/>");} %>
            
            <% count++; }rs.close();JDBCFile.closeAll(); %>
        </table>
   
    
          </article>
    </section>      <footer>footer</footer>
    </body>
</html>
