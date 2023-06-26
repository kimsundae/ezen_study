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
	document.querySelector(".total").innerHTML = total.toLocaleString();
	document.querySelector(`.행${행번호}`).innerHTML = ''
	
}

function 입력(행번호){
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


