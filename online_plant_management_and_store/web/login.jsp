
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login page</title>
        <link rel="stylesheet" href="shop_first.css">
    </head>
    <body><header>E-Commerce</header>
<section><nav>
           <h1>Login Here</h1>
        <%@include file="navbar.jsp"%></nav>
        <article><fieldset><legend><h2>Login Form</h2></legend>

<form action="login" method="post">
  <div class="imgcontainer">
    <img src="img_avatar2.png" alt="Avatar" class="avatar">
  </div><br/><br/><br/>

  <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="u_name" required>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <label ><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="u_pass" required><br/><br/><br/><br/>
        
    <button type="submit">Login</button><br/><br/>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>

</article></section>
        <footer>footer</footer>
    </body>
</html>
