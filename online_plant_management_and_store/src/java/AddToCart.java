/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBConfig.JDBCFile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RS
 */
public class AddToCart extends HttpServlet {

 

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("hi in addtocart");
        String prod_id=request.getParameter("id");
        int count=Integer.parseInt(request.getParameter("count"));
        int cartId=0;
        String email="";
        try {
          if(request.getSession().getAttribute("Email")!=null){  
            email=request.getSession().getAttribute("Email").toString();
          }
          else{
              response.sendRedirect("login.jsp");
          }
          ResultSet user=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
          user.first();
            
            ResultSet cart=JDBCFile.executeQuery("select id from cart where user_id="+user.getString(1));
            cart.first();
            
            cartId=cart.getInt(1);
            
            
            ResultSet rs2=JDBCFile.executeQuery("select unit_price from product where id="+prod_id);
            rs2.first();
           
            ResultSet cartLines=JDBCFile.executeQuery("select product_count,buying_price from cart_line where product_id="+prod_id);
            System.out.print(cartLines.getFetchSize());
            
            cartLines.last();
            if(cartLines.getRow()>0){
                
                cartLines.first();
                int new_count=cartLines.getInt(1)+count;
                
                int total=new_count*cartLines.getInt(2);
                
                JDBCFile.executeUpdate("update cart_line set product_count="+new_count
                        
                       + ", total="+total+" where product_id="+prod_id) ;
            }
            else{
                int total= count*rs2.getInt(1);
                JDBCFile.executeUpdate("insert into cart_line(cart_id,product_id,buying_price,product_count,total) "
                        + "values ("
                       + "'"+cartId+"','"
                        + prod_id+ "','" 
                        + rs2.getInt(1)+"',"
                        + count+ ","
                        + total+ ")") ;
            }
                                
                
                
                
                JDBCFile.executeUpdate("update cart set cart_lines=(SELECT count(id) FROM `cart_line` WHERE cart_id="+cartId+"),"
                        + "grand_total=(SELECT sum(total) FROM `cart_line` WHERE cart_id="+cartId+") "
                                + "where id="+cartId);
           
           System.out.println("Values added successfully");
          
          response.sendRedirect("cart_details.jsp");
    
          

// .........    JDBCFile.executeUpdate("insert into cart_line(cart_id) values('"+rs1.getString(1)+"')") ;
     
     
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
