<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fecth 데이터 로드</title>
</head>
<body>
<input type="button" value="fetch" id="btn">

</body>
<script type="module">
import {data} from "./ajax5.js?v=1";
document.querySelector("#btn").addEventListener("click",function(){
	data.ajax();
});

</script>

</html>