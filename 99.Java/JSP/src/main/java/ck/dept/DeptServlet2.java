package ck.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/dept2")
public class DeptServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		DeptDao dao = new DeptDao();
		List<Dept> list = dao.getDepts();
		String data = "<html><head><title>Dept</title></head>";
		data += "<body><table>";
		for (Dept d: list) 
		    data += "<tr><td>" + d.getDid() + "</td><td>" + d.getName() + "</td></tr>";
		data += "</table></body></html>";
		
		PrintWriter out = res.getWriter();
		out.print(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
