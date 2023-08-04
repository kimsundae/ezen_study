package 과제.과제11.model.dto;

public class MemberDto {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private String phone;
		
	//2. 생성자
		// 1. 기본생성자
	public MemberDto() {}
	public MemberDto( String id, String pw) {
		super();		
		this.id = id;
		this.pw = pw;
	
	}
	public MemberDto( String id, String pw, String name, String phone) {
		super();		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}
		// 2. 풀생성자
	public MemberDto(int mno, String id, String pw, String name, String phone) {
		super();
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
