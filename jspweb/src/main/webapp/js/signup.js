 /* 
 	onchange : 포커스(커서) 변경될 때 
 	onkeyup : 키보드에서 키를 누르고 떼었을 때
 	onkeydown : 키보드에서 키를 눌렀을 때
 */
 /*
 	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할 때 사용되는 언어
 		문법
 			/^ 					: 정규표현식 시작 알림.
 			$/ 					: 정규표현식 끝 알림.
 			[a-z] 				: 소문자 a-z 패턴 검색
 			[A-Z]				: 대문자 A-Z 패턴 검색 
 			[0-9] 				: 숫자 0~9 패턴 검색
 			[가-힣] 				: 한글 패턴 
 			{ 최소길이 , 최대길이 } 	: 문자열 길이 패턴
 			
 			예시]
 				1. [a-z]				: 소문자a-z 패턴
 				2. [a-zA-Z] 			: 영문(대,소) 패턴
 				3. [a-zA-Z0-9]			: 영문 + 숫자 조합 패턴
 				4. [a-zA-Z0-9가-힣]		: 영문 + 숫자 + 한글 조합 패턴
 				5. [ac]				: a와 c 패턴
 				
 			1. /^[a-z0-9]{5,30}$/ 		: 영문(소) + 숫자 조합 5~30글자 패턴
 		
 		패턴 검사
 			"패턴".test( 검사할데이터 ) : 해당 데이터가 패턴에 일치하면 true / false
 */
 
// 1. 아이디 유효성검사.
function idcheck(){
	console.log('idcheck() open')
	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	// 2. 유효성 검사
		// 제어문 이용한 검사 if(mid.length < 5 && mid.length >= 30){}
		// 1. 아이디는 5~30글자 사이이면서 영문+숫자 조합
			// 1. 정규표현식 작성.
			let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사.
		console.log( midj.test( mid ) );
	// 3. 결과 출력
}





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
		success : r => {console.log('통신성공');
		if(r == true)
			alert('회원가입 성공');
		else
			alert('회원가입 실패');	
		} ,
		error : r => {console.log('통신실패');}		
	});
		// 5. Servlet의 응답에 따른 제어 
}