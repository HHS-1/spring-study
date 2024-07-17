
export class logins{
	
	//ajax를 사용하는 메소드 (GET)
	ajax_idck(id){
		this.mid = id;
		//fetch : 
		fetch("./ecma8ok.do?mid=" + id)
		.then(function(aa){
			return aa.text();
		})
		.then(function(bb){
			console.log(bb);
		})
		.catch(function(error){
			console.log("통신오류발생");
		});
		
	}
	
}