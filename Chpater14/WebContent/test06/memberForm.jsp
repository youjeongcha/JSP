<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="member_action.jsp">
	<h1 style="text-align:center">ȸ�� ����â</h1>
	<table align="center">
	<tr>
		<td width="200">
			<p align="right">���̵�
		</td>
		<td width="400"><input type="text" name="id"></td>
	</tr>
		
	<tr>
		<td width="200">
			<p align="right">��й�ȣ
		</td>
		
		<td width="400"><input type="password" name="pwd"></td>
	</tr>
	
	<tr>
		<td width="200">
			<p align="right">�̸�
		</td>
		
		<td width="400"><input type="text" name="name"></td>
	</tr>
	<tr>
	
		<td width="200">
			<p align="right">�̸���
		</td>
		
		<td width="400"><input type="text" name="email"></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�α���">
			<input type="reset" value="�ٽ� �Է�">
		</td>
	</tr>
</body>
</html>