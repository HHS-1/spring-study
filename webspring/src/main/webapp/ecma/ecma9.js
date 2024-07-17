
export class logins{
	
	//ajax를 사용하는 메소드 (post)
	ajax_idck(id){
		this.mid = id;
		//fetch : 
		fetch("http://172.30.1.80:8080/ecma/ecma9ok.do",{
		method: 'POST',
  		headers: {
	    	'Content-Type': 'application/json',
			'Access-Control-Allow-Origin': '*',
  		 },
		body: this.mid,
		})
		.then(function(aa){
			return aa.text();
		})
		.catch(function(error){
			console.log("통신오류발생");
		});
		
	}
	
}