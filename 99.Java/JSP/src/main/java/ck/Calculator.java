package ck;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eval = req.getParameter("eval");
		req.setAttribute("eval", eval);
		rd = req.getRequestDispatcher("calculator.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num_ = req.getParameter("num");
		String op_ = req.getParameter("op");
		ServletContext appl = req.getServletContext();
		Object obj = appl.getAttribute("stack");
		Stack<Object> stack = (obj != null) ? (Stack)obj : new Stack<>();

		if (num_ != null) {
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
			req.setAttribute("eval", getEval(stack));
			rd = req.getRequestDispatcher("calculator.jsp");
			rd.forward(req, resp);
		} else if (op_ != null && !op_.equals("=")) {
			if (op_.equals("C")) {
				String s = (String) stack.pop();
				s = (s.length() == 1) ? "" : s.substring(0, s.length()-1);
				stack.push(s);
			} else 
				stack.push(op_);
			appl.setAttribute("stack", stack);
			req.setAttribute("eval", getEval(stack));
			rd = req.getRequestDispatcher("calculator.jsp");
			rd.forward(req, resp);
		} else {
			int result;
			int num2 = Integer.parseInt((String)stack.pop());
			String op = (String)stack.pop();
			int num1 = Integer.parseInt((String)stack.pop());
			switch(op) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = num1 / num2; break;
			default:  result = 0;
			}
			appl.removeAttribute("stack");
			String str = String.format("%d %s %d = %d", num1, op, num2, result);
			System.out.println(str);
			resp.sendRedirect("/calculator?eval="+result);
		}
	}
	
	protected String getEval(Stack<Object> stack) {
		String eval = "";
		for (Object s: stack)
			eval += (String)s + " ";
		return eval;
	}
}
