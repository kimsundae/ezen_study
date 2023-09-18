findByTop( 10 )
// 10개 최신순으로 출력
function findByTop( count ){
	$.ajax({
		url: "/jspweb/ProductInfoController",
		method: "get",
		data : {type:'findByTop' , count:count},
		success: r=>{console.log(r)
			
			let productBox = document.querySelector('.productBox');
			let html = ``; 
				r.forEach( (p) =>{
					// 대표이미지 출력하기 [첫번째 이미지] // Object.keys(객체명) : 해당 객체 내 모든 속성명/필드명/키를 
					console.log( p.imgList[1]);
					console.log( p.imgList);
					console.log( Object.keys(p.imgList))	
					console.log(Object.keys(p.imgList)[0])
					console.log( p.imgList[Object.keys(p.imgList)[0] ])
					console.log( Object.values(p.imgList)[0]);
					let firstImg = Object.values(p.imgList)[0];
					html += `	<div class="col">
								    <div class="card">
								      <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
								      <div class="card-body">
								        <h5 class="card-title">${p.pname}</h5>
								        <p class="card-text">
								        	<div>${p.pcontent}</div>
								        	<div>${p.pprice.toLocaleString()}원</div>
								        </p>
								      </div>
								    </div>
								  </div>`;
					
				})
				productBox.innerHTML = html;
		},
		error: e=>{console.log(e)}
	})
}
// 현재 보고 있는 범위만큼의 좌표
function findByLatLng( east , west , south , north){

	$.ajax({
		url: "/jspweb/ProductInfoController",
		method: "get",
		data : {type:'rangePrint', east: east , west : west , south : south , north: north },
		success: r=>{
			console.log(r)
		},
		error: e=>{console.log(e)}
	})
}
// 선택된 제품의 개별 출력
function findByPno( pno ){
	$.ajax({
		url: "/jspweb/ProductInfoController",
		method: "get",
		data : {type:'findByPno',pno: pno},
		success: r=>{
			console.log(r)
		},
		error: e=>{console.log(e)}
	})
}
// 모든 제품 출력
function findByAll(){
	$.ajax({
		url: "/jspweb/ProductInfoController",
		method: "get",
		data : {type:'findByAll'},
		success: r=>{
			console.log(r);
		},
		error: e=>{console.log(e)}
	})
}

/*
	자바스크립트 객체
		형태 : let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터 , 속성명 : 데이터 } 
			- 데이터 : 데이터(상수/변수) , 함수 , 배열/리스트 등등
		삽입:	객체명.새로운필드명 = 데이터
		삭제:	delete
			* 사용자정의 함수 중에 delete라는 이름으로 선언 불가능
		호출:	객체명.속성명 또는 객체명['속성명']
						
			
	자바스크립트 배열/리스트
		형태 : let 변수명 = [ 데이터, 데이터, 데이터 ] 
			배열명.push(데이터)
			배열명.splice(인덱스, 개수)
			배열명[인덱스]
*/




/*
		  <div class="col">
		    <div class="card">
		      <img src="https://image.nbkorea.com/NBRB_Product/20230821/NB20230821175524860001.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		      </div>
		    </div>
		  </div>


*/