<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<!-- jstl 각종함수 -->
   	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   	<!--  jstl database 관련 사항  -->
   	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 리스트 출력 - ECMA+JSTL</title>
</head>
<body>
<table border="1">
<tr>
<td>번호</td>
<td>영화제목</td>
<td>영화관</td>
<td>예매가격</td>
<td>상영일자</td>
</tr>
<c:set var="count" value="${count}"/>
<c:forEach var="m" items="${all}" varStatus="vs">
<tr>
<td>${count-vs.index}</td>
<td>${m.get(1)}</td>
<td>${m.get(2)}</td>
<td>${m.get(3)}</td>
<td>${m.get(4)}</td>
</tr>
</c:forEach>
</table>
</body>
</html>