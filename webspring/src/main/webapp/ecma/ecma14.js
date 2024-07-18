var g = document.querySelector("#dataview");
var html = "";
var n = 0;
export class data_load{
	
	json_data(){
		fetch("./ecma14ok.do", {
			method : "get",
			cache : "no-cache",
			
		})
		.then(function(a){
			return a.json();
		})
		.then(function(b){
			g.innerHTML = "";
			html="";
			n = b.length;
			b.forEach(function(arr,node,idx){
				html+= "<tr>"
				+ "<td>"
				+ (n - Number(node))
				+"</td>"
				+"<td>"
				+ b[node]["cpname"]
				+"</td>"
				+"<td>"
				+ b[node]["cprate"]
				+"%</td>"
				+"<td>"
				+b[node]["cpdate"]
				+"</td>"
				+"</tr>"
			})
			g.innerHTML = html;
		})
		.catch(function(error){
			console.log("서버오류");
		});
	}
	
	
}