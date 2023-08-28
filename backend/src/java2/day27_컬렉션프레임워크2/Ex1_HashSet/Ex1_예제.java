package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1_예제 {

	public static void main(String[] args) {
		
		// 1. Set 컬렉션의 HashSet 객체 선언
		Set<String> set = new HashSet<>();
			// set객체에(컬렉션프레임워크) <String> 객체를 여러 개 저장 가능
		
		System.out.println("set 상태 : " + set );
		// 2. set 객체에 String객체 저장
		set.add("Java");	System.out.println("set 상태 : " + set);
		set.add("JDBC");	System.out.println("set 상태 : " + set);
		set.add("JSP");		System.out.println("set 상태 : " + set);
		set.add("Java");// 중복 발생
		System.out.println("set 상태 : " + set);
		set.add("Spring");	System.out.println("set 상태 : " + set);
		System.out.println("총 객체 수 : " + set.size());
		// 4. set/list 와 for문 관계 [ * 배열/컬렉션 내 저장된 데이터들을 순회 하려고 ]
			// 1. for문 [ list 인덱스 사용해서 가능하지만, set 불가능... ]
			for( int i = 0; i < set.size(); i++) {}
			// 2. 향상된 for문
				// for( 반복변수 : 컬렉션객체 ) {}
				// 1. 반복변수란 : 컬렉션객체에 저장된 타입
			for( String s : set ) { System.out.println( s ); } 
			// 3. forEach()함수를 이용한 람다식 표현(화살표함수 = [ java -> / js => ] )
			set.forEach( s -> {System.out.println( s );});
			
		// ------------------------------------------------- //
			// 객체 내 중복여부 체크
				// 객체가 String 이면 String 기준으로 중복 제거
				// 객체[ String , int ]가 2개 이상의 필드를 가지고 있으면 중복기준
			
		// 1. set 객체 선언
		Set<Member> set2 = new HashSet<>();
			
		// 2. set객체에 member 객체 저장
		set2.add( new Member("홍길동" , 30));
		set2.add(new Member("홍길동" , 30));
		set2.add(new Member("강호동" , 30));
		set2.add(new Member("홍길동" , 40));
		set2.add(new Member("신동엽" , 50));
		
		// 3. set 객체내 member 객체 수
		System.out.println("set 객체 내 member 객체 수 : " + set2);
		
		// 4. iterator() 메소드 제공
		Iterator<Member> iterator = set2.iterator();
		
		while( iterator.hasNext() ) {
			Member element = iterator.next();
			System.out.println( element );
			if( element.name.equals("강호동")) {
				iterator.remove(); // .remove() : set객체 내 해당 객체 삭제
			}
		}
		
		System.out.println("set객체 내 member 객체 수 : " + set2);
		
		// 4. 향상된 for문( iterator 를 사용하는 배열/컬렉션프레임워크의 객체이면 사용 가능)
		for( Member m : set2 ) {System.out.println( m );}
		
		// 4. forEach( iterator를 사용하는 컬렉션프레임워크의 객체이면 사용 가능
		set2.forEach( m -> {System.out.println( m );});
	}
}
