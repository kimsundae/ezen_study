

function 등록(){
	console.log(document.querySelector('.input_date').value);
	
	let content = document.querySelector('.input_content');
	let price = document.querySelector('.input_price');
	let date = document.querySelector('.input_date');
	
	let info = {
		content : content.value ,
		price : price.value ,
		date : date.value	
	}
	
	$.ajax({
		url : "/jspweb/Accountbook",
		data : info,
		method : "post",
		success : function f(r){
			if(r == true){
				alert('등록 성공');read();
			}else{
				alert('등록 실패')
			}
			
		},
		error : function f(r){
			console.log('error' + r)
		}
	});	
	content.value = '';
	price.value = '';
	date.value = '';
}
read();
function read(){
	
	$.ajax({
		url : "/jspweb/Accountbook",
		data : "",
		method : "get",
		success : function f(r){
			let output = `<div class="tittle">
							<div class="tcontent">내용</div>
							<div class="tprice">금액</div>
							<div class="tdate">날짜</div>
						</div>`
			for(let i = 0; i < r.length; i++){
				output += `<div class="text">
								<div class="content">${r[i].acontent}</div>
								<div class="price">${r[i].aprice}</div>
								<div class="date">${r[i].adate}</div>
								<div class="button_box">
									<button onclick="수정(${r[i].ano})" type="button">수정</button>
									<button onclick="삭제(${r[i].ano})" type="button">삭제</button>
								</div>
							</div>`
			}
			
			document.querySelector('.output_text').innerHTML = output;
		},
		error : function f(r){
			console.log('error' + r)
		}
	});	
}

function 수정( ano ){
	
	let content = prompt('수정할 내용');
	let price = prompt('수정할 가격');
	let updateInfo={
		ano : ano ,
		content : content ,
		price : price
	};
	
	$.ajax({
		url : "/jspweb/Accountbook",
		data : updateInfo,
		method : "put",
		success : function f(r){
			if(r == true){
				alert('수정 성공'); read();
			}else{
				alert('수정 실패')
			}
			
		},
		error : function f(r){
			console.log('error' + r)
		}
	});	
}
function 삭제( ano ){
	
	$.ajax({
		url : "/jspweb/Accountbook",
		data : {ano : ano},
		method : "delete",
		success : function f(r){
			if(r == true){
				alert('삭제 성공');read();
			}else{
				alert('삭제 실패')
			}
			
		},
		error : function f(r){
			console.log('error' + r)
		}
	});	
}