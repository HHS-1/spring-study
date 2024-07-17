export class ecma_ajax{
	//formdata를 이용
	arrs(){
		this.fm = new FormData();
		this.fm.append("mid","hong");
		this.fm.append("name","홍길동");
		console.log(this.fm);
	}
	
	
	//배열값을 전송하는 방식
	ajax_arr(){
		fetch("./ecma11ok.do", {
			method : "POST", 
			headers : {
				'Content-Type': 'application/json',
			},
			body : JSON.stringify({mid:"hong", mname:"홍길동"}),
			/*body : new URLSearchParams({
				mid : "hong",
				mname : "홍길동"
			}),*/
		})
		.then(function(aa){
			return aa.text();
		})
		.catch(function(error){
			console.log("error");
		})
	}
}