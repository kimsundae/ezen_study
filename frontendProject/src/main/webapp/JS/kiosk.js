console.log('kiosk.js 열림');

//-----------------샘플 데이터---------------//


// 1. 광고이미지 변경
	// 1. 광고이미지 여러개 저장하고 있는 공간 = 배열
let bimgList = [ 'himg1.png' , 'himg2.png' , 'himg3.jpg' , 'himg4.png' , 'himg5.png' ]

//1. 카테고리 여러개 저장하는 배열
let categoryList = [ '신제품(new)', '프리미엄' , '와퍼&주니어' , '치킨&슈림프버거' , '올데이킹&킹모닝' ];
	//1. 제품 여러개 저장하는 배열
		// 서로 다른 유형들의 데이터 여러개 저장 = 객체 { }
		// 동일한 유형들의 데이터 여러개 = 배열/리스트
		// 버거이름 , 버거가격 , 버거이미지 , 버거카테고리 , 버거이름2 , 버거가격2 , 버거이미지2 , 버거카테고리2
		// [ { 버거이름 , 버거가격 , 버거이미지 , 버거카테고리 } , { 버거이름2 , 버거가격2 , 버거이미지2 , 버거카테고리2 }]
		// 다른 배열이나 객체의 연관관계
		// 카테고리(상위) -----> 제품(하위)	// 카테고리식별값 ---> 제품에 저장 [ pk ---> fk ]
let burgerList = [ 
					{name : '헬로디아블로와퍼' , price : 9500 , img : '헬로디아블로와퍼.png' , category : 0 } ,
					{name : '헬로릴리트와퍼' , price : 12500 , img : '헬로릴리트와퍼.png' , category : 0} ,
					{name : '치킨킹' , price : 8000 , img : '치킨킹.png' , category : 3} ,
					
				]
	// 1. 카트(장바구니) 배열 / 선택 버거들이 저장되는 배열
		// 1. 버거객체? 2. 버거의식별 = 중복x ???
let cartList = [  ]

	//1. 주문(주문내역) 배열
		//   주문 { 주문번호 : , 주문날짜 :  , 결제금액 : , 주문제품 : [ ] , 상태 : 0[주문요청] 1[주문완료] 2[주문취소] }
		
let orderList = [ { ono: 1 , date : '2023-07-05 13:30:21' , pay : 30000 , products : [ 0 , 0 , 2 ] , state : 1 } ]
	
	
//-------------------------------------------------------------//
	// 2. 특정시간마다 이미지의 src 변경 하기
		// - setInterval( 함수/기능 , 밀리초 ) : 1/1000초
		// 1. function 함수(){}  2. function (){} 3. () => {}
			// setInterval( ()=>{ 실행코드 } , 2000 ); // 2초마다 실행코드 주기적으로 실행
let viewhimg = 0; // 현재 출력 중인 광고이미지 인덱스 저장하고 있는 변수
setInterval( ()=> { 
	// 1. 해당 이미지 태그 객체 호출
	let himg = document.querySelector('.himg');
	// 2. 호출된 객체에서 src속성 대입
		// 배열내 이미지 하나씩 바꿔가면서 대입
		viewhimg++; // 인덱스 증가시킴 [ 다음 이미지로 변경 ]
			// 만약에 마지막인덱스 다음이면[끝] 처음인덱스[0] 이동
		if( viewhimg >= bimgList.length ){ viewhimg = 0; }
	himg.src = `../img/${ bimgList[viewhimg]}`;		
}	, 2000 );
	
// 2. 카테고리 출력 [ 어디에 무엇을 출력? ] 함수
	
	//2. 카테고리 출력 함수 정의 [ 실행 조건 : 1. 페이지 열렸을 때]
categoryPrint( 0 ); // 최초 1번 실행 [ 가장 앞에 있는 카테고리 선택 가정]
productPrint( 0 );
function categoryPrint( selectNo ){
	// 1. 어디에
	let categorymenu = document.querySelector('.categorymenu');
	// 2. 무엇을
	let html = '';
		// HTML 구성 : 배열내 모든 데이터 ( for ) 를 li 형식으로 출력
	for( let i = 0; i < categoryList.length; i++ ){
		// 선택된카테고리(selectNo)
		if ( i == selectNo ){html += `<li onclick="categorySelect( ${ i })" class="categoryselect">${ categoryList[i] }</li>`		}
		else { 	html += `<li onclick="categorySelect( ${ i })">${ categoryList[i] }</li>` }
	// 3. 구성된 html 출력
	categorymenu.innerHTML = html;
	}
	
}

