<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="mid" id="mid"><br>
<input type="button" value="중복체크" id="btn">
<br><br>
첫 번째 값 : <input type="text" id="no1"><br>
두 번째 값 : <input type="text" id="no2"><br>
<input type="button" value="결과출력" id="btn2">
</body>
<script type="module">
import {idcheck, loop} from "./ecma4.js";
document.querySelector("#btn").addEventListener("click",function(){
	var ob = document.getElementById("mid").value;
	idcheck(ob);
})

document.querySelector("#btn2").addEventListener("click",function(){
	let no1 = document.getElementById("no1").value;
	let no2 = document.getElementById("no2").value;

	loop(Number(no1),Number(no2));
})
</script>
</html>