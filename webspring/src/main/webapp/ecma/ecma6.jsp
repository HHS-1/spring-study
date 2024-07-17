<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECMA로 데이터 등록</title>
</head>
<body>
<form id="frm" method="post" action="./ecma6ok.do">
영화 제목 : <input type="text" name="msubject"><br>
영화관 : 
<select name="cinema">
<option value="">[영화관 선택]</option>
<option value="CGV">CGV</option>
<option value="MEGABOX">메가박스</option>
<option value="LOTTE">롯데시네마</option>
</select><br>
예매 가격 : <input type="text" name="ticketing" maxlength="5"><br>
상영일 : <input type="date" name="screen_date"><br>
<input type="button" value="예매하기" id="btn">
</form>
</body>
<script type="module">
	import {movieck} from "./ecma6.js";
	document.querySelector("#btn").addEventListener("click",function(){
		new movieck().input_check();

	});	
</script>
</html>