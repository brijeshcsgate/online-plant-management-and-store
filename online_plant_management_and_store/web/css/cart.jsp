
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Detail</title><link rel="stylesheet" href="shop_first.css">

    </head>
    <body>
<header>
  <h2>E-commerce web</h2>
</header>

<section>
  <nav>
        <h1>Cart Details</h1>
        <%@include file="navbar.jsp"%>
</nav>
  
  <article>        <form action="cart" method="post">
            <table>
                <tr><td>Product</td>
                <td><input type="text" name="product" value=""></td>
                </tr>
                <tr><td>email</td>
                    <td><input type="text" name="email" value="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td>
                </tr>
                <tr><td>Grand Total</td>
                <td><input type="text" name="g_total" value=""></td>
                </tr>
                <tr><td>status</td>
                <td><input type="text" name="status" value=""></td>
                </tr>
            </table>
 <input type="submit" name="submit" value="Submit" />
            <input type="reset" name="reset" value="Reset" />
       
            </form></article><footer>footer</footer>
    </body>
</html>
