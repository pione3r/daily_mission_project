<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>개인 정보 수정</title>
	<link rel="stylesheet" href="../resources/bootstrap.css" type="text/css"></link>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/free/mission/list"><img src="../resources/dlogo.png" alt="" height="48"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
		<c:url value="/login" var="url" /><a class="nav-link" href="${url}">로그아웃</a>
      </li>
    </ul>
  </div>
</nav>
<div style="margin:20px;">
		<h4 class="card-title" style="font-weight:800; margin-bottom:30px;">개인 정보 수정</h4>
		<form name=form1 action="http://localhost:8080/free/member/modify/" method="post">
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label" style="font-weight:600;">아이디</label>
			  <input type="text" class="form-control" id="formGroupExampleInput" name="id" readonly value="${member.id}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label" style="font-weight:600;">비밀번호</label>
			  <input type="text" class="form-control" id="formGroupExampleInput2" name="passwd" value="${member.passwd}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput2" class="form-label" style="font-weight:600;">유저이름</label>
			  <input type="text" class="form-control" id="formGroupExampleInput3" name="username"  value="${member.username}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">휴대폰 번호</label>
			  <input type="text" class="form-control" id="formGroupExampleInput4" name="mobile" value="${member.mobile}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">이메일 주소</label>
			  <input type="text" class="form-control" id="formGroupExampleInput5" name="email" value="${member.email}">
			</div>
			<input class="btn btn-primary" type="submit" name="submit" value="최종수정">
			<input class="btn btn-danger" style="float: right;" type="reset" name="reset" value="다시 작성">
		</form>
	</div>
</body>
</html>