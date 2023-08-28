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

//입실정보등록
function checkIn(){
   let seatnoInput = document.querySelector('.ch_num');
   let nameInput = document.querySelector('.name');
   let phonenumberInput = document.querySelector('.phonenumber');

   console.log("seatno  :  " + seatnoInput.innerText);
   console.log("name  :  " + nameInput.value);
   console.log("phonenumberInput  :  " + phonenumberInput.value);
   //객체화
   let info = {
      name: nameInput.value,
      phonenumber:phonenumberInput.value,
      seatno:seatnoInput.innerText
   }
   console.log("info >> "+info);
   $.ajax({
      url :"/jspweb/Library",
      method : "post",
      data : info,
      success: r => {
         console.log('통신성공' + r)
         alert("입실정보가 정상등록되었습니다.")
         nameInput.value='';
         phonenumberInput ='';
         read();
      },
      error : r => {

         console.log('통신실패 : '+ r );
      }
   });
}
// 퇴실 함수
function getOut(){
	
	if( checkPhone() == -1 )
		return;
	if( checkPhone() == false)
		return alert('전화번호가 일치하지 않습니다.')
	
	
	$.ajax({
		url: "/jspweb/Library" ,
		method : "put",
		data : {type: "out" , nowNum : nowNum},
		success: r => {
			if( r == true ){
				alert('퇴실되었습니다.'); read();
			}			
			else
				alert('퇴실 실패하였습니다. 다시 시도해주세요.')
		} ,
		error: r => {} 
	});
}
// 핸드폰번호 체크
function checkPhone(){
	

	if(nowNum == 0) {
		alert('좌석을 선택해주세요.');
		return -1;
	}
	let phoneNumber = prompt('전화번호를 입력해주세요 : ');
	//유효성 검사 위한 ajax
	$.ajax({
		url : "/jspweb/Library" ,
		method : "get" ,
		data : {type : "checkPhone" , phoneNumber : phoneNumber , nowNum : nowNum},
		success : r => {
			console.log('getOut통신')
			// 저장 되어있는 전화번호가 있다면 true 없다면 false
			if(r == true)
				return true;
			else
				return false;		
		} ,
		error : r => {
			console.log('getOut통신 실패');
			alert('잠시 후에 이용해주세요.')
		}		
	});
	
}




