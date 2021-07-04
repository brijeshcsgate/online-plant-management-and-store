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
public class cartLine extends HttpServlet {

 

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int cartId=0;
        try {
            
        String email=request.getSession().getAttribute("Email").toString();
          ResultSet rs=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
          
          while(rs.next()){
           ResultSet rs1=JDBCFile.executeQuery("select id from cart where user_id="+rs.getString(1));
           while(rs1.next()){
               cartId=rs1.getInt(1);
                JDBCFile.executeUpdate("insert into cart_line(cart_id) values('"+rs1.getString(1)+"')") ;
           }
          }
          
         
      //ResultSet rs=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
     //      while(rs.next()){
     //       JDBCFile.executeUpdate("insert into cart(user_id) values('"+rs.getString(1)+"')");
    //       }
           
    //       out.println("Values added successfully");
     //   }/////
        }
        catch(Exception ex){
            
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
