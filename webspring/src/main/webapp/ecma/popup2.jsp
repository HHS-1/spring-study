<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<iframe id="msg" src="http://172.30.1.80:8080/ecma/popup.jsp">

</iframe>
</body>
<script>
//message는 외부의 값에 대한 내용을 가져오게 되며, 해당 값을 data 및 배열키
//를 이용하여 부모창으로 값을 넘기는 cors 해결방식입니다.
window.addEventListener('message',function(z){
	window.opener.frm.data.value = z.data.msg;
	self.close();
});
</script>
</html>