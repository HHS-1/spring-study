<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청사항에 맞는 배열값을 받기</title>
</head>
<body>
<input type="button" value="데이터 요청" id="btn">
</body>
<script type="module">
import {data_load} from './ecma14.js';
document.querySelector("#btn").addEventListener("click",function(){
	new data_load().json_data();
})
</script>
</html>