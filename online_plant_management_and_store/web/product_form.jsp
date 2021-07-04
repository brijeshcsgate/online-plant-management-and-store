<%@page import="java.sql.ResultSet"%>
<%@page import="DBConfig.JDBCFile" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product Category</title>
        <link rel="stylesheet" href="shop_first.css">
    </head>
    <body>
        <header>
            <h2>E commerce web</h2>
        </header>
        <section>  
        <nav>   
           <%@include file="navbar.jsp"%>    
        </nav>     
        <article>              
            <fieldset>
                <legend>Product Information</legend><br/>   
                <form action="product" method="get" border="10px">
                    <pre>
                    Product name<input type="text" name="p_name" value="" />
                    Product Brand<input type="text" name="p_brand"/>  
                    Category  <select name="p_category">
                    <% 
                        ResultSet rs=JDBCFile.executeQuery("select id,name from category");
                        while(rs.next()){
                    %>    
                    <option value="<%out.print(rs.getString(1));%>"><%out.print(rs.getString(2));%></option>
                    <%}%>
                    </select>
                    Product Quantity<input type="text" name="p_quantity" value="" />
                    Product Price<input type="text" name="p_price" value="" />
                    Supplier id<input type="text" name="Supplier_id" value="" />
          
                    <fieldset>
                        <legend>Description</legend>
                        <textarea name="p_discription" rows="5" ></textarea>
                    </fieldset>  
                    <input type="submit" name="submit" value="Submit" /><br/><br/>
                    </pre>
                </form>
            </fieldset>     
        
           </article>
         </section>
        <footer><p>Footer</p></footer>
    </body>
</html>
