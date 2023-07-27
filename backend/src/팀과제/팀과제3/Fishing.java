package 팀과제.팀과제3;

public class Fishing {

	String 낚시대;
	String 미끼;
	String 잡은물고기;
	
	String[] 민물물고기 = {"미꾸라지", "빠가사리", "쏘가리", "민물장어", "메기"};
	String[] 바다물고기 = {"고등어", "광어", "우럭", "돔", "상어"};
	
	int 내구도;
	
	// 찌 장착하기
	void input(String 낚시대, String 미끼) {
		this.낚시대 = 낚시대;
		this.미끼 = 미끼;
		
		// 낚시종류별 낚시대 내구도 설정
		setDurability();
	}

	// 낚시하기
	void fishing() {
		
		if(this.내구도 < 0) {
			return;
		}
		
		// 민물낚시할 경우 미끼 종류별 잡은 민물물고기
		if( this.낚시대.equals("민물낚시대")) {
			if(this.미끼.equals("갯지렁이")) {
				this.잡은물고기 = 민물물고기[ (int)(Math.random() * 3) ];
				System.out.println(this.잡은물고기);
				this.내구도 -= 10;
			}else if( this.미끼.equals("조갯살")) {
				this.잡은물고기 = 민물물고기[ (int)(Math.random() * 4) ];
				System.out.println(this.잡은물고기);
				this.내구도 -= 15;
			}else if(this.미끼.equals("소라")) {
				this.잡은물고기 = 민물물고기[ (int)(Math.random() * 5) ];
				System.out.println(this.잡은물고기);
				this.내구도 -= 20;
			}
			
		// 바다낚시할 경우 미끼 종류별 잡은 바다물고기
		} else if(this.낚시대.equals("바다낚시대")) {
			if( this.미끼.equals("갯지렁이") ) {
				this.잡은물고기 = 바다물고기[ (int)(Math.random() * 3) ];
				System.out.println(this.잡은물고기);
				this.내구도 -= 10;
			}else if( this.미끼.equals("조갯살") ) {
				this.잡은물고기 = 바다물고기[ (int)(Math.random() * 4) ];
				System.out.println(this.잡은물고기);
				this.내구도 -= 15;
			}else if( this.미끼.equals("소라") ) {
				this.잡은물고기 = 바다물고기[ (int)(Math.random() * 5) ];
				System.out.println(this.잡은물고기);
				this.내구도 -= 20;
			}	
		}
		if(this.내구도 < 0) {
			return;
		}
		
		
		
		
	}
	
	
	void setDurability() {
		
		if(this.낚시대.equals("민물낚시대")) {
			this.내구도 = 60;
		} else if(this.낚시대.equals("바다낚시대")) {
			this.내구도 = 100;
		}
		
		
	}
	
	
}