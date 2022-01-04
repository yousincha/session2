<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>sessionMain</title>
</head>
<body>
<%
	String id=(String)session.getAttribute("id");
	if(id==null || id.equals(""))
		response.sendRedirect("sessionLoginForm.jsp");
	else{
%>
	<b><i> <%=id %></i></b>님이 로그인 했습니다.
	<form method="post" action="sessionLogout.jsp">
		<input type="submit" value="로그아웃">
	</form>

<%		
	}
%>
</body>
</html>