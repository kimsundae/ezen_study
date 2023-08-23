package java2.day24_제네릭.Ex2;

public class Product< k , m > {	
		// 제네릭 : 클래스 안으로 들어오는 파라미터/변수/정해져있지않는 타입
	// 제품[Product] 클래스 안에 자동차[Car]객체 넣고 싶고 전자제품[Tv]객체 넣어주는 객체
	
	// 필드
	private k kind;
	private m model;
	// 생성자
	public k getKind() {
		return kind;
	}
	public void setKind(k kind) {
		this.kind = kind;
	}
	public m getModel() {
		return model;
	}
	public void setModel(m model) {
		this.model = model;
	}
	
	// 메소드
	
}
