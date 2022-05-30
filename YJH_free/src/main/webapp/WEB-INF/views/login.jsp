<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title> 
	<link rel="stylesheet" href="./resources/bootstrap.css" type="text/css"></link>
	<link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css" type="text/css"></link>
	<script type="text/javascript">
		// 아이디, 비밀번호가 입력되었는지 확인
		function checkValue()
		{
			if(!document.form1.id.value){
				alert("아이디를 입력하세요.");
				return false;
			}
			
			if(!document.form1.passwd.value){
				alert("비밀번호를 입력하세요.");
				return false;
			}
		}
		
		window.onload = function() {
			
			var loginFail = <%=session.getAttribute("loginFail")%>;
			
			if(loginFail) {
				alert("login fail");
				
				<%session.setAttribute("loginFail", false);%>
				
				return false;
			}
		}

	</script>
</head>
<body class="text-center">
	<div align=center>
		<img class="mb-4" src="./resources/dlogo.png" alt="" width="72" height="72">
		<!--<header class="h3 mb-3 font-weight-normal">로그인</header>-->
		<form name=form1 class=form-signin action="http://localhost:8080/free/login/" method="post" onsubmit="return checkValue()">
		<table>	
			<td><input type="text" class="form-control" name="id" autofocus placeholder="ID"></td></tr>
			<td><input type="password" class="form-control" name="passwd" placeholder="PASSWORD"></td></tr>
		</table>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
		<c:url value="/register" var="url" /><a class="nav-link" href="${url}">회원가입</a>
		
	</div>
</body>
</html>