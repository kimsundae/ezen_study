package java2.day24_제네릭.Ex4_제네릭메소드;

public class Ex4_제네릭 {
	// 제네릭메소드 선언
	public static <T> Box<T> boxing(T t){
				// 매개변수에서 제네릭타입 사용하기 위한 <T> 선언부에 정의하면 사용가능
				// T t = 100 // object
		Box<T> box = new Box<>();
		box.setT(t);
		return box;
	}
	// main 메소드
	public static void main(String[] args) {
		
		// 1. Box객체 t필드를 Integer 타입으로 선정
		Box<Integer> box1 = boxing(100);
			// box1 [ Integer t ]
		int intvalue = box1.getT();
		System.out.println( intvalue );
		
		// 2. 
		Box<String> box2 = boxing("홍길동");
		String StringValue = box2.getT();
		System.out.println(StringValue);
	}
}
