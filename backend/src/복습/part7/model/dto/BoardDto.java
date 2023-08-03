package 복습.part7.model.dto;

public class BoardDto {
	 // - 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이  저장하는 5개 를 선언합니다.
	String id;
	String pw;
	String name;
	String phone;
	int age;	
    //  - 생성자는 1.기본생성자 2.모든매개변수를 받은 생성자를 2개 선언 합니다. 
	public BoardDto() {}
	public BoardDto(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}  
	// - getter 와 setter , toString() 선언합니다. 
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
  
	
	
}
