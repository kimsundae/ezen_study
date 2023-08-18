package java2.day23.Ex3;

public class User2Thread extends Thread {
	private Calculator calculator;
	public User2Thread() {setName("User2");}
	public void setCalculator( Calculator calculator) {this.calculator = calculator;}// [setter]메소드
	
	@Override
	public void run() {
		calculator.setMemory1(50);
	}
}
