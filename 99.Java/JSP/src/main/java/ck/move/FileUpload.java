package ck.move;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUpload extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rootPath = System.getProperty("catalina.home");
        System.out.println("rootPath: " + rootPath);
        ServletContext ctx = getServletContext();
        String tmpPath = ctx.getInitParameter("tempfile.dir");
        System.out.println("tmpPath: " + tmpPath);
        File file = new File(tmpPath);
        if(!file.exists()) 
            file.mkdirs();
        
        /* Receive file uploaded to the Servlet from the HTML5 form */
        request.setCharacterEncoding("utf-8");
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
//      System.out.println(fileName);
        
        for (Part part : request.getParts()) {
            part.write(tmpPath + File.separator + fileName);
        }
        response.getWriter().print("The file is uploaded sucessfully.");
    }

}