<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
        <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강우량 통계차트 출력페이지 (SPA)</title>
    <script src="../js/jquery.js"></script>
    <script>
        $(()=>{
        	//오늘날짜 알아오는 스크립트
        	let td = new Date();
        	let today = td.toISOString().substring(0,10);
			
        	$.ajax({
        		url : "./rainfall_select.do?today="+today,
        		cache : false,
        		method : "GET",
        		dataType: "json", // 클라이언트가 JSON 응답을 기대함
        	    headers: {
        	        "Accept": "application/json" // 서버에 JSON을 기대한다고 명시
        	    },
        		success : function(data){
        			console.log(data[0]);
       			 	var $w = 0;
       			 	var $ww = 0;
                    var $time = 1000;    //시간
                    var $width = [data[0].area_part1,data[0].area_part2,data[0].area_part3,data[0].area_part4,data[0].area_part5];
                    
                    //그래프 출력
                    while($w<5){
                         var $ids = "#box" + $w; 
                         var $ani_time = $time * $w; 
                         $($ids).delay($ani_time).animate({
                             "width": $width[$w]
                         },1000);          
                         $w++;
                    }
                    
                    //수정창
                    while($ww < 5){
	                    $("#modify_part" + $ww).val($width[$ww]);
	                    $ww++;
                    }
        		},
        		error : function(error){
        			console.log(error);
        		},
        	});

        	/*
            $("#btn").click(function(){        
               var $w = 0;
               var $time = 3000;    //시간
               var $width = "450px|320px|390px|270px|530px";
               var $ani_width = $width.split("|");
                                  
               while($w<5){
                    var $ids = "#box" + $w; 
                    var $ani_time = $time * $w; 
                    $($ids).delay($ani_time).animate({
                        "width":$ani_width[$w]
                    },1000);          
                    $w++;
               }
            });
            */
            
            $("#day").change(function(){
            	$.ajax({
            		url : "./rainfall_select.do?today="+$(this).val(),
            		cache : false,
            		method : "GET",
            		dataType: "json", // 클라이언트가 JSON 응답을 기대함
            	    headers: {
            	        "Accept": "application/json" // 서버에 JSON을 기대한다고 명시
            	    },
            		success : function(data){
            			console.log(data[0]);
            			 var $w = 0;
                         var $time = 1000;    //시간
                         var $width = [data[0].area_part1,data[0].area_part2,data[0].area_part3,data[0].area_part4,data[0].area_part5];
                                            
                         while($w<5){
                              var $ids = "#box" + $w; 
                              var $ani_time = $time * $w; 
                              $($ids).delay($ani_time).animate({
                                  "width": $width[$w]
                              },1000);          
                              $w++;
                         }
                         
                       //수정창
                         while($ww < 5){
     	                    $("#modify_part" + $ww).val($width[$ww]);
     	                    $ww++;
                         }
            		},
            		error : function(error){
            			console.log(error);
            		},
            	});
            })
            
            //강우량 등록 버튼
            $("#in_data").click(function(){
            	location.href="./rainfall_write.jsp";
            })
            
            //강우량 수정 버튼
            $("#modify_data").click(function(){
      
            	
            })
            
             $("#day_modify").change(function(){
            	$.ajax({
            		url : "./rainfall_select.do?today="+$(this).val(),
            		cache : false,
            		method : "GET",
            		dataType: "json", // 클라이언트가 JSON 응답을 기대함
            	    headers: {
            	        "Accept": "application/json" // 서버에 JSON을 기대한다고 명시
            	    },
            		success : function(data){
            			console.log(data[0]);
            			 var $ww = 0;
                         var $width = [data[0].area_part1,data[0].area_part2,data[0].area_part3,data[0].area_part4,data[0].area_part5];
                       //수정창
                         while($ww < 5){
     	                    $("#modify_part" + $ww).val($width[$ww]);
     	                    $ww++;
                         }
            		},
            		error : function(error){
            			console.log(error);
            		},
            	});
            })
            
            $("#modify_btn").click(function(){
            	const data = {
            	            ridx : 1,
            	            area_part1: document.getElementById('modify_part0').value,
            	            area_part2: document.getElementById('modify_part1').value,
            	            area_part3: document.getElementById('modify_part2').value,
            	            area_part4: document.getElementById('modify_part3').value,
            	            area_part5: document.getElementById('modify_part4').value,
            	            today: document.getElementById('day_modify').value,
            	};
            	console.log(data);
            	fetch("./rainfall_modify.do",{
            		method : 'POST',
            		headers : {
            			'Content-Type': 'application/json',
            	        'Accept': 'application/json'
            		},
            		body: JSON.stringify(data)
            	})
            	.then((response)=>{
            		console.log(response);
            	})
            	.catch((err)=>{
            		console.log(err)
            	})
            })
            
            //강우량 삭제 버튼
        	
            
	});
    </script>
    <style>
        .gp{
            width:800px;
            height: 400px;
            border: 1px solid black;
            border-right:none;
            border-top: none;
            position: relative;
            left: 150px;
        }
        ul { list-style: none; margin: 0; padding: 0; 
            padding-top: 40px; 
            box-sizing: border-box; float: left;
        }
        ul:nth-of-type(1){
            width:10%;
            position: relative;
            left: -60px;
        }
        ul:nth-of-type(2){
            width:90%;
            position: relative;
            left: -80px;
        }
        ul > li { height: 40px; margin-bottom: 40px; line-height: 40px; }
        .gp > ul:nth-of-type(2) > li { width: 0px;}
        .gp > ul:nth-of-type(2) > li:nth-of-type(1){
            background-color: red;
        }
        .gp > ul:nth-of-type(2) > li:nth-of-type(2){
            background-color: greenyellow;
        }
        .gp > ul:nth-of-type(2) > li:nth-of-type(3){
            background-color: orange;
        }
        .gp > ul:nth-of-type(2) > li:nth-of-type(4){
            background-color: purple;
        }
        .gp > ul:nth-of-type(2) > li:nth-of-type(5){
            background-color: blue;
        }
        
        .modify_box{
        	width : 300px;
        	height : 300px;
        	border : 1px solid black;
        }
    </style>
</head>
<body>
	<div class="modify_box">
	<p>날짜 선택 :
		<select id="day_modify">
			<cr:forEach var="data" items="#{data}">
			<option>${data.today}</option>
			</cr:forEach>
		</select>
	</p>
	서울 : <input type="text" id="modify_part0"><br><br>
	경기 : <input type="text" id="modify_part1"><br><br>
	세종 : <input type="text" id="modify_part2"><br><br>
	대전 : <input type="text" id="modify_part3"><br><br>
	강원 : <input type="text" id="modify_part4"><br><br>
	<input type="button" value="수정" id="modify_btn">
	</div>
	<p>일자별 강우량 :
		<select id="day">
			<cr:forEach var="data" items="#{data}">
			<option>${data.today}</option>
			</cr:forEach>
		</select>
	</p>
    <div class="gp">
        <ul>
            <li>서울</li>
            <li>경기도</li>
            <li>세종</li>
            <li>대전</li>
            <li>강원도</li>
        </ul>
        <ul>
        <li id="box0"></li>
        <li id="box1"></li>
        <li id="box2"></li>
        <li id="box3"></li>
        <li id="box4"></li>
        </ul>
    </div>
    <br><br><br>
    <input type="button" value="강우량 등록" id="in_data">
    <input type="button" value="강우량 수정" id="modify_data">
    <input type="button" value="강우량 삭제" id="delete_data">
</body>
</html>

