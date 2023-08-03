package java1.day16.Ex2_매개변수의다형성;

public class Ex2_실행 {
	public static void main(String[] args) {
		
		// 1.
		Driver driver = new Driver();
		
		// 1. 부모객체
		Vehicle vehicle = new Vehicle();
			driver.drive( 1 , vehicle );
			
		// 2. 자식객체
		Bus bus = new Bus();
			driver.drive( 5 , bus );
		// 2. 자식객체
		Taxi taxi = new Taxi();
		//	driver.drive( "안녕" , taxi ); // 매개변수의 타입 불일치 불가능
			driver.drive( 3 , taxi );	
	}
}
