package ck.move;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileRead
 */
@WebServlet("/read")
public class FileRead extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    ServletContext context = getServletContext();
	    InputStream is = context.getResourceAsStream("/WEB-INF/temp/test.txt");
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    String addr = "";
	    while (true) {
	        String buffer = br.readLine();
	        System.out.println(buffer);
	        if (buffer == null)
	            break;
	        addr += buffer;
	    }
	    
	    response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>File: " + addr + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
