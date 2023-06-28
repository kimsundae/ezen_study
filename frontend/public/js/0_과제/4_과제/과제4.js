
let 작성정보 = [];

// 필드
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
	console.log(writer)
	console.log(작성정보)
	list();	
	// 유효성 검사 
}	
function list(){
	let a=''
	
	for(let i = 0; i < 작성정보.length; i++){
		a += `<tr class="cotent${i}" onclick="info(${i})">
				<td>${i+1}</td>
				<td>${작성정보[i].writeHead}</td>
				<td>${작성정보[i].writeName}</td>
				<td>${작성정보[i].view}</td>
			</tr>`		
	}
	document.querySelector(`.table`).innerHTML = a;
	a = ``;																			
}
function listDelite(){
	
}

function info(num){
	
	document.querySelector(`.inPageContent`).innerHTML =
											`<div class="look">										
												<p>제목:${작성정보[num].writeHead}</p>
												<p>내용:${작성정보[num].contentBox}<p>
												<p>작성자:${작성정보[num].writeName}<p>
												<p><button onclick='delite(${num})'>삭제</button><p>
											</div>`;
																
}
function delite(num){
	작성정보.splice(num , 1)
	document.querySelector(`.inPageContent`).innerHTML ='';	
	document.querySelector(`.table`).innerHTML ='';
	list()
	
	
											
}
