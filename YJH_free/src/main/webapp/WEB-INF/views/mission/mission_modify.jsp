<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>미션 정보 수정</title>
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
		<h4 class="card-title" style="font-weight:800; margin-bottom:30px;">미션 정보 수정</h4>
		<form name=form1 action="http://localhost:8080/free/mission/modify/" method="post">
			<div style="display:none;" class="mb-3">
			  <label style="display:none;" for="formGroupExampleInput" class="form-label" style="font-weight:600;">id</label>
			  <input style="display:none;" type="text" class="form-control" id="formGroupExampleInput" name="id" readonly value="${mission.id}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label" style="font-weight:600;">미션명</label>
			  <input type="text" class="form-control" id="formGroupExampleInput2" name="missionname" value="${mission.missionname}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput2" class="form-label" style="font-weight:600;">목표</label>
			  <input type="text" class="form-control" id="formGroupExampleInput3" name="goal"  value="${mission.goal}">
			</div>
			<div class="mb-3">
			  <label for="formGroupExampleInput3" class="form-label" style="font-weight:600;">보상</label>
			  <input type="text" class="form-control" id="formGroupExampleInput4" name="reward" value="${mission.reward}">
			</div>
			 <input type="hidden" class="form-control" id="formGroupExampleInput4" name="mission_id" value="${mission.mission_id}">
			<input class="btn btn-primary" type="submit" name="submit" value="최종수정">
			<input class="btn btn-danger" style="float: right;" type="reset" name="reset" value="다시 작성">
		</form>
	</div>
</body>
</html>