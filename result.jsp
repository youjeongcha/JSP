<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	request.setCharacterEncoding("utf-8");
   String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ���</title>
</head>
<body>
	<h1>�α��� ��� ���</h1>
	<h2>���̵� : <%= id %></h2>
	<h2>��й�ȣ : <%= pw %></h2>
</body>
</html>