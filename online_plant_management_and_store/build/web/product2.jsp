
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
            
       <nav>   <%@include file="navbar.jsp"%>    </nav>     
        <article>              
            <fieldset>
                <legend>Product Information</legend><br/>
                
       <form action="product" method="post" border=10px  enctype="multipart/form-data" >
      Product name    <input type="text" name="p_name" value="" size="130"/><br/><br/>
                 
      Product Brand<input list="browsers" name="p_brand">
    
  <datalist id="browsers">
    <option value="Internet Explorer">
  </datalist>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
  Category  <input list="browsers" name="p_category"><br/><br/>
  <datalist id="browsers">
    <option value="Internet Explorer">
  </datalist>
  
  <!--Product Code<input type="text" name="p_code" value="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  accept="image/*"         enctype="multipart/form-data" -->
  Product Image <input type="file" name="p_image"   >     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Product Quantity<input type="text" name="p_quantity" value="" /><br/><br/>
           
  Product Price<input type="text" name="p_price" value="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    is active<input type="radio" name="active" value="true" checked>
            yes
  <input type="radio" name="active" value="false"> No<br><br/>
  
            Purchases<input type="text" name="p_purchases" value="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            Supplier id<input type="text" name="Supplier_id" value="" /><br/><br/>
          
        <fieldset><legend>  
                Description</legend><textarea name="p_discription" rows="5" cols="100"></textarea><br/><br/>
      
          </fieldset>  
            
            
            <input type="submit" name="submit" value="Submit" /><br/><br/>
            </form>
                      </fieldset>     
        
           </article>
         </section>
         <footer>
  <p>Footer</p>
</footer>

    </body>
</html>
