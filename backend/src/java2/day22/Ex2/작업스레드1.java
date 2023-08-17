package java2.day22.Ex2;

public class 작업스레드1 implements Runnable{//구현 
	@Override
	public void run() {
		Thread.currentThread().setName("쓰레드1");
		try {
			int count = 1;
			while (true) {
				System.out.println(Thread.currentThread().getName()+ " [작업1 Thread] output : " + count++);
				Thread.sleep(5000); // 1초간 일시정지 [예외처리필수 ]
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
