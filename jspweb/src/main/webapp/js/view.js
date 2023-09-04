getBoard()
// 1. URL에 있는 매개변수(쿼리스트링) 가져오기
function getBoard(){
	// 1. URL에 있는 매개변수(쿼리 스트링) 가져오기
		// 1. 현재 주소(url)상 매개변수 가져오기
	let urlParams = new URL(location.href).searchParams
		console.log(urlParams)
	let bno = urlParams.get("bno"); // url상의 bno 데이터 가져오기
		// new URL(location.href).searchParams.get("매개변수명")
}












