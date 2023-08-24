

// 1. 회원가입 메소드
function signup(){
	
	// 1. HTML에 가져올 데이터의 tag객체 호출 [ DOM객체 : html 태그를 객체화 ]
	let midInput = document.querySelector('.mid'); // <input class="mid" type="text">
	let mpwd = document.querySelector('.mpwd'); // <input class="mid" type="text">
	let mpwdconfirm = document.querySelector('.mpwdconfirm'); // <input class="mid" type="text">
	let memail = document.querySelector('.memail'); // <input class="mid" type="text">
	let mimg = document.querySelector('.mimg'); // <input class="mid" type="text">
		
	// 2. (객체화)
	let info = {
		mid : midInput.value , 
		mpwd : mpwd.value ,
		memail : memail.value ,
		mimg : mimg.value
	}
	// 3. 유효성 검사
	
	// 4. AJAX메소드를 이용한 Servlet와 통신
	$.ajax({
		url : "/jspweb/MemberInfoController",
		data : info ,
		method : "post",
		success : r => {console.log('통신성공');} ,
		error : r => {console.log('통신실패');}		
	});
		// 5. Servlet의 응답에 따른 제어 
}