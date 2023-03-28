package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(request, response);
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(request, response);
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException { // TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		List<MemberVO> list = dao.listMembers();

		/* 추가 */
		String command = request.getParameter("command");

		if (command != null && command.equals("addMember")) 
		{
			String _id = request.getParameter("id");
			String _pw = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");

			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pw);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
		}
		else if (command != null && command.equals("delMember")) 
		 { 
			 String id = request.getParameter("id"); 
			 dao.delMember(id); 
		 }
		
		List<MemberVO> list1 = dao.listMembers();

		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");

		for (int i = 0; i < list1.size(); i++) 
		{
			MemberVO memberVO = (MemberVO)list1.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" 
			+ pwd + "</td><td>" + name + "</td><td>" 
			+ email + "</td><td>" + joinDate + "</td></tr>"
			+ "<a href='/Chapter07/member4?command=delMember&id=" + id + "'>삭제 </a></td></tr>");
		}
		out.print("</table></body></html>");

		/* 추가 */
		out.print("<a href='/Chapter07/memberForm.html'> 새 회원 등록하기</a>");
	}
}
