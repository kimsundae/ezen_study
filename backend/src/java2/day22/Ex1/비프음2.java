package java2.day22.Ex1;

import java.awt.Toolkit;

public class 비프음2 extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);}catch(Exception e){System.out.println(e);}
		}
		
		
	}
}
