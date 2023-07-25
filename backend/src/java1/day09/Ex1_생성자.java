package java1.day09;

public class Ex1_생성자 {
	public static void main(String[] args) {
		
		// 1. 객체생성 : 클래스명 객체변수명 = new 생성자명();
		Car myCar1 = new Car(); // 1개이상의 생성자의 선언 했을 때 기본생성자 자동 생성x
		Car myCar2 = new Car( "그랜저" , "검정" , 20);
	}
}
