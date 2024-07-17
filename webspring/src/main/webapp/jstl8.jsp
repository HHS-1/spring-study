<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   	
    <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>   
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String data = "박성현,박세은,서은진,임성민,최하영,최한결";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl Split을 이용하여 출력하기</title>
</head>
<body>
<!-- 문자열을 split을 이용하여 배열로 변환 후, forEach를 이용하여 값 출력 -->
<cr:set var="name" value="<%=data%>"/>
<cr:set var="user" value="${fn: split(name,',')}"/>
<cr:forEach var="z" items="${user}">
${z}
</cr:forEach>
</body>
</html>