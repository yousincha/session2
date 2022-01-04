<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionLoginForm</title>
</head>
<body>
	<form method="post" action="sessionLoginPro.jsp">
	아이디: <input type="text" name="id"><br>
	비밀번호: <input type="password" name="passwd"><br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onClick="Location.href='insertMemeberForm.jsp'">
	</form>
</body>
</html>