<!DOCTYPE html>
<html>
<head>
<title>Category</title>
<link rel="stylesheet" href="shop_first.css">
</head>
<body>

<header>
  <h2>E-commerce web</h2>
</header>

<section>
  <nav> <%@include file="navbar.jsp"%>
  </nav>
  
  <article>
     <fieldset>
         <legend>Add Category</legend><br/><br/>
       <form action="Add_category" method="post">
           Name<input type="text" name="c_name" value="" size="130" /><br/><br/><br/>
            
           
           Image URL<input type="text" name="img_url" value="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    is active<input type="radio" name="active" value="1" checked>
            yes
  <input type="radio" name="active" value="2"> No<br><br/><br/>
  
           <fieldset><legend>  
                Description</legend><textarea name="c_discreption" rows="5" cols="100"></textarea>
      
          </fieldset>  <br/><br/><br/><br/><br/><br/><br/>
            <input type="submit" name="submit" value="Submit" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" name="reset" value="Reset" />
         </form></fieldset></article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>

