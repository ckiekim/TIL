package ck;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class ImgUpload
 */
@WebServlet("/imageupload")
public class ImgUpload extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tmpPath = "c:/temp/images";
        String callback = request.getParameter("CKEditorFuncNum");
        System.out.println(callback);
        String error = "";
        String url = null;
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(tmpPath));   // 저장할 위치를 File객체로 생성
        factory.setSizeThreshold(1024 * 1024);      // MaxMemorySize 1MB
        ServletFileUpload fu = new ServletFileUpload(factory);
        
        List<FileItem> items;
        try {
            items = fu.parseRequest(request);
            /** 파일 저장 */
            for (FileItem i : items) {
                // 첨부 파일일 때
                if (!i.isFormField() && i.getSize() > 0) {
                    String fileName = i.getName();
                    String now = LocalDateTime.now().toString().substring(0,22).replaceAll("[-T:.]", "");
                    int idx = fileName.lastIndexOf('.');
                    fileName = now + fileName.substring(idx);
                    url = "/bbs/board/download?file=" + tmpPath + "/" + fileName;
                    File uploadFile = new File(url);
                    i.write(uploadFile);    // 임시 파일을 파일로 씀
                    // System.out.println(fileName);
                }
                // 다른 타입 request일 때
                else if (i.isFormField()) {
                    System.out.println(i.getFieldName() + ": " + i.getString("UTF-8"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String data = "<script> "
                + "     window.parent.CKEDITOR.tools.callFunction(" 
                +           callback + ", '" + url + "', '');"
                + " </script>";
        System.out.println(data);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(data);
	}

}
