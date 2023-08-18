package java2.day23.Ex1;

public class SumThread extends Thread {

	// 필드
	private long sum;
	// 생성자
	// 메소드
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	// !!
	@Override
		public void run() {// 1부터 100이하까지 1씩증가 누적합계
			for( int i = 1; i <= 100; i++) {sum += i;}
		}
}
/*
 *	멀티스레드
 *		1. Thread 클래스로부터 extends
 *		2. * Runnable 인터페이스로부터 implements
 *			* run메소드 재정의
 *		- 상태
 *			1. new 이용한 스레드 객체 생성[ 스레드 생성 ]
 *			2. start() 메소드 이용한 run() 작업코드 실행
 *				- start() 한다고해서 바로 실행X
 *			
 *				실행대기(Runnable) : 운영체제가 하드웨어[CPU]를 사용할 수 있는 권한 줄 때까지 = cpu스케줄링			
 *			
 *					반복
 *
 *				실행(Running) : -- 해당 스레드 순서가 CPU사용할 수 있는 권한[ 명령어 전달 실행 ]
 *			
 *				일시정지 : 스레드가 실행대기가 아닌 잠시 정지된 상태.
 *
 *				종료(Terminated) : 스레드 종료				
 *
 *		- 병렬(여러단위 흐름=) 처림 vs 작렬(하나단위 흐름=1차선도로=) 처리
 *			- 단일(직렬) 스레드 : main 함수만 있는 경우			
 *			- 멀티(병렬) 스레드 : main에서 thread 추가 하는 경우
 *
 *			- 컴퓨터의 병렬 처리 방법
 *				- 소프트웨어(손x,논리)[자바]는 직접적인 하드웨어[cpu,메모리] 조작x
 *			
 *
 *			
 *
 */
	