
<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${code}</h1>
        <form action="#" method="post" enctype="multipart/form-data">
            <input type="file" name="image"/>
            <input type="submit" value="Submit"/>
        </form>
        <%


int maxFileSize=50*1024;
int maxMemSize=4*1024;
File file;

            boolean  isMultipart=ServletFileUpload.isMultipartContent(request);
             String ABS_PATH="C:\\Users\\RS\\Documents\\shopping\\web\\images\\";
            if(isMultipart){
                try{ 
                DiskFileItemFactory factory=new DiskFileItemFactory();
            
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("c:\\temp"));
            
            ServletFileUpload upload=new ServletFileUpload(factory);
            
            upload.setFileSizeMax(maxFileSize);
            
            List fileitems=upload.parseRequest(request);
            
            Iterator i=fileitems.iterator();
            
            while(i.hasNext()){
                FileItem fi=(FileItem)i.next();
                
                if(!fi.isFormField()){
                String fileName=request.getParameter("image");    
                    
                    
                    
                    
                    
                    if(fileName.lastIndexOf("\\")>=0){
                        file=new File(ABS_PATH+fileName.substring(fileName.lastIndexOf("\\")));
                    }
                    else{
                        file=new File(ABS_PATH+fileName.substring(fileName.lastIndexOf("\\")+1));
                    }
                    fi.write(file);

                  out.println("All Done");
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
            }
        %>
    </body>
</html>
