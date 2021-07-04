<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Supplier</title>
        <link rel="stylesheet" href="shop_first.css">

    </head>
    <body>
<header>
  <h2>E-commerce web</h2>
</header>

<section>
  <nav>
        <%@include file="navbar.jsp"%></nav><article>
        <h1>Add Supplier information</h1>
         <form action="supplier" method="post">
            Name<input type="text" name="sup_name" value="" /><br/>
            Contact<input type="text" name="sup_contact" value="" pattern="[6789]{1}[0-9]{9}"/><br/>
            <br/><br/><br/><br/>
            <input type="submit" name="submit" value="Submit" />
            <input type="reset" name="reset" value="Reset" />
        </form></article>
</section>
        <footer>
  <p>Footer</p>
</footer>

    </body>
</html>
