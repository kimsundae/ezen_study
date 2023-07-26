package java1.day10.Ex1;

public class Calculator {
	// 설계도목적
	
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메소드 : 객체의 동작 [ * 객체간의 상호작용 ]
		// 1. 리턴타입 : 메소드 실행 한 후 호출했던 곳으로 전달하는 값의 타입
		// 2. 메소드명 : 소문자시작 , 카멜표기법
		// 3. 매개변수 : 메소드 호출 할 때 전달한 매개값
		// 1. 리턴이 없는 메소드
	void powerOn() { // 1. 리턴이 없는 메소드 리턴x 매개변수x 
		System.out.println("전원을 켭니다.");
	}
		
	void powerOff() {// 2. 리턴값 없는 메소드 리턴x 매개변수x
		System.out.println("전원을 끕니다.");
	}
	
	int plus( int x , int y ) { // 3. 리턴값/매개변수 있는 메소드 리턴O 매개변수O = 2개
		// void를 제외한 리턴타입 있을 경우 return 키워드 필수
		int result = x + y; // 매개변수로 부터 전달받은 2개의 변수를 더하기
		return result; 	// 호출 했던 곳으로 더하기 한 결과를 전달		
	}
	
	double divide ( int x , int y ) {// 4. 리턴값/매개변수 있는 메소드 리턴o 매개변수o = 2개
		double result = (double)x / (double)y;
		return result;		
	}
}//class e
