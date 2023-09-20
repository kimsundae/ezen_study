if(loginState == false ) {location.href="/jspweb/member/login.jsp"}
printList()
/* 0. 제품목록에서의 선택상자 모두 체크 기능 */
	// 1. 모든 checkbox를 가져오기
	let checkList = document.querySelectorAll('.checkbox');
	console.log(checkList)
	
	// 2. 첫번째 체크박스를 클릭 이벤트
		// dom객체명.addEventListener( '이벤트명' , (이벤트결과매개변수)=>{} )
		checkList[0].addEventListener('click' , (e)=>{
			console.log('.....'); console.log(e)
			console.log( checkList[0].checked) 
			// type="checkbox"인 input 태그는 checked 속성 이용한 체크여부 확인하기. true: 체크되어있는 상태 / false: 체크 안된 상태  
			// 3. 만약에 첫번째 체크박스가 체크 되면 모든 체크박스는 체크 활성화
			if( checkList[0].checked == true)
				checkList.forEach((check) => {check.checked = true})
			else
				checkList.forEach((check) => {check.checked = false})
		})



// 1. 찜한 제품 목록 출력하기
function printList(){
	$.ajax({
		url:"/jspweb/PwishListController",
		method:"get",
		async: false,
		data : {type:'findByAll'},
		success: r => {console.log(r)	
			let table = document.querySelector('.table')
			let html = `  <tr>
		      <th width="5%"><input class="checkbox" type="checkbox"></th>
		      <th width="5%">이미지</th>
		      <th width="40%">제품 정보</th>
		      <th width="10%">가격</th>
		      <th width="10%">비고</th>
		    </tr>`
		    r.forEach( (p) => {
				html += `<tr>
					      <td><input class="checkbox" type="checkbox"></td>
					      <td><img src="/jspweb/product/img/${Object.values(p.imgList)[0]}" width="100%"/></td>
					      <td>${p.pname}</td>
					      <td>${p.pprice.toLocaleString()}</td>
					      <td><button type="button">X</button></td>
					    </tr>`
			}); 
			table.innerHTML = html;						
		},
		error: e => {console.log(e)}		
	})
}

