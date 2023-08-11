package 과제.과제11.model.dto;

public class MsgDto {
	private int msgnum;  
    private int smno;
    private int rmno;
    private String mcontent;
    private String sname;
    private String rname; 
    private String mdate;
    public MsgDto() {
		// TODO Auto-generated constructor stub
	}
    
	public MsgDto(String sname, String scontent, String mdate) {
		super();
		this.mcontent = scontent;
		this.sname = sname;
		this.mdate = mdate;
	}

	public MsgDto(int msgnum, int smno, int rmno, String mcontent, String mdate) {
		super();
		this.msgnum = msgnum;
		this.smno = smno;
		this.rmno = rmno;
		this.mcontent = mcontent;
		this.mdate = mdate;
	}

	public int getMsgnum() {
		return msgnum;
	}

	public void setMsgnum(int msgnum) {
		this.msgnum = msgnum;
	}

	public int getSmno() {
		return smno;
	}

	public void setSmno(int smno) {
		this.smno = smno;
	}

	public int getRmno() {
		return rmno;
	}

	public void setRmno(int rmno) {
		this.rmno = rmno;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	
}
