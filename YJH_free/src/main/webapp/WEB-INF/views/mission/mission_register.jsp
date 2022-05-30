<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>일일 미션 등록</title>
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
		<c:url value="/mission/register" var="url" /><a class="nav-link" href="${url}">미션 등록</a>
      </li>
      <li class="nav-item active">
		<c:url value="/login" var="url" /><a class="nav-link" href="${url}">로그아웃</a>
      </li>
    </ul>
  </div>
</nav>
	<div style="margin:20px;">
		<h4 class="card-title" style="font-weight:800; margin-bottom:30px;">일일 미션 등록</h4>
		<form name=form1 action="http://localhost:8080/free/mission/register/" method="post">
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label" style="font-weight:600;">미션명</label>
			  <input type="text" class="form-control" id="formGroupExampleInput" name="missionname" placeholder="예?프프과제">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput2" class="form-label" style="font-weight:600;">목표</label>
			  <input type="text" class="form-control" id="formGroupExampleInput2" name="goal"  placeholder="예)빡구현하기">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">보상</label>
			  <input type="text" class="form-control" id="formGroupExampleInput3" name="reward" placeholder="예)치맥 고?">
			</div>
			<input class="btn btn-primary" type="submit" name="submit" value="보내기">
			<input class="btn btn-danger" style="float: right;" type="reset" name="reset" value="다시 작성">
		</form>
	</div>
</body>
</html>