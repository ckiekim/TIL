package ck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		int cnt = 3;
		String cnt_ = req.getParameter("cnt");
		if (cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		for(int i=0; i<cnt; i++)
			out.println("<h1>안녕하세요?</h1>");
	}
}
