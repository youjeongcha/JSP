package sec03.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContxtFileServlet
 */
@WebServlet("/cfile")
public class ContxtFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//ServletContext 객체를 가져옴
		ServletContext context = getServletContext();
		
		//해당 위치의 파일ㅇ르 읽어 옴.
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

		String menu = null;
		String menu_member = null;
		String menu_oreder = null;
		String menu_goods = null;
		
		while((menu=buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu,",");
			menu_member =tokens.nextToken();
			menu_oreder =tokens.nextToken();
			menu_goods =tokens.nextToken();
		}
		
		out.print("<html><body>");
		out.print(menu_member + "<br>");
		out.print(menu_oreder + "<br>");
		out.print(menu_goods + "<br>");
		out.print("</body></html>");
	}

}
