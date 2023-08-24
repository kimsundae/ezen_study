package java2.day25_제네릭2.Ex2;

public class Ex2_와일드카드제네릭타입 {
	public static void main(String[] args) {
		 
		// 1. 모든 사람이 신청 가능
			// 1. 사람 객체
		Person person = new Person();
			// 2.
		Applicant<Person> applicant = new Applicant<>(person);
		Course.registerCourse1(applicant);
		
		Course.registerCourse1(new Applicant<>(new Worker()));
		Course.registerCourse1(new Applicant<>(new Student()));
		Course.registerCourse1(new Applicant<>(new HighStudent()));
		Course.registerCourse1(new Applicant<>(new MiddleStudent()));
		System.out.println();
		
		// 학생만 신청 가능		
		Course.registerCourse2(new Applicant<>(new Student()));
		Course.registerCourse2(new Applicant<>(new HighStudent()));
		Course.registerCourse2(new Applicant<>(new MiddleStudent()));
		System.out.println();
		
		// 직장인 및 일반인만 신청 가능
		Course.registerCourse3(new Applicant<>(new Person()));
		Course.registerCourse3(new Applicant<>(new Worker()));
		System.out.println();
		
	}
}
