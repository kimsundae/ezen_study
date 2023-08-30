package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex4_예제 {
	public static void main(String[] args) {
		
		// 2. TreeSet 객체 생성
		TreeSet<Fruit> treeSet = new TreeSet<>( new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1 , Fruit o2) {
				if( o1.price < o2.price ) return -1;
				else if( o1.price == o2.price) return 0;
				else return 1;
			}
		});
		
		// 3. 무작위 Fruit 객체 대입
		treeSet.add( new Fruit("포도" , 3000));
		treeSet.add( new Fruit("수박" , 10000));
		treeSet.add(new Fruit("딸기" , 6000));
		
		System.out.println("이진트리 상태 : " + treeSet);
	}
}
