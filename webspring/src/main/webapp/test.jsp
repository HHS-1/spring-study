<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
                    <!-- jstl 엔진 -->
   	<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
   	<!-- jstl 각종함수 -->
   	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   	<!--  jstl database 관련 사항  -->
   	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

이름 : ${username} 나이 : ${userage}<br><!--  JSTL 형태의 변수값 출력 (ModelAndView) -->
검색어 : ${search}
</body>
</html>