<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       	<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
<thead>
	<tr height="30">
	<th><input type="checkbox" id="all_ck"></th>
	<th width="500">제목</th>
	<th width="100">글쓴이</th>
	<th width="100">입력일자</th>
	</tr>
</thead>
<tbody>
	<cr:forEach var="data" items="${result}">
	<tr height="30" align="center">
		<td><input type="checkbox" class="ck" value="${data.nidx}"></td>
		<td align="left" title="${data.n_text}">${data.n_subject}</td>
		<td>${data.n_title}</td>
		<td>${data.n_date.substring(0,10)}</td>
	</tr>
	</cr:forEach>
</tbody>
</table>
<form id="frm" onsubmit="search_gopage()">
<input type="button" id="del_btn" value="선택삭제">
검색 : 
<select name="search_part">
	<option value="1">제목</option>
	<option value="2">글쓴이</option>
	<option value="3" selected>제목+내용</option>
</select>
<input type="text" name="search_word">
<input type="submit" value="검색">
</form>
</body>
<script>


var ck_box = document.querySelectorAll(".ck");
var ck_all = document.querySelector("#all_ck");
var ck = true;
ck_all.addEventListener("click",function(){
	ck_box.forEach((checkbox)=>{
		checkbox.checked = this.checked;
	})
});


ck_box.forEach((checkbox) => {
    checkbox.addEventListener("click", function() {
        let allChecked = Array.from(ck_box).every((box) => box.checked);
        ck_all.checked = allChecked;
    });
});



var ckck = "${search_part}";
if(ckck != ""){
frm.search_part.value = ckck;	
}

function search_gopage(){
	if(frm.search_word.value==""){
		alert('검색할 단어를 입력하세요');
	}else{
		frm.method="get";
		frm.action="./notice_list.do";
		frm.submit();
	}
}


</script>
</html>