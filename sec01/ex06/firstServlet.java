package sec01.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class firstServlet
 */
@WebServlet("/first6")
public class firstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); //추가
		response.setContentType("text/html;charset=utf-8");
		
		//포워드를 할때 요청 방식에 따라 메소드가 달라진다.
		RequestDispatcher dispatch = request.getRequestDispatcher("second6?name=kim");
		dispatch.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
