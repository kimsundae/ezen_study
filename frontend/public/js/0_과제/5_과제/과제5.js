
// 누구를~~ : userbox 를
// 1. 조작/제어할 HTML 태그 dom객체 호출
	// 1. 입력 2. 출력 3. 이동
let userbox = document.querySelector('.userbox');

// 유저위치 = x 좌표
let u_left = 50;


// 어떻게 : 페이지 전체(body)에서 키보드를 누를 때 = keydown
	// dom객체명.addEventListener('이벤트명' , () => { })
document.body.addEventListener('keydown' , ( e )=>{
	console.log('키 눌림')
	// 1. 눌린 키 상태 확인 .keyCode
	console.log( e ); // keydown 이벤트 상태 객체
	//2. 만약에 왼쪽/오른쪽 키를 눌렀을 때 css left 변경
	if( e.keyCode == 37){
		console.log("왼쪽으로 이동"); // css left 차감
		u_left -= 10; //10 차감
		// * 유효성검사 [ 배경 밖을 못나가게 ]
		if(u_left < 0){ u_left = 0 }; // 만약에 위치가 0보다 작아지면 0으로 고정
	}else if( e.keyCode == 39 ){
		console.log("오른쪽으로 이동"); // css left 증가
		u_left += 10; //10 증가
		if(u_left > 930 ){u_left = 930 }; // 만약에 위치가 930보다 커지면 930으로 고정
		
		userbox.style.backgroundImage = `url(img/공격모션2.png)`;
		
	}else if(e.keyCode == 65 ){ //만약에 a키를 눌렀을 때 
		console.log(' 공격 ');
		userbox.style.backgroundImage = `url(img/공격모션1.png)`; // 공격 이미지 출력
	}
	
	// 3. 현재 위치값을 대입 
	userbox.style.left = `${ u_left }px`
	console.log( userbox.style.left );	
})

// 2. 키 누르고 떼었을 때. = keyup
document.body.addEventListener('keyup' , (e)=>{ 
	// 원래 기본 이미지 변경
	userbox.style.backgroundImage = `url(img/문어.png)`;
	
})








