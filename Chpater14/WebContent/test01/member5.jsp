<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
   request.setCharacterEncoding("UTF-8");
	// 표현식으로 출력하기 위해 회원 정보 가져옴.
/*    String id=request.getParameter("id");
   String pwd=request.getParameter("pwd");
   String name= request.getParameter("name");
   String email= request.getParameter("email");   */
  
%> 
<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty name="m1" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<jsp:useBean id="membersMap" class="java.util.HashMap"/>

<%
	//membersMap에 회원정보를 key와 value로 저장.
	membersMap.put("id", "park2");
	membersMap.put("pwd", "4321");
	membersMap.put("name", "박지성");
	membersMap.put("email", "park2@test.com");

	MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	memberList.add(m1);
	memberList.add(m2);
	//회원 정보가 저장된 membersList를 membersList라는 key호 membersMap에 저장
	membersMap.put("membersList", memberList);
%>



<html>
	<head>
		<meta charset=”UTF-8">
		<title>회원 정보 출력창</title>
	</head>
	<body>
		<table border="1"  align="center" >
		    <tr align="center" bgcolor="#99ccff">
		      <td width="20%"><b>아이디</b></td>
		      <td width="20%"><b>비밀번호</b></td>
		      <td width="20%"><b>이름</b></td>
		      <td width="20%"><b>이메일</b></td>
		   </tr>
		   
		   
		   <tr align=center>
		      <td>${membersMap.pwd } </td>
		      <td>${membersMap.name } </td>
		      <td>${membersMap.email } </td> 
		   </tr>   
		   <tr align=center>
 		      <td>${membersMap.membersList[0].id } </td>
		      <td>${membersMap.membersList[0].pwd } </td>
		      <td>${membersMap.membersList[0].name } </td>
		      <td>${membersMap.membersList[0].email } </td> 
		   </tr>   
		   <tr align=center>
		      <td>${membersMap.membersList[1].id } </td>
		      <td>${membersMap.membersList[1].pwd } </td>
		      <td>${membersMap.membersList[1].name }</td>
		      <td>${membersMap.membersList[1].email }</td>
		   </tr>
		</table>
	</body>
</html>
