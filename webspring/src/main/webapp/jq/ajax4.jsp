<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javascript - Ajax</title>
</head>
<body>
<input type="button" value="데이터 로드" onclick="ajax()">
</body>
<script>
var html = new XMLHttpRequest();
function ajax(){
	html.onreadystatechange = function(){
		if(html.readyState == 4 && html.status == 200){
			console.log(JSON.parse(this.response));
		}
	}
	const keycode="keycode=a1234";
	html.open("GET","http://172.30.1.80:8080/jq/rest_ajax4.do?"+keycode,true);
	html.send();
	
}
</script>
</html>