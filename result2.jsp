<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
   String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 결과</title>
</head>
<body>
	<h1>로그인 결과 출력</h1>
	<% //스킓트 릿 (자바를 코드를 혼영할때 자바 코드에 씌워준다)
		if (id == null || id.length() == 0)
		{
	%>
			아이디를 입력 하세요. <br>
			<a href="Chapter12/Login.html"> 로그인하기 </a>
			
	<%
		} else {
	%>
			<h2> <%= id%>님 환영합니다.</h2>
	<%
		}
	%>
	
	<h2>아이디 : <%= id %>님 환영합니다.</h2>
	<h2>비밀번호 : <%= pw %></h2>
</body>
</html>