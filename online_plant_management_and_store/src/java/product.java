import DBConfig.JDBCFile;
import java.io.File;
import java.util.UUID;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class product extends HttpServlet {

   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 50 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = getServletContext().getInitParameter("file-upload"); 
   }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
          String p_code="PRD"+UUID.randomUUID().toString().substring(25).toUpperCase();
          boolean isactive=true;
          
          String p_name = request.getParameter("p_name");
        
          String p_quantity = request.getParameter("p_quantity");
          
          String p_discription = request.getParameter("p_discription");
          
          String p_brand = request.getParameter("p_brand");
          
          String p_category = request.getParameter("p_category");
          
          //String p_image = request.getParameter("p_image");
          
          String p_price=request.getParameter("p_price");
          
          String p_purchases="0";
                  //request.getParameter("p_purchases");
          
          String supplier_id=request.getParameter("Supplier_id");
        
            String sql="insert into product(brand,category_id,code,description,is_active,name,purchases,quantity,supplier_id,unit_price) "
                    + "values('"+p_brand+"',"+p_category+",'"+p_code+"','"+p_discription+"',"+isactive
                    +",'"+p_name+"',"+p_purchases+","+p_quantity+","+supplier_id+","+p_price+")";
        try {
            
           JDBCFile.executeUpdate(sql);
                   JDBCFile.closeAll();
//            out.println("Category Addded successfully"+sql);
            out.println(
"<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>home page</title>\n" +
"        <link rel=\"stylesheet\" href=\"shop_first.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <header>E-Commerce</header>\n" +
"      <form method='post' action='product?id="+p_code+"' enctype='multipart/form-data'>"
                    + "File<input type='file' name='photo'/>"
                    + "<input type='submit' value='upload'/>"
                    + "</form>\n" +

"     <footer>footer</footer>\n" +
"    </body>\n" +
"</html>\n" +
"");
        } catch (Exception e) {
 out.println("Error while inserting data->" + e.getMessage()+sql);

        }
       // request.setAttribute("code", p_code);
        //request.getRequestDispatcher("FileUpload.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println(request.getParameter("id"));
        String code=request.getParameter("id");
        
//String filepath="C:\\Users\\RS\\Documents\\shopping\\web\\images\\"+code+".jpg";
        // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
   
      if( !isMultipart ) {
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }
  
      DiskFileItemFactory factory = new DiskFileItemFactory();
   
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
   
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
   
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);
	
         // Process the uploaded file items
         Iterator i = fileItems.iterator();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
   
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               String contentType = fi.getContentType();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
               JDBCFile.executeUpdate("update product set product_image='"+("images/"+fileName)+"' where code='"+code+"'");
               out.println("Uploaded Filename: " + fileName + "<br>");
            }
         }
         out.println("</body>");
         out.println("</html>");
         } catch(Exception ex) {
            System.out.println(ex);
         }
        
   
       // processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
