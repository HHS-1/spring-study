const dd = "테스트 ECMA 코드";
export default console.log(dd);

export function abc(data){
	console.log(data + "입니다.");
}

//이벤트 핸들링 함수
export function bbb(){
	this.no1 = 5;
	this.no2 =20;
	return console.log(this.no1 * this.no2);
}