// 3. 카테고리 클릭		[ 실행 조건 : 1. li에서 클릭했을 때]
function categorySelect( selectNo ){
	// <li> 여러개 존재 하는데 무엇 선택했는지 식별
	console.log(selectNo);
	
	// 0. 카테고리의 모든 li 호출 [ querySelector 1개 호출 = 객체1개 vs querySelectorAll 여러개 호출 = 여러개객체(배열) ]
	let categoryli = document.querySelectorAll(`.categorymenu li`); // 해당 클래스 ul 안에 있는 모든 li 호출
		console.log(categoryli);
	
	// 1. 해당 선택된 인덱스의 class 추가 // !! JS에서 class추가 / 삭제 가능
	for( let i = 0; i < categoryList.length; i++){
		// 2. 선택된 인덱스[selectNo]의 i번째 카테고리 찾기
		if( selectNo == i ){
			// 해당 li 에 class 추가 DOM객체명.classList.add( '새로운 클래스명' )
			categoryli[i].classList.add(`categoryselect`);
		}else{
			// 해당 li 에 class 삭제 DOM객체명.classList.remove( '새로운 클래스명' )
			categoryli[i].classList.remove(`categoryselect`);
		}
	}
	productPrint( selectNo )
}
// ---------------------//
//4. 제품 출력 함수 [ 실행 조건 : 카테고리 클릭(변경) 되면 ]
function productPrint( categoryNo ){ // 어떤 카테고리의 제품 출력할 건지? 인수 설정
console.log( categoryNo )
	// 1. 어디에
	let productbox = document.querySelector('.productbox')
	// 2. 무엇을 [ 선택된 카테고리에 맞는 제품들만 출력 ]
	let html = ``;
		//html 구성
		for(let i = 0; i < burgerList.length; i++){ // 모든 버거배열/리스트[서랍장] 열어서 확인
			//i번째 버거의 카테고리와 선택한 카테고리와 같으면 html 구성 
			if(burgerList[i].category == categoryNo){
				html += `<div class="product" onclick="productSelect(${i})">	
							<img src="../img/${burgerList[i].img}"/>		
							<div class="pinfo">
								<div class="pname">${ burgerList[i].name }</div> 
								<div class="pprice">${ burgerList[i].price.toLocaleString() }원</div>		
							</div>	
						</div>`
			}
		}// f end
	// 3. 출력[대입]
	productbox.innerHTML = html;	
}

// 5. 제품 선택해서 카트에 담는 함수 [ 실행 조건 : 1. 제품 이미지를 클릭하면]
function productSelect( productNo ){ //어떤 제품을 카트에 담을 건지? 인수 판단
	console.log(burgerList[productNo].name);
	// 1. 선택된 버거의 인덱스를 배열에 저장 [ 버거의 모든 정보를 저장할 필요가 없음]
	cartList.push( productNo );
	console.log( cartList );
	//2.
	cartPrint();
}

// 6. 카트내 버거들을 출력 함수 [ 실행조건 : 1. 카트내 제품이 등록되면( 5번 함수 하단 호출) 2.카트내 제품 취소되면( 7,8번 함수 하단 호출)]
function cartPrint( ){
	let cartbottom = document.querySelector(`.cartbottom`);
	//2. 무엇을?? 카트내[배열내] 모든 제품( for문 ) 출력
	let html = ``;
		let totalPrice = 0; // 카트내 버거들의 가격을 모두 더한 값을 저장 변수
	for(let i = 0; i < cartList.length; i++){
		// 1. 카트내 버거의 인덱스
		let burgerIndex = cartList[i]; console.log(burgerList);		
		// 2. i번째 제품을 HTML 구성
		html += `<div class="citem">						
							<div class="iname">${burgerList[burgerIndex].name}</div>	
							<div class="iprice">${burgerList[burgerIndex].price.toLocaleString()}원</div>	
							<span onclick="productCancel(${i})" class="icencel"> X </span>	
						</div>`
		// 3. i번째 가격을 누적합계
		totalPrice += burgerList[burgerIndex].price;
	}
	//3. 출력/대입
	cartbottom.innerHTML = html;		
	// * 카트내 제품 수
	document.querySelector(`.ccount`).innerHTML = `${ cartList.length }`;
	// * 카트내 제품 총가격
	document.querySelector(`.ctotal`).innerHTML = `${ totalPrice.toLocaleString() }원`;	
	// * 만약에 카트내 제품이 많아서 가로 스크롤 생성 되었을 때 가장 오른쪽으로 이동 
	cartbottom.scrollLeft = 10000;
}
// 7. 카트내 버거 부분 취소 함수
function productCancel( cartIndex ){ // 전체취소: 인수X 부분취소: 인수O
	// 1. 선택된 카트배열내 인덱스 삭제
	cartList.splice( cartIndex , 1 ); alert('버거 취소 했습니다.')
	// 2. 카트 화면 호출
	cartPrint()	
}
// 8. 카트내 버거 전체 취소 함수
function cartCancel(){ // 전체취소 : 모두취소 : 인수X 	
	cartList.splice( 0 ); // 배열내 모든 요소 삭제					
	cartPrint();	
}

// 주문 데이터 구조화
//   주문 { 주문번호 : , 주문날짜 :  , 결제금액 : , 주문제품 : [ ] , 상태 : 0[주문요청] 1[주문완료] 2[주문취소] }
// 9. 카트내 저장된 버거 주문(등록) 함수 []
function productOrder(){
	alert('주문 했습니다.')
	
	// * 주문번호 만들기
	let ono = orderList[orderList.length - 1].ono
	// * 카트(전역변수)에 있던 버거인덱스를 새로운 배열에 저장
	let products = []; // 주문이 들어가는 버거들 인덱스
	let totalprice = 0;
	for(let i = 0; i < cartList.length; i++){ // i번째 버거를 새로운 배열에 저장
		products.push(cartList[i]);	// i번째 버거의 인덱스를 새로운 배열에 저장
		totalprice += burgerList[cartList[i]].price 
	}
	// 1. 주문객체 생성해서
	let order = {
		ono : ono+1 ,			// 주문번호 생성해서 저장 [ 마지막주문번호 + 1]
		date : new Date(),		// 현재날짜/시간 구해주는 함수 이용해서 자동으로 대입
		pay : totalprice ,				// 주문객체 생성 시 주문요청으로 상태 초기로 사용
		products : products ,	// 카트에 있던 모든 제품들 // 전역변수[cartList]대입 시 문제 발생
		state : 0				// 주문객체 생성시 '주문요청' 으로 상태 초기로 사용
	}
	// 2. 주문배열에 저장하기
	orderList.push(order);
	
	// * 카트 초기화
	cartCancel() // 전체취소 함수
	// * 주문 리스트 확인
	console.log( orderList )
	
}



