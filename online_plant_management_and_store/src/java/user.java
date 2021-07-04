
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
public class user extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String contact_number,email,enabled,name,password,role;
        
        contact_number = request.getParameter("p_phone");
        email = request.getParameter("p_email");
        enabled = "true";
        name = request.getParameter("p_name");
        password = request.getParameter("p_password");
        role = request.getParameter("p_role");
        String sql="insert into user_detail(contact_number,email,enabled,first_name,password,role) "
                   + "values('"+contact_number+"'"
                           + ",'"
                           + email
                           + "',"
                           + enabled
                           + ",'"
                           + name
                           + "','"
                           + password
                           + "','"
                           + role
                           + "')";
         try
         {
             
             //To add User
           JDBCFile.executeUpdate("insert into user_detail(contact_number,email,enabled,first_name,password,role) "
                   + "values('"+contact_number+"'"
                           + ",'"
                           + email
                           + "',"
                           + enabled
                           + ",'"
                           + name
                           + "','"
                           + password
                           + "','"
                           + role
                           + "')");
           
           //To add cart of user
           ResultSet rs=JDBCFile.executeQuery("select id from user_detail where email='"+email+"'");
           while(rs.next()){
            JDBCFile.executeUpdate("insert into cart(user_id) values('"+rs.getString(1)+"')");
           }
           
           out.println("Values added successfully");
        }
         catch(Exception e){
             out.println("Error while inserting data----->"+e.getMessage()+sql);
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
