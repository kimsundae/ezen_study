package java2.day22.Ex2;

public class Ex2_멀티스레드예 {
	public static void main(String[] args) {
		
		// -- 스레드 현황 : [main] -싱글스레드
		// 0. main스레드가 작업스레드 객체 생성
		작업스레드1 작업스레드1 = new 작업스레드1(); // 구현객체 생성
		Thread thread = new Thread(작업스레드1); // 구현객체를 Thread객체에게 전달
		// 1. main스레드가 1초마다 출력
		thread.start();
		
		// 2. main스레드가 작업스레드2 객체 생성
		작업스레드2 작업스레드2 = new 작업스레드2();
		작업스레드2.start();
		
		try {
			int count = 1;
			while(true) {
				System.out.println(Thread.currentThread().getName() +  "[main Thread] output : " + count++);
				Thread.sleep(1000); // 1초간 일시정지 [예외처리필수 ]
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
