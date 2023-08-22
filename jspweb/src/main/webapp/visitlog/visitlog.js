console.log('visitlog.js 열림')

// 1.create( 저장 )
function vwrite(){
	
	// 1. HTML input 태그 호출
		// document.querySelector('.vwriter');
	let vwriterInput = document.querySelector('.vwriter');	console.log('vwriterInput: ' + vwriterInput)
	let vpwdInput = document.querySelector('.vpwd');		console.log('vwriterInput: ' + vpwdInput)
	let vcontentInput = document.querySelector('.vcontent');console.log('vwriterInput: ' + vcontentInput)
	// 2. 객체화
		// let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터 }
	let info = {
		vwriter : vwriterInput.value , 
		vpwd : vpwdInput.value ,
		vcontent : vcontentInput.value
	}; console.log( info );
	// 3. *유효성검사[ ]
	
	// 4. AJAX
	$.ajax({
		url : "/jspweb/VisitLogController",
		method : "post",
		data : info,
		success : function f(r){ 
			console.log(r); 
			if(r == true){alert("등록 성공");}
			else{alert("등록 실패"); }
			vwriterInput.value = ''; vpwdInput.value = ''; vcontentInput.value = '';
			} ,
		error : function f(r){}
	})
		// 5. 결과에 따른 코드
		vread();
}
// 2.Read( 호출 )
vread();
function vread(){ // 실행조건 : JSㅇㄹ릴 때 1번 실행 , 등록성공 , 수정성공 , 삭제성공 => 최신화[화면 새로고침]
	let board = document.querySelector('.board');
	// 4. AJAX
	$.ajax({
		url : "/jspweb/VisitLogController",
		method : "get",
		data : "",
		success : function f(r){ 
			console.log(r); 
			// 응답 반은 객체를 HTML에 출력
			// 1. [어디에] 출력할 구역의 객체 호출
			let output = document.querySelector('.visit_Bottom');
			// 2. [무엇을] 반복문 이용한 데이터를 HTML화
			let html = ``;
				
				// 리스트내 모든 데이터를
				for( let i = 0; i < r.length; i++){
					// 객체를 HTML형식으로 누적더하기
					html += `<div class="visitbox">
								<div class="visitbox_top">
									<div>${r[i].vwriter}</div>
									<div class="visitdate">${r[i].vwritedate}</div>
								</div>
								<div class="visitbox_center">${r[i].vcontent}</div>
								<div class="visitbox_bottom">
									<button type="button">수정</button>
									<button type="button">삭제</button>
								</div>
							</div>`
				}
				
			// 3. [대입] 출력객체에 HTML형식 대입
			output.innerHTML = html;
			} ,
		error : function f(r){}	
	});
	
	
	
}

// 3.Update( 수정 )
function vupdate(){}

// 4.Delete( 삭제 )
function vdelete(){}


