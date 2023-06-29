//객체 저장 할 배열
let 작성정보 = [];	
let now = new Date(); // 1. 현재 시스템(pc)의 날짜/시간 호출	
//글 등록 함수
function save(){
	
	// 객체 저장	
	let writer = { 
					writeName : document.querySelector(`.writeName`).value,
					writePassword : document.querySelector(`.writePassword`).value,
					writeHead : document.querySelector(`.writeHead`).value,
					contentBox : document.querySelector(`.contentBox`).value,
					date : `${ now.getFullYear() }년 
							${ now.getMonth()+1 }월 
							${ now.getDay() }일` ,
					//조회수
					view : 0}	
					
	// 날짜 모양으로 출력	
	/*let year = now.getFullYear();	console.log(`year : ` + year)// 현재 연도
	let month = now.getMonth();		// 현재 월
	let day = now.getDay();			// 현재 일
	let hour = now.getHours();		// 현재 시
	let minute = now.getMinutes();	// 현재 분
	let second = now.getSeconds();	// 현재 초	*/		
	
	//유효성검사 공백 확인
	if(	writer.writeName 		!= `` &&
	 	writer.writePassword 	!= `` &&
	 	writer.writeHead 		!= `` &&
		writer.contentBox 		!= ``)	{
			
		작성정보.push(writer);
		alert('[글이 등록되었습니다.]')		
		list();
		document.querySelector(`.writeName`).value = ``
		document.querySelector(`.writePassword`).value = ``
		document.querySelector(`.writeHead`).value = ``
		document.querySelector(`.contentBox`).value	= ``
	 } else {			
		 alert('모든 항목을 입력해주세요.')
	 }		
}	
// 글 등록 시 글 목록 페이지  
function list(){	
	
	let print =`<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>					
					<th>조회수</th>
				</tr>`	
	//배열에 있는 객체 정보 표시
	for(let i = 0; i < 작성정보.length; i++){
		
		print += 							
				`<tr class="content" onclick="info(${i})">
					<td>${i+1}</td>
					<td>${작성정보[i].writeHead}</td>
					<td>${작성정보[i].date}</td>
					<td>${작성정보[i].writeName}</td>					
					<td>${작성정보[i].view}</td>
				</tr>`		
	}
	document.querySelector(`.table`).innerHTML = print;																			
}
//게시글 온클릭 함수
function info(num){	
	document.querySelector(`.inPageContent`).innerHTML =
											`<div class="look">										
												<p>제목:${작성정보[num].writeHead}</p>
												<p>내용:${작성정보[num].contentBox}<p>				
												<p>작성자:${작성정보[num].writeName}<p>
												<p><button onclick='deletePost(${num})'>삭제</button><p>
												<p><button onclick=editPost(${num})>수정</button></p>
											</div>`;
	// 객체 view 속성의 값을 1++ 후 list()실행
	작성정보[num].view++
	list();															
}
// 삭제버튼 온클릭 함수
function deletePost(num){
	if(작성정보[num].writePassword == prompt('비밀번호를 입력해주세요 : ')){
		alert('[삭제 완료]')
		//삭제버튼 입력시 해당 객체 삭제
		작성정보.splice(num , 1)
		//글목록 페이지와 글보기 페이지 초기화 한 후 list()함수 호출
		document.querySelector(`.inPageContent`).innerHTML ='';	
		document.querySelector(`.table`).innerHTML ='';
		list()
	} else {
		alert('잘못된 비밀번호입니다.');
	}													
}
// 수정버튼 온클릭 함수
function editPost(num){
	// 비밀번호가 같다면
	if(작성정보[num].writePassword == prompt('비밀번호를 입력해주세요 : ')){
		// 제목과 내용 수정
		작성정보[num].writeHead = prompt(`제목을 입력해주세요 : `)
		작성정보[num].contentBox = prompt(`내용을 입력해주세요 : `)
		alert(`[수정 완료]`)
		작성정보[num].date = `${ now.getFullYear() }년 
							${ now.getMonth()+1 }월 
							${ now.getDay() }일`
		//상세페이지와 리스트를 재출력
		info(num);
		list();
	} else {
		alert('잘못된 비밀번호입니다.');
	}
}





