<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="frm" method="post" action="./mainpage.do">
검색 : <input type="text" name="search"><br>
<input type="button" value="전송" onclick="abc()">
</form>
</body>
<script>
function abc(){
	frm.submit();
	
}
</script>
</html>