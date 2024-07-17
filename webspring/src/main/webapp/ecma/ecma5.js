export class tels{
		constructor(){
			console.log("test");
		}
		
	tel_check(){
		this.tell1 = document.querySelector("#tell1").value;
		this.tell2 = document.querySelector("#tell2").value;
		this.tell3 = document.querySelector("#tell3").value;
		this.total = this.tell1 + this.tell2 + this.tell3;
		if(isNaN(this.total) == false){
			alert("인증번호발송");
			this.tel_random(); // class안에 있는 메소드 호출
		}else{
			alert("정상적인 번호가 아니다");
		}
	}
	tel_random(){
		
		this.w = 1;
		this.code = "";
		while(this.w < 7){
		this.code += Math.floor(Math.random()*10);
		this.w++;
		}
		console.log(this.code);
	}
}
