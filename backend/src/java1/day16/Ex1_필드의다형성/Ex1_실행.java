package java1.day16.Ex1_필드의다형성;

public class Ex1_실행 {
	public static void main(String[] args) {
		// 1. Car 객체 생성
		Car myCar = new Car(); // tire필드에 객체가 없는 상태
		System.out.println( myCar.tire); // 필드에 초기화가 없으면 기본값[ 참조타입 = null ]
		// 2. Car 객체의 타이어 장착 = Car객체의 타이어 필드에 초기화
		myCar.tire = new Tire(); // 기본 타이어 객체를 장착
		System.out.println( myCar.tire );
		
		// 3. 타이어(객체) 장착된 Car 객체가 전진
		myCar.run(); // 기본타이어 객체가 roll 메소드 실행
		
		// 4. 타이어(객체) 교체 하기 위해 카센터에서 한국타이어 교체
		myCar.tire = new HankookTire();
		System.out.println( myCar.tire );
		
		// 5. 타이어(객체) 교체장착된 Car 객체가 전진
		myCar.run(); // 한국타이어 객체가 roll 메소드 실행
		
		// 6. 타이어(객체)교체 하기 위해 카센터에서 금호타이어 교체
		myCar.tire = new KumhoTire(); // 금호타이어 객체를 대입 // 원래 기존에 있던 한국Tire
		System.out.println( myCar.tire );
		
		// 7. 타이어(객체) 교체장착된 Car 객체가 전진
		myCar.run();
	}
}
