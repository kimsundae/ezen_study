console.log('calendar.js')

// 0. 현재 연도/월 [ 초기값 ]
	// new Date() : 현재 시스템 날짜/시간 반환해주는 클래스
	// new Date( 연도 , 월 , 일 ) : 사용자 정의 날짜 반환해주는 클래스
		//.getFullYear()  : 연도
		//.getMonth()	: 월[ 0~11 ]
		//.getDay()		: 요일[ 일0 ~ 토6 ]
		//.getDate()	: 일
		//[다음달 1일에서 -1 ]현재 월의 마지막 일수 구하기
let year = new Date().getFullYear();	// 현재 연도
let month = new Date().getMonth()+1;	// 현재 월[ 0 ~ 11 ] +1
// * 전역 배열
let contents = []; // 여러개 일정객체를 저장하는 배열
console.log( year ); console.log( month );

// 1. 현재 연도/월 기준으로 달력 출력 하는 함수
calPrint();
function calPrint(){	console.log('calPrint')
	// 1. 현재 연도와 월을 해당 구역에 출력하기
	document.querySelector(`.caldate`).innerHTML = `${ year }년 ${ month }월`
	// 1. 요일과 일 출력
	
		/*
			1. 시작 요일	
			2. 현재 월 마지막 일
		*/
	//1. 시작 요일
	let now = new Date( year , month-1 , 1 )
	let sWeek = now.getDay(); console.log( sWeek );
	// 2. 현재 월의 마지막 일 구하기
	let now2 = new Date(year , month , 0);
	let eDay = now2.getDate();
	
	
	
	let calendar = document.querySelector(`.calendar`);
	let html = '';
	// 1. 요일
	html += `<div class="week sunday"> 일 </div><div class="week"> 월 </div><div class="week"> 화 </div>
				<div class="week"> 수 </div><div class="week"> 목 </div><div class="week"> 금 </div>
				<div class="week"> 토 </div>	`
	// **** 현재 달력 1 일의 요일까지 공백 출력
	for(let b = 1; b<=sWeek; b++){ // 1부터 1일의 요일까지 공백 구역 출력
		html+= `<div></div>`
	}
	
	//2. 일수
	for( let day = 1; day <= eDay; day++)
		html += `<div onclick="openModal( ${ day })"> 
					${ day }
					${ contentPrint(`${year}-${month}-${day}`)}
					
				 </div>`
				// 만약에 현재 날짜와 일정목록 등록된 일정의 날짜와 같으면 출력
	calendar.innerHTML = html;
}

// 6. 일정 출력함수 [ 실행조건 : 만약에 현재 날짜와 동일한 일정 날짜 찾아서 출력 ]
	// 인수 : 함수 안으로 들어오는 수/값/데이터 = 날짜
	// 반환 : 함수 {} 끝나고 함수 호출 했던 곳으로 수/값/데이터 = 해당날짜의 일정 내용 HTML
function contentPrint(date){
	// 인수로 들어온 날짜와 같은 일정목록에서 일정 찾기
	let html = ``;
	for( let i = 0; i < contents.length; i++){
		if( date == contents[i].date){
			html += `<span class="content" style="background-color:${ contents[i].color };"> ${ contents[i].content } </span>`
		}
	}
	return html;
}

// 2. 버튼을 클릭했을 때 현재 월 변화해주는 함수
function onNext( check ){
	if( check == 0){ // 이전 달
		month--;		// 현재 보고 있는 월 1 차감
		// 만약에 월이 차감했는데 1보다 작아지면 12월 변경하되 연도1 차감
		if(month < 1 ){ month=12; year--;}
	
	}else if (check == 1){ // 다음 달
		month++;	// 현재 보고 있는 월 1 증가
		if( month > 12){month=1; year++;}
	}	
	// 2. 월 증감후 새로고침
	calPrint();
}

// 3. 모달 열기
function openModal( day ){
	document.querySelector(`.modalwrap`).style.display = 'flex';
	// * 현재 클릭한 일수의 날짜 출력
	document.querySelector('.date').innerHTML = `${year}-${month}-${day}`
	
}

// 4. 모달 닫기
function closeModal(  ){
	document.querySelector(`.modalwrap`).style.display = 'none';
}


// 5. 일정 등록 버튼 클릭했을 때 [ 실행조건 : 등록버튼을 클릭했을 때 ]
function onWrite(){
	// 1. 입력받은 값 호출
	let color = document.querySelector('.color');
	let contentInput = document.querySelector('.contentInput');
	let date = document.querySelector('.date');
	// 2. 가공 [ 1.유효성검사 , 2.객체화 ]
	
	let object = {
		color : color.value ,
		content : contentInput.value ,
		date : date.innerHTML ,
	}
	// 3. 저장
	contents.push( object );
	console.log( contentInput );
	
	
	// 4. 비워주기
	
	contentInput.value = ``;
	// 5. 모달닫기  / 새로고침
	closeModal();	calPrint();
	
}


