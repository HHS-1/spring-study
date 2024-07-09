<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSTL(core) : JSTL 엔진 , JSTL(functions) : JSTL 함수모음 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    <!-- 
    JSTL => JSP 변수로 이관 불가능
    JSP => JSTL 변수로 이관 가능    
   	
   	1. do에서 ArrayList로 배열을 이관했을 경우 forEach - 추천
   	2. do에서 ArrayList로 배열을 이관했을 경우 JSP로 ArrayList를 받은 후 JSTL로 전달
     -->
    <%
    	String data[] = {"a1","a2","a3"};
    	int ea = data.length;
    	request.setAttribute("data", data);
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 사용법</title>
</head>
<body>
<!-- set: setattribute를 이용하여 JSP에 있는 변수를 JSTL 변수값으로 변환  -->
<c:set var="jstl_ea" value="<%=ea %>"></c:set>
<!-- JSTL : forEach로 반복문 많이 씀(var : 값, begin : 시작 값, end : 종료 값) -->
<c:forEach var="no" begin="1" end="5">
${no}
</c:forEach>
데이터의 총 개수 ${jstl_ea}
<br>
<ol>
<!-- 배열출력시 forEach의 기본은 int로 해야하며, String은 안 됨
String을 사용하고 싶을 경우 클래스 배열을 활용하여 출력 또는 setAttribute를 이용
배열 데이터 전용 속성 : items
 -->
 <!-- JSP에 setATtribute를 이용하여 JSTL로 items에 값을 넣어서 처리 .. 안 쓰는 게 좋음-->
<c:forEach var="arr" items="${data}" >
<li>${arr}</li>
</c:forEach>
</ol>
</body>
</html>