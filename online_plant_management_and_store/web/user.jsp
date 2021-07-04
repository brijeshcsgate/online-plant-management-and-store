
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User information</title><link rel="stylesheet" href="shop_first.css">

    </head>
    <body>
<header>
  <h2>E-commerce web</h2>
</header>

<section>
  <nav>
       
        <%@include file="navbar.jsp"%></nav><article>
            <fieldset><legend>User Information</legend><br/><br/>
         <form action="user" method="post">
            Name<input type="text" name="p_name" value="" size="130" /><br/><br/>
           email <input type="text" name="p_email" value="" size="130"/><br/><br/>
            Password<input type="text" name="p_password" value="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            contact Num.<input type="text" name="p_phone" value="" pattern="[6789]{1}[0-9]{9}" /><br/><br/>
           role<input type="text" name="p_role" value="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             enabled<input type="text" name="p_password" value="" /><br/><br/>
            <br/><br/><br/><br/>
            <input type="submit" name="submit" value="Submit" />
            <input type="reset" name="reset" value="Reset" />
        </form></article></section>
         <footer>
  <p>Footer</p>
</footer>


    </body>
</html>
