<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" value="클릭" id="btn">
</body>
<script type="module">
import a from "./ecma3.js";
import {abc,bbb} from "./ecma3.js";
abc("홍길동");

//이벤트를 발생시키는 핸들링 호출
document.querySelector("#btn").addEventListener("click",bbb);
</script>
</html>