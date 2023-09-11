package model.dto;

public class MsgDto {
	
	private String mid; // 보낸사람
	private String msg; // 보낸내용
	
	public MsgDto() {
		// TODO Auto-generated constructor stub
	}

	public MsgDto(String mid, String msg) {
		super();
		this.mid = mid;
		this.msg = msg;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgDto [mid=" + mid + ", msg=" + msg + "]";
	}
	
	
}
