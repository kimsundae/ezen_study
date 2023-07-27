package java1.day11.Ex4디자인패턴2.model.dao;
//MemberDto 
import java1.day11.Ex4디자인패턴2.model.dto.MemberDto;


public class MemberDao { // 데이터 저장 담당하는 클래스 / model -> java/db
	//MemberDto타입 배열 (데이터베이스)
	public static MemberDto[] memberList = new MemberDto[100];

}
