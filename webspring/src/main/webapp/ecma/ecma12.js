let arr_data = new Array();
let arr_data2 = new FormData();
const data = {
			mid : "hong",
			mname : "홍길동",
			mage : "55",
			marea : "서울",
			mtel : "01046119794"
		};
		
export class test_ajax{
	
	
	
	//array
	array_make(z){
		arr_data.push(z);
		console.log(arr_data);
	}
	
	ajax_post(){
		this.pt = JSON.stringify(arr_data);
		fetch("http://172.30.1.80:8080/ecma/ecma12array.do",{
			method : "post",
			headers : {
				'Content-Type': 'application/json',
				'Access-Control-Allow-Origin': '*',
			},
			body : this.pt,
		})
		.then(function(data){
			console.log(data);
		})
		.catch(function(error){
			console.log(error);
		})
	}
	
	//object
	formdata_make(...z){
		arr_data2.append(z[0],z[1]);
		console.log(arr_data2);
	}
	
	ajax_post2(){
		
		this.pt = JSON.stringify(data);
		fetch("http://172.30.1.80:8080/ecma/ecma12formdata.do",{
			method : "post",
			headers : {
				'Content-Type': 'application/json',
				'Access-Control-Allow-Origin': '*',
			},
			body : this.pt,
		})
		.then(function(data){
			console.log(data);
		})
		.catch(function(error){
			console.log(error);
		})
		console.log(this.pt);
		
	}
	
}