package java1.day16.Ex1_필드의다형성;

public class HankookTire extends Tire {
	// 상속 : 자식클래스 extends 부모클래스 부모클래스

	//오버라이딩 : 부모클래스의 메소드를 물려받았지만 재정의(리모델링)
	@Override
	public void roll() {
		System.out.println("한국 Tire 회전");
	}
}
