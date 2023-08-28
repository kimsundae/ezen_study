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
 			\d					: 숫자 0~9 패턴 검색
 			[가-힣] 				: 한글 패턴 
 			{ 최소길이 , 최대길이 } 	: 문자열 길이 패턴
 			+ : 앞에 있는 패턴 1개 이상 반복
 			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
 			* : 앞에 있는 패턴 0개 반복
 			예시]
 				1. [a-z]				: 소문자a-z 패턴
 				2. [a-zA-Z] 			: 영문(대,소) 패턴
 				3. [a-zA-Z0-9]			: 영문 + 숫자 조합 패턴
 				4. [a-zA-Z0-9가-힣]		: 영문 + 숫자 + 한글 조합 패턴
 				5. [ac]					: a와 c 패턴
 				6. (?=.*[패턴문자])		: 해당 패턴문자가 한 개 이상 포함 패턴
 					(?=.*[a-z])			: 소무자 한개 이상 필수
 					(?=.*[A-Z])			: 대문자 한개 이상 필수
 					(?=.*[0-9])			: 숫자 한개 이상 필수
 					(?=.*[\d])			: 숫자 한개 이상 필수
 					(?=.*[!@#$%^&*])	: 패턴문자 내 특수문자 한개 이상 필수
 					
 				
 				
 				/^[a-z0-9]{5,30}$/
 				영대소문자 + 숫자 조합의 5~20글자 사이
 				
 				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]){5,20}$/
 				영대문자1개 + 영소문자1개 + 숫자 1개 이상 필수로 갖는
 								
 				
 			1. /^[a-z0-9]{5,30}$/ 							: 영문(소) + 숫자 조합 5~30글자 패턴
 			2. /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{5,20}$/
 			3. /^[a-zA-Z0-9_-]+@[a-zA-Z\d_-]+\.[a-zA-Z]+$/	: 패턴 @ 패턴 . 패턴
 		패턴 검사
 			"패턴".test( 검사할데이터 ) : 해당 데이터가 패턴에 일치하면 true / false
 */
  
// 1. 아이디 유효성검사.
function idcheck(){	
	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	let idcheck = document.querySelector('.idcheckbox');
	// 2. 유효성 검사
		// 제어문 이용한 검사 if(mid.length < 5 && mid.length >= 30){}
		// 1. 아이디는 5~30글자 사이이면서 영문+숫자 조합
			// 1. 정규표현식 작성.
			let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사.
		console.log( midj.test( mid ) );
		if( midj.test(mid) ){//입력한 값이 패턴과 일치하면
			idcheck.innerHTML = '패턴 합격'			
			// -- 입력한 아이디가 패턴과 일치하면 아이디 중복검사.
			$.ajax({
				url : "/jspweb/MemberFindController" ,
				method : "get",
				data : {type : "mid" , data : mid},
				success : r => {console.log('통신성공')
				if( r )
					idcheck.innerHTML = '사용 중인 아이디입니다.'
				else	
					idcheck.innerHTML = '사용 가능한 아이디입니다.'
				},
				error : r => {}
			});
					
		}else{
			document.querySelector('.idcheckbox').innerHTML = '영문(소문자)+숫자 조합의 5~30글자 가능합니다.';
		}
		
		
		
		
	// 3. 결과 출력	
	
}

// 2. 비밀번호 유효성검사 [ 1.정규표현식 검사 2. 비밀번호 외 비밀번호 확인 일치여부]
function pwcheck(){ 
	console.log('패스워드 입력 중');
	
	let pwcheckbox = document.querySelector('.pwcheckbox');
	// 1. 입력 값 호출
	let mpwd = document.querySelector('.mpwd').value; console.log('mpwd : ' + mpwd);
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	// 2. 유효성 검사
		// 1. 정규표현식 만들기 [영대소문자 + 숫자 조합 5~20글자 사이 ]
		let mpwdj = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{5,20}$/
		
		if( mpwdj.test( mpwd )){ // 비밀번호 정규표현식 검사
		
			// 2. 비밀번호 확인 정규표현식 검사
			if( mpwdj.test( mpwdconfirm )){
				
				// 3. 비밀번호와 비밀번호 확인 일치여부
				if( mpwd == mpwdconfirm){
					pwcheckbox.innerHTML = `사용가능한 비밀번호`;
				}else{
					pwcheckbox.innerHTML = `비밀번호가 일치하지 않습니다.`
				}
				
			}else{
				pwcheck.innerHTML = `실패`
			}
							
			
		}else{
			pwcheckbox.innerHTML = '영대소문자 1개 이상 + 숫자 1개이상 조합 5~20글자 사이로 입력해주세요'
		}
}

// 3. 이메일 유효성검사 [ 1. 정규표현식 2. 중복검사 ]
function emailcheck(){
	let emailcheckbox = document.querySelector('.emailcheckbox');
	
	// 1. 입력된 값 호출
	let memail = document.querySelector('.memail').value
	
	// 2. 이메일 정규표현식 [ @ 기준으로 앞부분 이메일 앞부분]
		// itdanja@kakao.com
		// 1. itdanja 	: 이메일 아이디부분은 영대소문자, 숫자,_- @ 1개이상 필수 입력
		// 2. @			: +@  @앞에 패턴이 1개이상 필수
		// 3. 도메인
			// 회사명
			//.
			// 도메인
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z\d_-]+\.[a-zA-Z]+$/
	
	if( memailj.test( memail) ){
		
		$.ajax({
			url : "/jspweb/MemberFindController" ,
			data : {type : "memail" , data : memail}, // : 이메일 중복검사
			method : "get",
			success : r => {
				console.log('통신성공');
				if( r )
					emailcheckbox.innerHTML = `사용 중인 이메일입니다.`;
				else
					emailcheckbox.innerHTML = `사용 가능한 이메일입니다.`;
				
				} ,
			error : r => {console.log(r)}
		})
	}else{
		console.log('이메일 실패');
	}
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