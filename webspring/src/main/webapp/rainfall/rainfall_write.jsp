<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강우량 데이터 등록 페이지</title>
</head>
<body>
<form id="frm">
등록일자 : <input type="date" name="today" value="${day}" onchange="date_check(this.value)">
<font color="red" id="error_red" style="display : none;">※이미 등록된 일자입니다.</font>
<br>
서울 : <input type="text" name="area_part1" value="0" maxlength="3"><br> 
경기 : <input type="text" name="area_part2" value="0" maxlength="3"><br> 
세종 : <input type="text" name="area_part3" value="0" maxlength="3"><br> 
대전 : <input type="text" name="area_part4" value="0" maxlength="3"><br> 
강원 : <input type="text" name="area_part5" value="0" maxlength="3"><br> 
<button type="button" id="btn">강수량 등록</button>
</form>
</body>
<script>
function date_check(day){
	fetch("./rainfall_check.do?today="+day)
	.then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        if(data == 1){
        	document.querySelector("#error_red").style.display = "block";
        }else{
        	document.querySelector("#error_red").style.display = "none";
        }
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
}

document.querySelector("#btn").addEventListener("click",function(){
	frm.method = "POST";
	frm.action = "./rainfall_writeok.do";
	frm.submit();
})
</script>
</html>