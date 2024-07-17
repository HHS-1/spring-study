<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                    <!-- jstl 엔진 -->
   	<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
   	<!-- jstl 각종함수 -->
   	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   	<!--  jstl database 관련 사항  -->
   	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 외부페이지 로드</title>
</head>
<body>

<!-- import를 이용하여 외부의 jsp 파일을 로드할 수 있습니다.
단, 해당 페이지에 set태그를 이욯하여 공유하는 데이터 방식은 작동불능
Contrller에서 Model, MAV를 활용하면 외부 import된 jsp에서 jstl로 결과값 출력 가능능
 -->
<cr:import url="./test.jsp"></cr:import> <!-- jsp의 include page와 같음 -->

</body>
</html>