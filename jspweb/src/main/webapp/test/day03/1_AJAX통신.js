console.log( '1_AJAX통신.js open' );


// 1. 예제1

function 예제1(){
	
	
	$.ajax({
		url : "http://localhost/jspweb/test06" ,
		data : { 'value1' : 'jsdata'} ,
		method : "get" ,
		success : function 함수(result){console.log('서블릿 응답한 내용:' + result)} ,
		error : function 함수(result){}
		
	});
	
	
}// f end 
function 예제2(){
	// 1.입력 받은 데이터 가져온다.
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	
	// 2. 객체화
	let info = {
		name : nameData,
		age : ageData
	}
	// 3. [ 1달 => 배열에 객체 저장 ]
	$.ajax({
		url : "http://localhost/jspweb/Test07" ,
		data : info ,
		method : "get" ,
		success : function 함수(result){console.log('서블릿 응답한 내용:' + result)} ,
		error : function 함수(result){}
		
	});
	
	
}// f end 


/*
	$.ajax({
		url : "",								-- 통신할 HTTP 주소
		data : {},								-- 보내는 데이터
		method : "",							-- POST , GET , PUT , DELETE
		success : function 함수(result){},		-- 통신 성공 했을 때
		error :  function 함수(result){} 			-- 통신 실패 했을 때
				
	});



*/
