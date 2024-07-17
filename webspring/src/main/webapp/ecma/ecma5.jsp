<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
연락처 : <input type="text" id="tell1" maxlength="3"> - 
<input type="text" id="tell2" maxlength="4"> - 
<input type="text" id="tell3" maxlength="4">
<input type="button" value="인증번호 받기" id="btn">

</body>
<script type="module">
	import {tels} from "./ecma5.js";
	document.querySelector("#btn").addEventListener("click",function(){
		this.result = new tels();
		this.result.tel_check();
	})
</script>
</html>