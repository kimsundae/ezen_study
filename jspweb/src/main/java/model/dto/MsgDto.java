package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.MemberDao;

public class MsgDto {

	private String frommid; // 보낸사람
	private String msg; // 보낸내용
	private String frommimg; // 보낸사람의 프로필
	private String date; // 보낸시간

	public MsgDto() {
		// TODO Auto-generated constructor stub
	}

	public MsgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		// 객체 생성 시 추가코드
			// 1. 보낸사람의 프로필 가져오기
			this.frommimg = MemberDao.getInstance().info(frommid).getMimg(); 
			// 2. 보낸일시 구하기
				// 1. new Date() : 현재시간/날짜 제공하는 클래스
			Date date = new Date();
				// 2. SimpleDateFormat : 날짜 포멧(형식)
			SimpleDateFormat sdf = new SimpleDateFormat(" aa hh:mm");
				// y연도 M월 d일 h시m분s초 aa오전오후
			this.date = sdf.format(date); //현재 시간을 정의한 형식으로 변환
			
	}

	public MsgDto(String frommid, String msg, String frommimg, String date) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		this.frommimg = frommimg;
		this.date = date;
	}

	public String getfrommid() {
		return frommid;
	}

	public void setfrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + "]";
	}

}
