/*
	공공 데이터 포털
	https://www.data.go.kr/
	
		공공 데이터 선택 -> 활용신청 -> 요청 URL 확인
*/


// 1. 안산시 착한가격업소 API 호출
api1()
function api1(){
	
	$.ajax({
		url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=10&serviceKey=Ur9HfN6c2theRbwarAqypv9rrZMM7A6s1EEGh5NcEJq7ed1qmiSLPJ%2BlZf%2Ffrna%2BqM2C7Z7K49VnJ%2FQ5uXl2HA%3D%3D",
		data : {},
		method : "get",
		success : r => {
			console.log(r)
			
			let data = r.data; console.log(data);
			console.log( data[0])
			console.log( data[0].업소명)
			// 1. 출력할 dom객체
			let apiTable1 = document.querySelector('.apitable1');
			
			// 2. HTML 구성
			let html = ``; 
						
				// 2-2
				// 배열명.forEach( ( 반복변수명 ) => { 반복코드 } )
				// 배열명.forEach( ( 반복변수명 ,인덱스 ) => { 반복코드} )
			data.forEach(( d , i ) =>{
				html += 
						`						
							<tr>
								<td> ${ i+1 } </td>
								<td> ${ d.업소명 } </td>
								<td> ${ d.소재지도로명주소 } </td>
								<td> ${ d.연락처 } </td>					
								<td> ${ d.품목1 } / ${ d.가격1 } </td>
								<td> ${ d.품목2 } / ${ d.가격2 } </td>
								<td> ${ d.품목3 } / ${ d.가격3 } </td>
							</tr>					
						
						`
			});
			
			// 3. 출력할 위치에 HTML 대입
			apiTable1.innerHTML = html;
			
		},
		error : e => {}		
	})
}

 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });
    // 마커 이미지의 주소
var markerImageUrl = '/jspweb/img/번개.png', 
    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		  markerImageOptions = { 
		      offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		  };
// 마커 이미지를 생성한다
var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });
 	
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=10&serviceKey=Ur9HfN6c2theRbwarAqypv9rrZMM7A6s1EEGh5NcEJq7ed1qmiSLPJ%2BlZf%2Ffrna%2BqM2C7Z7K49VnJ%2FQ5uXl2HA%3D%3D", 
    	function(response) {	
			console.log(response)
	        // response : 공공데이터 응답 객체
	        // response : 
	        var markers = $(response.data).map(function(i, position) {
				
				// 개별 마커 생성 후
				let marker = new kakao.maps.Marker({ 
					position : new kakao.maps.LatLng(position['위도(WGS84)'], position['경도(WGS84)']),
					image : markerImage ,//마커의 이미지
					
				 })
				
	            
	            
	             // 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
				kakao.maps.event.addListener(marker, 'click', function() {
				    let html = ``
				    	
				    		html	+=	`<div> 충전소명 : ${position.충전소명}</div>`
				    		html	+=	`<div> 충전소명 : ${position.충전기타입명}</div>`
				    		html	+=	`<div> 충전소명 : ${position.운영기관명}</div>`
				    		html	+=	`<div> 충전소명 : ${position.소재지도로명주소}</div>`
				    			
				    		document.querySelector('.detailbox').innerHTML = html;
				});
				
				return marker;
        	});

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });
    
   
/*
// 1. 접속한 브라우저의 GPS 좌표 얻기 [ geolocation ]
navigator.geolocation.getCurrentPosition( pos => {
	console.log( pos );
	let lat = pos.coords.latitude;console.log(lat)
	let lng = pos.coords.longitude;
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션

		center: new kakao.maps.LatLng( lat, lng), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(lat, lng); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	
});
// 카카오지도 출력

*/



// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    



/*
	1. 인덱스 0부터 배열의 길이만큼 반복
	for문
	2. 배열의 첫번째 인덱스부터 마지막인덱스 까지 반복
		for( let 인덱스변수 in arrayList ){}
		
	3. 배열의 첫번째 데이터부터 마지막 데이터까지 반복
		for( let 반복변수 of ArrayList){}
	4. 배열의 반복변수of 인덱스를 첫번째부터 마지막 반복 [반환 return 값x]
		arrayList.forEach((반복변수)=>{})
		arrayList.forEach((반복변수,인덱스변수)=>{})
	
	5. 배열의 반복변수or인덱스를 첫번째부터 마지막 반복 [반환값return o ] => 새로운 배열에 저장할 수 있다.
		arrayList.map((반복변수)=>{})	
		arrayList.map((반복변수,인덱스변수)=>{})
		arrayList.map((반복변수,인덱스변수,배열)=>{})
		
		let returnArrays = arrayList.map((반복변수,인덱스변수)=>{return})
	6. filter
	
	
	
*/