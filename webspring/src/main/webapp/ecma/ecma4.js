export function idcheck(data){
	if(data==""){
		alert("아이디를 입력하세요");
	}else{
	alert("중복되지 않은 아이디입니다.");
	}
}

export function loop(no1, no2){
	let sum = 0;

	for(let i = no1 ; i <= no2 ; i++){
		sum += i;
	}
	console.log(sum);
}