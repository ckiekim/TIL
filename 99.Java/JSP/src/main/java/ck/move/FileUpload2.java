package ck.move;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/upload2")
public class FileUpload2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        File currentDirPath = new File("c:/Temp");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(currentDirPath);
        factory.setSizeThreshold(1024*1024);        // 최대 가능한 파일 크기
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        try {
            List items = upload.parseRequest(request);
            for (int i=0; i<items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);
                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName() + "=" + 
                                        fileItem.getString("utf-8"));
                } else {
                    System.out.println("매개변수 이름: " + fileItem.getFieldName());
                    System.out.println("파일 이름: " + fileItem.getName());
                    System.out.println("파일 크기: " + fileItem.getSize());
                    if (fileItem.getSize() > 0) {
                        int idx = fileItem.getName().lastIndexOf("\\");
                        if (idx < 0) {
                            idx = fileItem.getName().lastIndexOf("/");
                        }
                        String fileName = fileItem.getName().substring(idx+1);
                        File uploadFile = new File(currentDirPath + "/" + fileName);
                        fileItem.write(uploadFile);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}