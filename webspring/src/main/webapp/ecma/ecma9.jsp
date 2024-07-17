<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECMA Ajax POST 통신</title>
</head>
<body>
<form id="frm">
아이디 : <input type="text" name="mid" id="mid">
<input type="button" value="중복체크" id="btn">
</form>
</body>
<script type="module">
import {logins} from "./ecma9.js";
document.querySelector("#btn").addEventListener("click",function(){
	new logins().ajax_idck(frm.mid.value);
})
</script>
</html>