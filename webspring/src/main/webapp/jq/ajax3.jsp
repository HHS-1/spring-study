<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery ajax 외부 서버 통신</title>
<script src="../js/jquery.js?v=1"></script>
</head>
<body>

	<input type="button" value="전송" id="btn">
</body>
<script>
$(()=>{
	$("#btn").click(()=>{
		
		$.ajax({
			url : "http://172.30.1.80:8080/jq/rest_json3.do",
			cache : false,
			type : "get",
			dataType : "JSON",
			success : function(data){
				console.log(data);
			},
			error : function(error){
				console.log(error);
			}
			
			
		});
		
	});
})
</script>
</html>