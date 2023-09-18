// 10개 최신순으로 출력
function findByTop( count ){
	$.ajax({
		url: "/jspweb/ProductInfoController",
		method: "get",
		data : {type:'findByTop' , count:count},
		success: r=>{
			console.log(r)
		},
		error: e=>{}
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
		error: e=>{}
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
		error: e=>{}
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
		error: e=>{}
	})
}