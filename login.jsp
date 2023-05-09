<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 창</title>
</head>
<body>
	<form name="LoginForm" method="post" action="result3.jsp">
	아이디 : <input type="text" name="user_id">
	비밀번호 : <input type="passwaord" name="user_pw">
	<br><br>
	<input type="submit" value="로그인">
	<input type="reset" value="다시 입력">
	</form>
</body>
</html>