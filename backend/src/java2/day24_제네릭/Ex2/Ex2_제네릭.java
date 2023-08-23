package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
		// 1. Product 객체 만드는데.. tv 객체를 가지고
			// 1. product객체 만들 때. 필드에 사용할 타입 구체적으로 대입
		Product< Tv , String > product1 = new Product<>();
			// 2. Product 객체 	
		product1.setKind( new Tv() );
		product1.setModel( "스마트Tv" );
			// 3. product객체
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		Product< Car , String > product2 = new Product<>();
		product2.setKind(new Car() );
		product2.setModel("SUV자동차");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
	
	
	}
	
	
	
	
	
}
