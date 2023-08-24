package java2.day25_제네릭2.Ex2;

public class Applicant <T> {

	public T kind;
	
	public Applicant( T kind ) {
		this.kind = kind;
	}	
}
