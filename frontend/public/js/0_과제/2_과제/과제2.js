// document : HTML문서( DOM객체 )
		// query : 쿼리(질의)
		// Selector : 선택자 ( id , class , 마크업 등 )
			// 1. document.querySelector(".sname") : sname 이라는 class명 가진 input객체 호출
			// 2. 호출된 input객체를 'sname' 변수에 담았다.
	//2.입력받은 데이터 가져오기

let 아이디 = [ ]
let 비밀번호 = [ ]
function creat(){
	let id = document.querySelector(".id")
	let password = document.querySelector(".password")					
		 if(  id.value.length >= 8 &&  password.value.length >=8 ){
			 아이디.push(id.value);
			 비밀번호.push(password.value);
			 alert('회원가입 완료')				
		} else {
			alert('로그인 실패')			
		}	
		id.value = ""
			password.value = ""		
}
function login(){
	
	loginId = document.querySelector('.loginId')
	loginPassword = document.querySelector('.loginPassword')
	
	if(아이디.indexOf(loginId.value) == -1){
		alert('일치하는 아이디가 없습니다')
		loginId.value = ""
		loginPassword.value = ""
	}
	else if(비밀번호.indexOf(loginPassword.value) == -1){
			alert('일치하는 비밀번호가 없습니다')
			loginId.value = ""
			loginPassword.value = ""
	} 
	else if(아이디.indexOf(loginId.value) != -1 && 비밀번호.valueOf(loginPassword.value) != -1){
			alert('로그인 성공!')
			loginId.value = ""
			loginPassword.value = ""
	}	
}



