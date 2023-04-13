package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getCookies() 메소드를 호출 해 브라우저에게 쿠키 정보를 요청한 후 쿠키 정보를 배열로 가져 옴.
		Cookie[] allValues=request.getCookies();
		
		for (int i = 0; i < allValues.length; i++) {
			if(allValues[i].getName().equals("cookieTest")) {
				out.println("<h2>Cookie 값 가져오기 : " +URLDecoder.decode(allValues[i].getValue(), "utf-8"));
			}
		}
	}

}
