package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;


/**
 * Servlet implementation class SetCookievalue
 */
@WebServlet("/set")
public class SetCookievalue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		
		//Cookie 객체를 생성한 후 cookieTest 이름으로 하늘 정보를 인코딩하여 쿠키에 저장
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP Programming.","utf-8"));
		
		//유효기간 설정 24시간
		c.setMaxAge(24*60*60);
		
		//새엇ㅇ된 쿠기를 브라우저로 전송.
		response.addCookie(c);
		out.println("현재시간 : " + d);
		out.println("문자열을 Cookie에 저장합니다.");
	}

}
