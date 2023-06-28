//객체 저장 할 배열
let 작성정보 = [];

//글 등록 함수
function save(){
	// 객체 저장	
	let writer = { 
					writeName : document.querySelector(`.writeName`).value,
					writePassword : document.querySelector(`.writePassword`).value,
					writeHead : document.querySelector(`.writeHead`).value,
					contentBox : document.querySelector(`.contentBox`).value,
					//조회수
					view : 0}
	작성정보.push(writer);		
	list();	
	
}	
// 글 등록 시 글 목록 페이지  
function list(){
	// table 초기화 
	document.querySelector(`.table`).innerHTML = ``;
	
	let print =`<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>					
					<th>조회수</th>
				</tr>`	
	//배열에 있는 객체 정보 표시
	for(let i = 0; i < 작성정보.length; i++){
		
		print += 							
				`<tr class="cotent${i}" onclick="info(${i})">
					<td>${i+1}</td>
					<td>${작성정보[i].writeHead}</td>
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
												<p><button onclick='delite(${num})'>삭제</button><p>
											</div>`;
	// 객체 view 속성의 값을 1++ 후 list()실행
	작성정보[num].view++
	list();															
}
// 삭제버튼 온클릭 함수
function delite(num){
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
