package java1.day14.Ex1_상속;

public class SmartPhone extends Phone{
	//클래스 구성 멤버 // 상속 extends[연장하다] 부모클래스명
		// 자식클래스 : SmartPhone / 부모클래스 : Phone
		// SmartPhone 클래스에서 Phone 클래스의 구성멤버 사용할 수 있다.
	// 1. 필드
	public boolean wifi;
	// 2. 생성자
	public SmartPhone( String model , String color ) {
		//this.model = model; // 오류 : 현재 클래스의 없는 필드
		// this.필드명 : 현재 클래스의 필드명 식별
		// 상속 후
		this.model = model;
		this.color = color; 
	}
	
	// 3. 메소드
	public void setWifi( boolean wifi ) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
	
}
