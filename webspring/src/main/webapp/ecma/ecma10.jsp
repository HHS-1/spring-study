<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부 페이지 팝업 결과값 CORS 해제법</title>
</head>
<body>
<form id="frm">
값 : <input type="text" name="data" id="data" readonly>
<input type="button" value="데이터 로드" id="btn" readonly>
</form>
</body>
<script>
document.querySelector("#btn").addEventListener("click",function(){
	window.open("./popup2.jsp", "", "width=400 height=400");
});
</script>
</html>