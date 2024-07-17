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
<script>
document.querySelector("#btn").addEventListener("click",function(){
	z.ccc();
	new zzz().c();
});

//선언식 class 형태
let zzz = class bbb{
	c(){
		console.log("연습입니다.");
	}
}
console.log(zzz.name);

// 일반 Class 형태
class abc{
	aaa(){
		console.log("함수1");
	}	
	bbb(data){
		console.log("데이터 : " + data);
	}
	ccc(){
		alert("테스트 진행!!");
	}

}
let z = new abc();
z.aaa();
z.bbb("홍길동");
</script>
</html>