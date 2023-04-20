package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		//한글 전송 시 인코딩 자겁 생략 - Filter로 처리
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//getParameter() 메서드를 이용하여 전송된 회원 정보를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if(session.isNew()) {
			//세션에 바인딩 시 미리 HttpSessionBindingListener를 구현한
			//LoginImpl의 valueBoun() 메서드 호출.
			session.setAttribute("loginUser", loginUser);
		}
		out.println("<head>");
		out.println("<script type = 'text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");
		out.println("</script>");
		out.println("</head>");
		
		out.println("<html><body>");
		out.println("아이디 : " + loginUser.user_id + "<br>");
		out.println("총 접속자수 : " + LoginImpl.total_user + "<br>");
		out.println("</body></html>");
	}

}
