//외부 서버에 데이터를 삭제 또는 추가를 요청하는 class

/*
외부에서 Delete, Put에 바로 접근이 불가능한 상황임. 
 */
export class data_call{
	
	//데이터 삭제 요청 메소드
	delete_call(){
		this.no = ["10","20","30"];
		//ajac로 데이터 송신
		//fetch("http://172.30.1.92:8080/ecma/ecma13.do/"+this.no,{
		//fetch("./ecma13.do/"+this.no,{
		fetch("/host/delete.do/"+this.no,{
			//method : "delete",				//데이터 삭제 API 전송 방식
			method : "put",
			headers : {"content-type":"application/x-www-form-urlencoded"}
			//mode : "no-cors"
			//body : "data=11"
		})
		.then(function(aa){
			return aa;
		})
		.then(function(bb){
			console.log(bb.text());
		})
		.catch(function(error){
			//console.log("server error");
			console.log(error);
		})
	}
}

//외부 서버에 데이터를 삭제 | 추가 요청하는 클래스

export class host_call{
	delete_call(){
		this.no = ["10","20","30"];
		//fetch("http://172.30.1.92:8080/ecma/outservice.do/"+this.no,{
		fetch("/host/delete.do/"+this.no,{
			method : "post",				//데이터 삭제 API 전송 방식
			headers : {"content-type":"application/x-www-form-urlencoded"}
			//mode : "no-cors"
		})
		.then(function(aa){
			return aa;
		})
		.then(function(bb){
			console.log(bb.text());
		})
		.catch(function(error){
			console.log("server error");
			console.log(error);
		})
	}
}