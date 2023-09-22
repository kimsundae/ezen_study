
// 1. 포인트 사용 함수
function setPoint( mpamount , mpcomment ){
	if(loginState == false ){return;}
	$.ajax({
		url:"/jspweb/PointController",
		method:"post",
		data : {mpamount:mpamount , mpcomment:mpcomment},
		async : false , /* ajax가 응답이 올 때까지 대기상태 = 동기식 */
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
	})
}
//2. 내 포인트 확인 함수
function getPoint(){
	if( loginState == false ) {return;}
	
	
	$.ajax({
		url:"/jspweb/PointController",
		method:"get",
		data : {type: "getPoint", mpamount:mpamount , mpcomment:mpcomment},
		success : r=>{console.log(r)		
		},
		error : e=>{console.log(e)}
	})	
}
// 3. 내 포인트 내역 전체 출력 함수
function getPointList(){
	if( loginState == false){return;}
	$.ajax({
		url:"/jspweb/PointController",
		method:"get",
		data : { type: "getPointList" ,mpamount:mpamount , mpcomment:mpcomment},
		success : r=>{console.log(r)},
		error : e=>{console.log(e)}
	})	
}




//--------------- 결제 연동-------------------- //
// 1. 아임포트 
IMP.init('imp76071486') // 예: 'imp00000000a' 아임포트 콘솔에서 확인
// 2. 결제 함수[속성은 pg사마다 상이]
  function requestPay() {
	  
	  // 2-1 : 만약에 결제방식을 선택했으면
	  if( pay_method == '' )return alert('결제방식을 선택해주세요')
	  
	  // 2-2 : 주문번호 만들기
	  	// 고유성/중복x/PK/식별키
	  	// 1. 날짜(밀리초)+상품코드+회원번호 조합해서 설계
	  	// 2. 회사 전화 번호
	  	let now = new Date(); console.log(now); // 현재날짜
	  	let time = now.getTime();console.log(time); // 현재 시간 밀리초
	  	let merchant_uid =  "p"+time +"-"+ loginMid; console.log(merchant_uid)
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",	// 아임포트 콘솔에서 확인
      pay_method: pay_method,
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "포인트 결제",	
      amount: amount,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
   		console.log(rsp)
      //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
      if( rsp.success ){
		  
	  }else{ // 결제 실패 [테스트 : 실패가 성공이라는 가정 ]
		 alert('.결제성공') 
		 // 1. 포인트 적립 기능처리
		 setPoint( amount , '포인트결제');
		 // 2. 결제 내역 테이블 기능처리[구현x]
	  }
    });
  }
  
// 3. 결제 방식 선택 함수
let pay_method = ''; // 결제방식
function onPayMethod( method ){
	pay_method = method;
}
let amount = 0; // 결제금액
function onAmount( value ){ amount = value; }