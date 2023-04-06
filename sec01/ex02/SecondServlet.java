package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//getParameter() 메서드를 이용하여 전송된 회원 정보를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//hidden 태그로 전송된 값을 가져온다.
		String user_address = request.getParameter("user_address");
		/*
		 * String user_email = request.getParameter("user_email"); String user_hp =
		 * request.getParameter("user_hp");
		 */
		out.println("<html><body>");
		if (user_id!= null && user_id.length()!=0) {
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번째 서블릿에서 넘겨준 아이디 : " + user_id  +"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 비밀번호 : " + user_pw  +"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 주소 : " + user_address  +"<br>");
			out.println("</body></html>");
		} else {
			out.println("로그인 하지 않았습니다.<br></br>");
			out.println("다시 로그인하세요.<br>");
			out.println("<a href='/Chapter09/login2.html'>로그인창으로 이동하기 </>");
		}
	}

}
