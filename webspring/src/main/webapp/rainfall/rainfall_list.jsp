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
                    var $time = 3000;    //시간
                    var $width = [data[0].area_part1,data[0].area_part2,data[0].area_part3,data[0].area_part4,data[0].area_part5];
                                       
                    while($w<5){
                         var $ids = "#box" + $w; 
                         var $ani_time = $time * $w; 
                         $($ids).delay($ani_time).animate({
                             "width": $width[$w]
                         },1000);          
                         $w++;
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
                         var $time = 3000;    //시간
                         var $width = [data[0].area_part1,data[0].area_part2,data[0].area_part3,data[0].area_part4,data[0].area_part5];
                                            
                         while($w<5){
                              var $ids = "#box" + $w; 
                              var $ani_time = $time * $w; 
                              $($ids).delay($ani_time).animate({
                                  "width": $width[$w]
                              },1000);          
                              $w++;
                         }
            		},
            		error : function(error){
            			console.log(error);
            		},
            	});
            })
        
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
    </style>
</head>
<body>

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
    <input type="button" value="강우량 등록">
    <input type="button" value="강우량 수정">
    <input type="button" value="강우량 삭제">
</body>
</html>

