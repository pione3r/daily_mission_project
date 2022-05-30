<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생 등록</title>
	<link rel="stylesheet" href="./resources/bootstrap.css" type="text/css"></link>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/free/login"><img src="./resources/dlogo.png" alt="" height="48"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

</nav>
	<div style="margin:20px;">
		<h4 class="card-title" style="font-weight:800; margin-bottom:30px;">회원 가입</h4>
		<form name=form1 action="http://localhost:8080/free/register/" method="post">
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label" style="font-weight:600;">아이디</label>
			  <input type="text" class="form-control" id="formGroupExampleInput" name="id" placeholder="공백없이 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput2" class="form-label" style="font-weight:600;">비밀번호</label>
			  <input type="text" class="form-control" id="formGroupExampleInput2" name="passwd"  placeholder="공백없이 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">유저이름</label>
			  <input type="text" class="form-control" id="formGroupExampleInput3" name="username" placeholder="공백없이 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">휴대폰 번호</label>
			  <input type="text" class="form-control" id="formGroupExampleInput4" name="mobile" placeholder="***-****-****">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">이메일 주소</label>
			  <input type="text" class="form-control" id="formGroupExampleInput5" name="email" placeholder="****@****.***">
			</div>
			<input class="btn btn-primary" style="float: right;" type="submit" name="submit" value="보내기">
			<!-- <input class="btn btn-danger" style="float: right;" type="reset" name="reset" value="다시 작성">-->
		</form>
	</div>
</body>
</html>