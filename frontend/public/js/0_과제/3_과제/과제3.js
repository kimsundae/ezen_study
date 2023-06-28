/*
	<주요기능1 등록>
	1. html 작성 : input 3개 button 2개
	2. 이벤트 발생
		출력 이벤트
		<button onclick=""> 등록 </button>
	3. 무슨 이벤트를 발생 시킬건지 구체적으로 정의
		등록 버튼 클릭했을 때 함수 실행
		
		1. 인풋에 입력된 3개의 데이터를 모두 가져오기
			1. 마크업 선택자 정의
					
		2. DOM객체 함수를 이용한 선택자의 마크업 객체로 호출
			document.getElementsByClassName
			document.querySelector
			
		3. DOM 객체의 입력된 값 호출	
			input, textarea , select => value 속성 가능	
			div , span , table 등등 => value 속성 불가능
			
	2. 배열에 저장 ??
		* 배열은 여러개 데이터 저장할 수 있다.
		* 함수는 종료되는 순간 = { } 에서 사용되었던 메모리 모두 초기화/사라짐
		
		날짜 , 항목 , 금액
		1. 인덱스 순으로 데이터 형태 구분
			let 가계부 = [ '2023-06-27' , '콜라' , '10000' , '2023-06-27', '사이다' , '3000']
		
		2.
			각 배열당 0번 인덱스가 날짜,항목,금액
			
			let 가계부_날짜 = [ '2023-06-27' , '2023-06-27' ]
			let 가계부_항목 = [ '콜라' , '사이다']
			let 가계부_금액 = [ '10000' , '3000' ]
			
		< 주요기능3 - 삭제 >
			1. HTML 작성 button
			2. 삭제 이벤트 ???? 삭제 버튼을 클릭했을 때 삭제함수 실행
				<button onclick="삭제()"> 삭제 </button>
				
			3. 
*/

let 날짜 = []
let 항목 = []
let 금액 = []
let total = 0;
let i = 0;

// 행 추가 함수
function 행추가(){
	document.querySelector('.테이블').innerHTML +=
	 `<tr class="행${i}">
	 	<td><input class="날짜${i} "type="date"/></td>
	 	<td><input class="항목${i} type="text"/></td>
	 	<td><input class="금액${i} "type="text"/></td>
	 	<td>
	 		<button onclick="행삭제(${i})">삭제버튼</button>
	 		<button onclick="입력(${i})">입력버튼</button>
	 	</td>	 	
	 </tr>`
	 i++;
}
// 행 삭제 함수
function 행삭제(행번호){
	total -= Number(금액[행번호])
	날짜.splice(행번호 , 1)
	항목.splice(행번호 , 1)
	금액.splice(행번호 , 1)
	document.querySelector(".total").innerHTML = total.toLocaleString();
	document.querySelector(`.행${행번호}`).innerHTML = ''	
	i--;
}

function 입력(행번호){
	// 1. HTML 특정 태그를 가져오기
	// document.getElementsByClassName("클래스명")
	// * 유효성검사 : 만약에 3가지중에 하나라도 공백이면
	if(document.querySelector(`.날짜${행번호}`).value == `` || 
		document.querySelector(`.항목${행번호}`).value == '' || 
		document.querySelector(`.금액${행번호}`).value == '')
		{
		alert('모두 입력해주세요.')		
	}
		날짜.push(document.querySelector(`.날짜${행번호}`).value)
		console.log("날짜 : " + 날짜)
		항목.push(document.querySelector(`.항목${행번호}`).value)
		console.log("항목 : " + 항목)
		금액.push(document.querySelector(`.금액${행번호}`).value)
		console.log("금액 : " + 금액)
		총금액(행번호)
		console.log(금액[0])
}

function 총금액(행번호){	
	total += Number(금액[행번호])
	console.log(total)
	document.querySelector(".total").innerHTML = total.toLocaleString();
}


