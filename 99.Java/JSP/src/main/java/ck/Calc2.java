package ck;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	private static final long serialVersionUID = 6615878883486878198L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num_ = req.getParameter("num");
		String op_ = req.getParameter("op");
		ServletContext appl = req.getServletContext();
		Object obj = appl.getAttribute("stack");
		Stack<Object> stack = (obj != null) ? (Stack)obj : new Stack<>();
		int num1, num2, result;

		if (num_ != null) {
			System.out.println(num_);
			if (stack.isEmpty()) {
				stack.push(num_);
			} else {
				String element = (String) stack.pop();
				if (element.equals("/") || element.equals("*")
						|| element.equals("-") || element.equals("+")) {
					stack.push(element);
					stack.push(num_);
				} else {
					num_ = element + num_;
					stack.push(num_);
				}
			}
			appl.setAttribute("stack", stack);
		} else if (op_ != null && !op_.equals("=")) {
			System.out.println(op_);
			if (op_.equals("C")) {
				String s = (String) stack.pop();
				s = (s.length() == 1) ? "" : s.substring(0, s.length()-1);
				stack.push(s);
			} else 
				stack.push(op_);
			appl.setAttribute("stack", stack);
		} else {
			num2 = Integer.parseInt((String)stack.pop());
			String op = (String)stack.pop();
			num1 = Integer.parseInt((String)stack.pop());
			switch(op) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = num1 / num2; break;
			default:
				result = 0;
			}
			appl.removeAttribute("stack");
			String str = String.format("%d %s %d = %d", num1, op, num2, result);
			System.out.println(str);
		}
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		resp.sendRedirect("calc2.html");
	}
}
