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
				if( r ){
					idcheck.innerHTML = '사용 중인 아이디입니다.'
					checkList[0] = false;
				}
					
				else	{
					idcheck.innerHTML = '사용 가능한 아이디입니다.'
					checkList[0] = true;
				}
					
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
					checkList[1] = true;
					return;
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
	let authReqBtn = document.querySelector('.authReqBtn');
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
				if( r ){
					emailcheckbox.innerHTML = `사용 중인 이메일입니다.`;
					authReqBtn.disabled = true;
				}
					
				else{
					emailcheckbox.innerHTML = `사용 가능한 이메일입니다.`;
					authReqBtn.disabled = false; // 해당 버튼의 disabled 속성 해제
				}
					
				
				} ,
			error : r => {console.log(r)}
		})
	}else{
		emailcheckbox.innerHTML = `이메일 형식에 맞게 입력해주세요`;
		authReqBtn.disabled = true;
	}
}
// 4. 인증요청 버튼을 눌렀을 때
function authReq(){
	console.log('인증 요청');
	
	// -- 인증요청 시 서블릿 통신 [ 인증코드 생성 , 이메일 전송 ]
	$.ajax({
		url : "/jspweb/AuthSendEmail",
		method : "get" ,
		data : {memail : document.querySelector('.memail').value},
		success : r => {
				// 1. div 호출
			let authbox = document.querySelector('.authbox');
			
			// 2. auth html 구성
			let html = `<span class="timebox"> 02:00 </span>
							<input class="ecode" type="text"/>
							<button class="authReqBtn" onclick="auth()" type="button">인증</button>`
			authbox.innerHTML = html;
			// 4. 타이머 실행
			authcode = r;	// '1234' 테스트용
			timer = 120;			// 인증 제한시간 10초 테스트용
			settimer();			// 타이머 실행	
			
		} ,
		error : r =>{console.log(e)}
	})
	
}

// 4번 5번 함수에서 공통적으로 사용할 변수[전역변수]
let authcode = ''; // 인증코드
let timer = 0; // 인증 시간 변수
let timerInter; // setInterval() 함수를 가지고 있는 변수 [ setInterval 종료 시 필요 ]

// 5.타이머 함수 만들기
function settimer(){
	// setInterval( 함수명 , 실행간격[밀리초]) : 특정시간마다 함수를 실행 함수
	timerInter = setInterval( () => {
		// 시간 형식 만들기
			// 1. 분 만들기 [ 초 / 60 ] => 분 / [ 초 % 60 ] => 나머지 초
		let m = parseInt( timer / 60 ); // 분 계산 [ 몫 ]
		let s = parseInt (timer % 60 ); // 초 계산 [ 나머지 ]
			// 2. 두자리수 맞춤 3 -> 03
		m = m < 10 ? "0"+m : m; // 만약에 분이 한자리수 이면 0붙이고 아니면 안붙임
		s = s < 10 ? "0"+s : s; 
		
		document.querySelector('.timebox').innerHTML = `${m}:${s}`; // 현재 인증 시간(초) HTML 대입
		timer--; // 1씩 차감 
		
		// 만약에 타이머가 0이면 [ 시간 끝 ]
		if( timer < 0 ){
			// 1. setInterval 종료 [ 누구를 종료할건지 식별자.. 변수 선언 = timerInter ]
			clearInterval( timerInter )
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = '인증실패';
			// 3. authbox 다시 숨김
			document.querySelector('.authbox').innerHTML = ``;
		  }
		
	} , 1000); // 1초에 한번씩 실행되는 함수
}

// 6. 인증요청 후 인증코드를 입력하고 인증하는 함수
function auth(){
	
	// 1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	
	// 2. 비교[ 인증코드와 입력받은 인증코드 ]
	if( authcode == ecode ){
		// 1. setInterval 종료
		clearInterval( timerInter ); // 1. setInterval
		// 2. 인증성공 알림
		document.querySelector('.emailcheckbox').innerHTML = '인증성공';
		// 3. authbox 구역 HTML 초기화
		document.querySelector('.authbox').innerHTML = '';
		checkList[2] = true;
	}else{
		// 1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML = '인증코드 불일치';
		checkList[2] = false;
	}
	
}

// 7. 첨부파일에 등록된 사진을 HTML표시하기 < 등록 사진을 미리보기 기능 >
function preimg( object ){ console.log('사진 선택 변경')
	console.log(object); // 이벤트 발생시킨 태그의 DOM 객체를 인수로 받음
	console.log( document.querySelector('.mimg'));
	// 1. input태그의 속성 [ type,class,onchange,name 등등]
	// 1. input태그 이면서 type="file" 이면 추가적인 속성
		// .files : input type="file" 에 선택한 파일 정보를 리스트로 받음
	console.log( object.files );
	console.log( object.files[0] );
	
	// --- 해당 파일을 바이트코드 변환
	// 2. JS 파일 클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일 읽기 객체 선언
	// 3. 파일 읽어오기 함수 제공
	file.readAsDataURL( object.files[0] ); // input에 등록된 파일리스트 중 1개를 파일 객체로 읽어오기
		console.log( file )
	// 4.읽어온 파일을 해당 html img태그에 load
	
	file.onload = e=>{ // onload() : 읽어온 파일의 바이트코드를 불러오기
		console.log(e); // 이벤트 정보
		console.log( e.target); // onload() 실행한 FileReader 객체
		console.log( e.target.result ); // 읽어온 파일의 바이트 코드
		document.querySelector('.preimg').src = e.target.result; // img src 속성에 대입
	}
}
let checkList = [false, false , false];

// 8. 회원가입 메소드
function signup(){
	// 1. 아이디/비밀번호/이메일 유효성검사 통과 여부 체크
	if( checkList[0] && checkList[1] && checkList[2] ){
		console.log('회원가입 가능')
		
		// 2. 입력받은 데이터를 한번에 가져오기 form 태그 이용
			// <form> 각종 input/button </form>
			// 1. form 객체 호출 document.querySelector()
			let signupForm = document.querySelectorAll('.signupForm')[0];
			console.log(signupForm);
			let signupData = new FormData( signupForm ); // 첨부파일 [대용량]시 필수
			// 3. AJAX 에게 첨부파일[대용량] 전송하기
			// 1. 첨부파일 없을 때
			/*
			$.ajax({
				url : "",
				method : "" ,
				data : "",
				success : r =>{},
				error : r=>{}
			});
			*/
			// 2. 첨부파일 있을 때 [기존 json형식의 전송x form 객체 전송 타입으로 변환]
			$.ajax({
				url : "/jspweb/MemberInfoController",
				method : "post" ,
				data : signupData,
				contentType : false ,
				processData : false,
				success : r =>{},
				error : r=>{}
			});

	}else{
		console.log('회원가입 불가능')
	}
}
// 1. 회원가입 메소드
/*function signup(){
	
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
}*/


/*
	setInterval() : 특정시간마다 함수 실행 함수
		1. 정의
			let 변수명 = setInterval( function 함수명(){} , 밀리초 )
			setInterval( function (){} , 밀리초 )	
			setInterval( () => {} , 밀리초 )
			setInterval( () => {} , 밀리초 )
		2. 종료
			clearInterval( setInterval변수명 )
*/






