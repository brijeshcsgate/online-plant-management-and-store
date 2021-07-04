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
         <legend>Add Address</legend><br/><br/>
       <form action="address" method="post">
      
      country <label for="country">Country</label>
    <select id="country" name="country">
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select><br/><br/>

      Bill Address<input type="text" name="b_address" value="" size="130" /><br/><br/>
       Ship Address<input type="text" name="ship_address" value="" size="130" /><br/><br/>
      State <label for="state">State</label>
    <select id="state" name="state">
      <option value="australia">Aust</option>
      <option value="canada">Can</option>
      <option value="usa">USA</option>
    </select>

      city <label for="city">City</label>
    <select id="city" name="city">
      <option value="a">Au</option>
      <option value="c">Ca</option>
      <option value="u">U</option>
    </select>

           
          Postal code<input type="text" name="post_code" value="" />
    is Billing<input type="radio" name="bill_active" value="1" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            yes
  <input type="radio" name="active" value="0"> No<br><br/>
  is Shiping<input type="radio" name="ship_active" value="1"/>
            yes
            <input type="radio" name="active" value="0"> No<br><br/>
  
            <input type="submit" name="submit" value="Submit" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" name="reset" value="Reset" />
         </form></fieldset></article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>

