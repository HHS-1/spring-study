<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 동기 및 비동기 차이점</title>
<style>
.box{
width : 0px;
height:30px;
border:1px solid black;
transition : all 5s ease;
background-color : blue;
}
</style>
</head>

<body>
<div id="box" class="box"></div>
</body>
<script>
dataCall();

function dataCall(){
	setTimeout(()=>{
		ani();
	},100);
	var http, result;
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){ //backend 5s loading
			document.getElementById("box").style.display = "none";
			console.log(this.response);
		}
	}
	//false : 동기, 작업 시 백엔드와 시간간격을 체크하여 작업을 해야함
	//true : 비동기 
	http.open("POST","./ajaxok.do",true);
	http.setRequestHeader("content-type"," application/x-www-form-urlencoded");
	http.send("mid=hong");
console.log("내가 먼저 출력됨");
}
function ani(){
	document.getElementById("box").style.width = "1000px";
}
</script>
</html>