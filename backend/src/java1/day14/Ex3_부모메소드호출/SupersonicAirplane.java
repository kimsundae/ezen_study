package java1.day14.Ex3_부모메소드호출;

public class SupersonicAirplane extends Airplane {
	// 자식클래스명 extends 부모클래스명
	// ! : 자식클래스에서 부모클래스의 구성멤버를 사용할 수 있다.
	// !! : 단) 부모클래스는 자식클래스의 구성멤버를 사용할 수 없다.
	
	// 1. 필드
	// public static final : 상수 필드
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	//인스턴스 필드
	public int flyMode = NORMAL;
	
	// 2. 생성자	
	public SupersonicAirplane() {
		
	}
	// 3. 메소드
		// 부모클래스로부터 오버라이딩 => 컨트롤+스페이스바
	@Override // 생략가능
	public void fly() {
		if( flyMode == SUPERSONIC ) {
			System.out.println("초음속 비행합니다.");
		}else {
			super.fly(); // 부모 메소드 호출
		}		
	}
}
