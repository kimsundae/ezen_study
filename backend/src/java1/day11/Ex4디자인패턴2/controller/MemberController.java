package java1.day11.Ex4디자인패턴2.controller;

import java1.day11.Ex4디자인패턴2.model.dao.MemberDao;
import java1.day11.Ex4디자인패턴2.model.dto.MemberDto;


public class MemberController { // 기능처리(로직) 담당하는 클래스 // controller -> java
	
	// 1. 싱글톤 생성 [ private static ]
	private static MemberController memberController = new MemberController();
	// 2. 외부로부터 싱글톤 호출할 수 있도록 get~~
	public static MemberController getInstance() {return memberController;}
	// 3. 외부에서 객체 생성 차단 위한 생성자 잠금
	private MemberController() {}
	
	public boolean singupLogic(String id , String pw , String name , String phone , int age) {
		MemberDto memberDto = new MemberDto(id, pw , name , phone , age);  
		for( int i = 0; i < MemberDao.memberList.length; i ++) {
			if(MemberDao.memberList[i] == null ) {
				MemberDao.memberList[i] = memberDto; return true; // 회원가입 성공		
			}
		}
		return false; // 회원가입 실패
	}
	public boolean loginPage(String id , String password) 
	{		
		for( int i = 0; i < MemberDao.memberList.length; i++) 
		{
			if(MemberDao.memberList[i] != null)
			{
				if( (MemberDao.memberList[i].getId()).equals(id) && 
						(MemberDao.memberList[i].getPw()).equals(password))
				{					
					return true;
				}
			}
		}
		return false;
	}
	public String findIdPage( String name , String phoneNumber) 
	{
		for( int i = 0; i < MemberDao.memberList.length; i++) 
		{
			if(MemberDao.memberList[i] != null) 
			{
				if( (MemberDao.memberList[i].getName()).equals(name) && MemberDao.memberList[i].getPhone().equals(phoneNumber))
				{					
					return MemberDao.memberList[i].getId();
				}		
			}				
		}
		return "notExist";
	}
	public String findPwPage( String id , String phoneNumber) 
	{		
		for( int i = 0; i < MemberDao.memberList.length; i++) 
		{
			if(MemberDao.memberList[i] != null) 
			{
				if( (MemberDao.memberList[i].getId()).equals(id) && MemberDao.memberList[i].getPhone().equals(phoneNumber))
				{	
					// 임시 비밀번호
					String insPassword = "";
					
					for(int j = 0; j < 4; j++) 				
						insPassword += (char)((int)(Math.random() * 26) + 65);
										
					return insPassword;
				}		
			}			
		}// for e
		return "notExist";
	}
}
