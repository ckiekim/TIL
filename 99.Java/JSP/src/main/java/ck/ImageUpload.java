package ck;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/imageupload2")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ImageUpload {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tmpPath = "c:/Temp/images";
        String callback = request.getParameter("CKEditorFuncNum");
        System.out.println(callback);
        String error = "";
        String url = null;
        Part filePart = request.getPart("file");
        if (filePart == null) {
            System.out.println("No files uploaded.");
        } else {
            String fileName = filePart.getSubmittedFileName();
            String now = LocalDateTime.now().toString().substring(0,22).replaceAll("[-T:.]", "");
            int idx = fileName.lastIndexOf('.');
            fileName = now + fileName.substring(idx);
            url = tmpPath + File.separator + fileName;
            System.out.println("fileName: " + fileName);
    
            for (Part part : request.getParts()) {
                part.write(url);
            }
        }
        
        String data = "<script> "
                + "     window.parent.CKEDITOR.tools.callFunction(" 
                +           callback + ", '" + url + "', '');"
                + " </script>";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(data);
    }
}
