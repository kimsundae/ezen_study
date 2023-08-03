package 복습.part6;

public class Member {

	//Member 클래스 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이 5개 입니다.
	String id;
	String pw;
	String name;
	String phone;
	int age;
	public Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}	
}
