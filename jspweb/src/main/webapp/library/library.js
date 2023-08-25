// 현재 선택된 좌석번호
let nowNum = 0;

/* 버튼 출력 함수 */
read();
function read(){
	
	
	$.ajax({
		url : "/jspweb/Library" ,
		method : "get" ,
		data : "",
		success : r => {
			console.log('통신 성공');
			let html = ``;
			let readButton =  document.querySelector('.button_box');
			for(let i = 0; i < r.length; i++){
				if(r[i].lisuse == true)
					document.querySelector(`.button${i+1}`).style.backgroundColor = 'orange';
				else
					document.querySelector(`.button${i+1}`).style.backgroundColor = 'white';	
			}
		},
		error : r => {
			console.log('통신 실패')
			
		}	
	});	
}
// 좌석 선택 함수
function chNum( num ){
	nowNum = num;
	document.querySelector('.ch_num').innerHTML = num;
}
// 입실 함수
function getIn(){
	
}
// 퇴실 함수
function getOut(){
	checkPhone()
}
function checkPhone(){
	// 저장 되어있는 전화번호가 있다면 true 없다면 false
	let isPhoneExists = false;
	if(nowNum == 0) return alert('좌석을 선택해주세요.');
	let phoneNumber = prompt('전화번호를 입력해주세요 : ');
	//유효성 검사 위한 ajax
	$.ajax({
		url : "/jspweb/Library" ,
		method : "get" ,
		data : {phoneNumber : phoneNumber},
		success : r => {
			console.log('getOut통신')
			if(r == true)
				isPhoneExists = true;
			else
				isPhoneExists = false;		
		} ,
		error : r => {
			console.log('getOut통신 실패');
			alert('잠시 후에 이용해주세요.')
		}		
	});
	
	if( !isPhoneExists ) 
 			
 	else
 		return alert('퇴실에 실패했습니다.');
}




