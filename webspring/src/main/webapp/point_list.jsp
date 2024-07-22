<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       	<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 생성 내역 리스트</title>
</head>
<body>
	<p>데이터 리스트 출력<p>
	<cr:forEach var="list" items="${all}">
	<p>아이디 : ${list.uid}</p>
	<span>고유값 : ${list.uidx}</span>
	<span>고객명 : ${list.uname}</span>
	<span>포인트 : ${list.upoin}</span>
	<span>지급일자 : ${list.udate}</span>
	<input type="button" value="데이터 삭제" id="${list.uidx}" onclick="point_del(this.id)">
	</cr:forEach>
	
</body>
<script>
function point_del(id){
	fetch("./point_delete.do?uidx="+id)
	.then(function(response){
		if(response.status == 200){
			location.href="./point_list.do";
		}
	})
	.catch(function(error){
		console.log(error);
	})	
}
</script>
</html>