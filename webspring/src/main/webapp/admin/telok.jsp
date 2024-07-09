<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSTL(core) : JSTL 엔진 , JSTL(functions) : JSTL 함수모음 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    <!-- 
    JSTL => JSP 변수로 이관 불가능
    JSP => JSTL 변수로 이관 가능    
   	
     -->
    <%
    	String data[] = {"a1","a2","a3"};
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 사용법</title>
</head>
<body>
<!-- JSTL : forEach로 반복문 많이 씀(var : 값, begin : 시작 값, end : 종료 값) -->
<c:forEach var="no" begin="1" end="5">
${no}
</c:forEach>
</body>
</html>