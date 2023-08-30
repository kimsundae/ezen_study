
// 직원 등록하기 함수
function hregist(){
	
	if( isNull == false )
		return alert('공백 입력 불가');
	if(isPhoneUse(document.querySelector('.hphone').value) == true)
		return alert('이미 있는 전화번호입니다.');
		
	let form = document.querySelectorAll('.hform')[0];
	let registData = new FormData( form );
	
	$.ajax({
		url: "/jspweb/HrmController",
		data : registData ,
		method : "post" ,
		contentType : false ,
		processData : false,
		success : r =>{
			if(r){
				alert('등록되었습니다.');				
			}
				
			else{
				alert('등록 실패되었습니다.')		
			}
			location.reload();	
		},
		error : r => {console.log(r)}
		
	});
}
read();
// 직원 전체 출력함수
function read(){
	
	$.ajax({
		url: "/jspweb/HrmController",
		data : {type : "read"} ,
		method : "post" ,		
		success : r =>{
			if(r){
				console.log(r);
				let html = ``;
		for(let i = 0; i < r.length; i++){
			html += `<ul class="hout">
						<li><img src="/jspweb/hrm/img/${r[i].himg}" class="imgBox" width="100px"></li>
						<li>이름 : ${r[i].hname}</li>
						<li>전화번호 : ${r[i].hphone}</li>
						<li>직급 : ${r[i].hrank}</li>
						<li>등록일 : ${r[i].hindate}</li>
					</ul>`			
				}
				document.querySelector('.houtBox').innerHTML = html;
			}
		} ,
		error : r => {console.log(r)}
	});
	
}

// 공백 확인 함수
function isNull(){
	if(document.querySelector('.hname').value != '' 
 			&&document.querySelector('.hphone') != ''
				&& document.querySelector('hrank') != '') 
		return true
	else 
		return false;		
}

// 전화번호 중복 여부 함수
function isPhoneUse( hphone ){
	
	$.ajax({
		url: "/jspweb/HrmController",
		data : {type : "phoneCheck" , hphone : hphone } ,
		method : "post" ,
		success : r =>{console.log('등록 실행')},
		error : r => {console.log(r)}
	})
	
}
// 등록한 사진 보여주기 함수
function chimg( img ){
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일 읽기 객체 선언
	file.readAsDataURL( img.files[0] ); // input에 등록된 파일리스트 중 1개를 파일 객체로 읽어오기	
	file.onload = e=>{ // onload() : 읽어온 파일의 바이트코드를 불러오기
		document.querySelector('.preimg').src = e.target.result; // img src 속성에 대입
	}
}













