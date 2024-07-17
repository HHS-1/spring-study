<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cp" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 리스트</title>
</head>
<body>
<form id="frm">
<table border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>선택</th>
			<th>번호</th>
			<th>쿠폰명</th>
			<th>할인율</th>
			<th>사용 유무</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<tbody>
	
	<!-- 
	status : forEach의 반복 상태를 확인
	(status 속성값)
	index : 노드번호 0 시작
	count : 횟수, 1부터 시작
	first,last : 시작인지 마지막인지, boolean
	-------------------------------------
	(forEach 속성값)
	begin, end : 시작, 종료 번호
	step : 증분 값 지정 (step="n") n씩 증가
	 -->
	<cp:forEach var="cp_data" items="${all_list}" varStatus="status">
		<tr>
			<td><input type="checkbox" name="ck" value="${cp_data.get(0)}" onclick="check()"></td>
			<td>${ctn-status.index}</td>
			<td>${cp_data.get(1)}</td>
			<td>${cp_data.get(2)}</td>
			<td>${cp_data.get(3)}</td>
			<td>
			<input type="button" value="수정" onclick="coupon_modify('${cp_data.get(0)}')">
			<input type="button" value="삭제" onclick="coupon_del('${cp_data.get(0)}')">
			</td>
		</tr>
	</cp:forEach>
	
	</tbody>
</table>
</form>
<input type="checkbox" id="ck_all" onclick="checkAll()">전체선택
<input type="button" value="선택삭제" onclick="coupon_del_ck()">
</body>
<script>
function check(){
	const ck = document.getElementsByName("ck");
	const ck_all = document.querySelector("#ck_all");
	let ckck = true;
	for(let i = 0 ; i < ck.length ; i++){
		if(ck[i].checked == false){
			ckck = false;
			ck_all.checked = false;
		}
		if(ckck==true){
			ck_all.checked = true;
		}
	}
}
function checkAll(){
	const ck = document.getElementsByName("ck");
	const ck_all = document.querySelector("#ck_all");
	for(let i = 0 ; i < ck.length ; i++){
		ck[i].checked = ck_all.checked;
	}
}
function coupon_del_ck(){
	frm.method="post";
	frm.action="./coupon_del_ck.do";
	frm.submit();
}
function coupon_modify(no){
	location.href='./coupon_modify1.do?cidx='+no;
}

function coupon_del(no){
	if(confirm("해당 쿠폰 삭제시 복구 되지 않습니다.")){
		location.href='./coupon_del.do?cidx='+no;
	}
	
}
</script>
</html>