<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    아키텍처(데이터의 구조형태), 프로토콜(서버와 서버간의 통신)
    
     -->
    <!-- 
    API서버 
    - REST (GET, POST) - XML, JSON
    - RESTful (GET, POST, PUT, DELETE) - URI 파라미터
    - CDN (GET, POST) - Image, Video
    - SOAP - REST와 특성이 비슷함(프로토콜) XML만 사용
    -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery ajax & api 서버통신</title>
<script src="../js/jquery.js?v=1"></script>
<script>
/*REST 
 회원가입 > 회원가입 완료 > JSON 생성
 상품등록 페이지 > 상품등록 완료 > JSON 생성
 */
$(()=>{
	$("#btn3").click(()=>{
		//$.get, $.post()
		$.ajax({
			url : "./rest.json2.do",
			cache : false,
			type : "GET",
			dataType : "json",
			success : function($data){
				console.log($data);
			},
			error : function(error){
				console.log(error);	
			}
			
		});
	})
	
	$("#btn2").click(()=>{
		//$.get, $.post()
		$.ajax({
			url : "../upload/data.json",
			cache : false,
			type : "GET",
			dataType : "json",
			success : function($data){
				$.each($data.member,function($node,$value){
					$("#htmlview").append("<li>" + $value + "</li>");
				})
			},
			error : function(error){
				console.log(error);	
			}
			
		});
	})
	
	$("#btn").click(()=>{
		//$.get, $.post()
		$.ajax({
			url : "./rest_json.do",
			cache : false,
			type : "GET",
			dataType : "HTML",
			success : function($data){
				console.log(JSON.parse($data));
			},
			error : function(error){
				console.log(error);	
			}
			
		});
	})
})
</script>
</head>
<body>
<input type="button" value="데이터 로드" id="btn">
<input type="button" value="JSON 로드" id="btn2">
<input type="button" value="URLJSON 로드" id="btn3">
<ul id="htmlview">

</ul>
</body>
</html>