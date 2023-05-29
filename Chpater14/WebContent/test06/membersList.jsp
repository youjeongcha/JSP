<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreeen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
		</tr>
		<c:choose>
		
		<%--   
		ArrayList list =request.getAttribute("membersList");  
		 --%>
		 
		 <c:when test="${ membersList==null}">
			<tr> 
				<td colspan=5>
					<b>등록된 회원이 없습니다.</b>
				</td>
			 </tr>
		</c:when>
		
		<c:when test="${membersList!= null}">
			<c:forEach var="mem" items="${membersList }">
				<tr align="center">
					<td>${mem.id }</td>
					<td>${mem.pwd}</td>
					<td>${mem.name}</td>
					<td>${mem.email}</td>
					<td>${mem.joinDate}</td>
				</tr>
			</c:forEach>
		</c:when>
		</c:choose>
	</table>
	
</body>
</html>