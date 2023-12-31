package java2.day23.Ex3;

public class Calculator { // 계산기
	//필드
	private int memory;
	//생성자
	//메소드
	public int getMemory() {return memory; }
	
	public synchronized void setMemory1(int memory) {
		this.memory = memory; // 1. 매개변수를 들어온 값을 필드에 저장 [ setter ]
		
		try {Thread.sleep(2000);}catch(Exception e) {}	// 2. 현재 스레드를 2초간 일시정지
		// 3. 2초 후 메모리 필드 확인
		System.out.println( Thread.currentThread().getName() + "요청한 2초 후 저장된 메모리 : " + this.memory);
	}
	
	// 2. 메소드내 특정 블록에서만 동기화 하는 방법 : synchronized(this){}
	public void setMemory2( int memory ) {
		System.out.println(Thread.currentThread().getName()+ "비동기화 구역");
		synchronized ( this) {// 객체 잠금
			System.out.println(Thread.currentThread().getName()+ "동기화 구역");
			this.memory = memory; 
			try {Thread.sleep(2000);} catch(Exception e) {}
			System.out.println(Thread.currentThread().getName() + "요청한 2초 후 저장된 메모리 : " + this.memory);	
		}
	}
}
