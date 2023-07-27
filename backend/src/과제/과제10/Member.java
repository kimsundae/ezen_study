package 과제.과제10;

public class Member {
	String id;
	String password;
	String name;
	String phoneNumber;
	int age;
	
	public Member(String id, String password, String name, String phoneNumber, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
}

/*
	
	JVM : 자바 가상(논리적으로 만들어낸) 메모리
		Member.java-----클래스로더---> Member.class -----> 메소드영역				스택영역
		자바 코드파일					바이트코드파일			클래스 코드,메소드 코드,		{}
														정적(static)멤버														
	- 키워드
		this		: 인스턴스멤버 : new 힙 생성시 할당 되고 힙 초기화될 때 [ GC ] [ 공용X, 각각]
						- static 키워드 없으면
						- 객체를 통해 사용
		static		: 정적멤버 : 프로그램 시작 할당 되고 프로그램이 종료될 때 [ 전역 / 공통 / 공용 / 공유 ]
						- static 키워드 있으면
						- 클래스 통해 사용
		final		: 수정불가 : 초기화할 때 대입만 가능하고 수정 불가능
		static final	: 상수 : 프로그램내에서 1개만저장(static) 수정불가능          





*/