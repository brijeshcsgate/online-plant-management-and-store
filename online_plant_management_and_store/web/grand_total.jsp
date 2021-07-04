<%@page import="DBConfig.JDBCFile"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ResultSet rs=null;
    try{
     rs=JDBCFile.executeQuery("select * from cart");
   
    }
    
    catch(Exception ex){
        ex.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getSession().getAttribute("Email")==null){
                response.sendRedirect("login.html");
            }
        %>
     
        <h1>Your Selected product Detals</h1>
        <table>
            <tr>
            </tr>
            <%while(rs.next()){%>
            
            <tr>
                <td><% out.print(rs.getString(3)); %></td>
                
                         </tr>
                <td></td>         
                         
                                     
            <% }rs.close();JDBCFile.closeAll(); %>
        </table>
    </body>
</html>
