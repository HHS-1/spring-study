export let data = {
	keycode : "1324",
	ajax : function(){
		
		fetch("http://172.30.1.80:8080/jq/rest_ajax5.do",{
			mode : "no-cors"
		})
		.then(function(node){ // Backend에서 받는 데이터
			return node.text();
		})
		.then(function(allData){ // 데이터 출력
			console.log(JSON.parse(allData));
		})	
		.catch(function(error){
			
			console.log(error);
		})
	}
}