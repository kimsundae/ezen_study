// 1. 테스트
setPoint( 1000, '회원가입축하')
// 1. 포인트 사용 함수
function setPoint( mpamount , mpcomment ){
	if(loginState == false ){return;}
	$.ajax({
		url:"/jspweb/PointController",
		method:"post",
		data : {mpamount:mpamount , mpcomment:mpcomment},
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
		success : r=>{console.log(r)},
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
// 2.
  function requestPay() {
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",
      pay_method: "card",
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "노르웨이 회전 의자",
      amount: 64900,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
    });
  }