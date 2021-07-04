import DBConfig.JDBCFile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class address extends HttpServlet {

    String add_bill,add_ship,city,country,state,isbill,isship,postal_code,user_id;
    Connection con;
    PreparedStatement ps;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String email=request.getSession().getAttribute("Email").toString();
         if(email==null){
             response.sendRedirect("login.jsp");
         }
           user_id="0";
            
            try{
                ResultSet user=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
                user.first();
                user_id=user.getString(1);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
//user_id = request.getParameter("user_id");

        add_bill = request.getParameter("b_address");
        add_ship = request.getParameter("ship_address");
        city = request.getParameter("city");
        country = request.getParameter("country");
        state = request.getParameter("state");
        isbill = request.getParameter("bill_active");
        isship = request.getParameter("ship_active");
        postal_code = request.getParameter("post_code");
       
        
        try {
            String sql="insert into address("
                    + "user_id,"
                    + "address_line_one,"
                    + "address_line_two,"
                    + "city,"
                    + "country,"
                    + "is_billing,"
                    + "is_shipping,"
                    + "postal_code,"
                    + "state) "
                    + "values("
                    + user_id+",'"
                    + add_bill+"','"
                    + add_ship+"','"
                    + city+"','"
                    + country+"',"
                    + isbill+","
                    + isship+",'"
                    + postal_code+"','"
                    + state
                    + "')";
            Date d=new Date();
            String order_date=d.getDate()+"/"+d.getMonth()+"/"+d.getYear();
            JDBCFile.executeUpdate(sql);
            sql="insert into order_detail ("
                    + "billing_id,"
                    + "order_count,"
                    + "order_date,"
                    + "order_total,"
                    + "shipping_id,"
                    + "user_id)"
                    + "values((select id from address where user_id="+user_id+" limit 1),"
                    + "(select cart_lines from cart where user_id="+user_id+" limit 1),"
                    + order_date+","
                    + "(select grand_total from cart where user_id="+user_id+" limit 1),"
                    + "(select id from address where user_id="+user_id+" limit 1),"
                    + user_id+")";
            out.println(sql);
            JDBCFile.executeUpdate(sql);
            
            response.sendRedirect("chekout.jsp");

        } catch (Exception e) {
 out.println("Error while inserting data->" + e.getMessage());

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
