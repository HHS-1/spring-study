<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="cp" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 수정</title>
</head>
<body>
<cp:if test="${info.get(3)=='N'}">

</cp:if>
<form id="frm" method="post" action="./coupon_modify2.do">
<input type="hidden" name="cidx" value="${info.get(0)}">
쿠폰명 : <input type="text" name="cpname" value="${info.get(1)}"><br>
쿠폰할인율 : <input type="text" name="cprate" value="${info.get(2)}"><br>
쿠폰 활성화 : <input type="radio" name="cpuse" value="Y" checked> 사용함
<input type="radio" name="cpuse" value="N"> 사용안함 <br>
쿠폰 만료일 : <input type="date" name="cpdate" value="${info.get(4)}"><br>
쿠폰 생성일 : <input type="text" name="indate" value="${info.get(5)}" readonly>
<input type="button" value="쿠폰 수정" onclick="cpmodify()">
</form>
</body>
<script>
var checkin = "${info.get(3)}";
var cpuse = document.getElementsByNames("cpuse");
if(checkin=="Y"){
	cpuse[0].checked = true;
}else cpuse[1].checked = true;

function cpmodify(){
	frm.submit();
}
</script>
</html>