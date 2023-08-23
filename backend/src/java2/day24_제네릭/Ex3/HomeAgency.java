package java2.day24_제네릭.Ex3;

public class HomeAgency	implements Rentable<Home>{
	@Override
	public Home rent() {
	
		return new Home();
	}
}
