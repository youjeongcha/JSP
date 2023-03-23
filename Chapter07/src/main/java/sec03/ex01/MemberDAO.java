package sec03.ex01;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	/*
	 * private static final String driver = "oracle.jdbc.driver.OracleDriver";
	 * private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	 * private static final String user = "scott"; private static final String pwd =
	 * "tiger";
	 */

	private Connection con;
	//private Statement stmt;
	private PreparedStatement pstmt; 
	private DataSource dataFactory;//추가
	
	//추가
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try
		{
			//connDB();
			con=dataFactory.getConnection();
			String query = "select * from t_member1";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinData = rs.getDate("joinData");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinData);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * private void connDB() { try { Class.forName(driver);
	 * System.out.println("Oracle 드라이버 로딩 성공"); con =
	 * DriverManager.getConnection(url, user, pwd);
	 * System.out.println("Connection 생성 성공"); //stmt = con.createStatement();
	 * //System.out.println("Statement 생성 성공"); } catch(Exception e) {
	 * e.printStackTrace(); } }
	 */
}
