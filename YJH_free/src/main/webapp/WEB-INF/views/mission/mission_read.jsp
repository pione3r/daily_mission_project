<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>일일 미션 정보</title>
	<link rel="stylesheet" href="../resources/mission.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>일일 미션 정보</header><br>
		<table>
			<tr><th> 미션명 </th><td><c:out value="${mission.missionname}"/></td></tr>
			<tr><th> 목표 </th><td><c:out value="${mission.goal}"/></td></tr>
			<tr><th> 보상 </th><td><c:out value="${mission.reward}"/></td></tr>
		</table>
		<c:url value="/mission/list" var="url"/><a href="${url}">미션 목록 보기</a>
	</div>
</body>
</html>