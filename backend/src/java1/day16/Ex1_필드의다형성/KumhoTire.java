package java1.day16.Ex1_필드의다형성;

public class KumhoTire extends Tire{
	// 상속받으면 자식클래스에서 부모클래스의 멤버 사용할 수 있다.
	
	// 오버라이딩 : 부모클래스의 메소드를 물려받았지만 재정의(리모델링)
	@Override
	public void roll() {
		System.out.println("금호 Tire 회전");
	}
}
