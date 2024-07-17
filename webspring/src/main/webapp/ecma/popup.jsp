<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<span onclick="datacall('java')">java</span>
<span onclick="datacall('html')">html</span>
<span onclick="datacall('ecma')">ecma</span>
</body>
<script>
function datacall(z){
	/* 		window.opener.frm.data.value = z;
			self.close(); */
			
			
			//자신을 호출한 부모페이지에 postMessage로 데이터 전달
			parent.window.postMessage({msg:z},"*")
		}
</script>
</html>