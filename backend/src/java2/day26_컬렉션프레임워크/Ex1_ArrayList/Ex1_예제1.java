package java2.day26_컬렉션프레임워크.Ex1_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Ex1_예제1 {

	public static void main(String[] args) {
		
		// 1. ArrayList 컬렉션 객체 생성
		List<Board> list = new ArrayList<>();
		
		// 객체 추가
		list.add( new Board("제목1" , "내용1" , "글쓴이1"));
		list.add( new Board("제목2" , "내용2" , "글쓴이2"));
		list.add( new Board("제목3" , "내용3" , "글쓴이3"));
		list.add( new Board("제목4" , "내용4" , "글쓴이4"));
		list.add( new Board("제목5" , "내용5" , "글쓴이5"));
		list.add( 0 , new Board("제목6", "내용6" , "글쓴이6"));
		list.set(1, new Board("제목7" , "내용7" , "글쓴이7"));
		
		Board board = new Board( "제목8" , "내용8" , "글쓴이8"); list.add(board);//보드 객체 생성 후 리스트객체에 추가O
		Board board2 = new Board( "제목9" , "내용9" , "글쓴이9");		// 보드 객체 생성 후 리스트객체에 추가X
		
		System.out.println("------------ 2 : " + list);
		// 3. ArrayList 객체 안에 객체의 총 개수
			// 리스트객체명.size()		: 리스트내 저장된 객체 수
			// 리스트객체명.get( 인덱스 ) : 리스트내 해당 인덱스 위치에 객체 반환
			// 리스트객체명.contains( 객체 ) : 리스트내 해당 객체가 있으면 true / 없으면 false
		System.out.println("--------------- 3 : size()" + list.size() + " 개");	// 배열명.length			
		System.out.println("--------------- 4 : get()" + list.get( 2 ) );	// 배열명[ 인덱스 ]
		System.out.println("--------------- 4 : contains()" + list.contains(board));
		System.out.println("--------------- 4 : contains()" + list.contains(board2));
		System.out.println("--------------- 4 : isEmpty()" + list.isEmpty());
		
		// 4. ArrayList 객체 안에 특정 객체 삭제
			// 리스트객체명.remove( 인덱스 )	: 리스트 내 해당 인덱스 위치에 객체 삭제 / 1칸씩 당겨짐
			// 리스트객체명.remove( 객체 )	: 리스트 내 해당 객체가 존재하면 삭제 
		list.remove(2); // 리스트 객체 내 2번인덱스 객체 삭제
		list.remove( board ); // 리스트 객체 내 해당 객체가 존재하면 삭제
		System.out.println("--------- 4 remove() : " + list);
		list.clear();
		System.out.println("--------- 4 clear() : " + list);
	}

}
