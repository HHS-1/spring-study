<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
class box{
	
	abc(data){
		this.msg = data + "님 환영합니다.";
		return this.msg;
	}
}
/* const b = new box();
const c = b.abc("홍길동");
console.log(c);
 */
class box2 extends box{ //해당 외부 클래스를 extends를 이용하여 상속받음
	bbb(data2){
		this.cs = data2;
		console.log(this.cs);		
		this.re = this.abc("유관순");
		console.log(this.re);
	}
}
const bx2 = new box2();
bx2.bbb("홍길동");
const result = bx2.abc("강감찬");
console.log(result)
</script>
</html>