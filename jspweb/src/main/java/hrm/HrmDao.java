package hrm;

import java.util.ArrayList;

import model.dao.Dao;

public class HrmDao extends Dao{
	private static HrmDao hrmDao = new HrmDao();
	private HrmDao() {}
	public static HrmDao getInsatance() {return hrmDao;}
	
	// 직원등록메소드
	public boolean regist( HrmDto dto ) {
		try {		
			String sql = "insert hrm( hname , hphone , hrank , himg ) values ( ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getHname());
			ps.setString(2, dto.getHphone()); 
			ps.setString(3, dto.getHrank());
			ps.setString(4, dto.getHimg());
			int row = ps.executeUpdate();
			if(row == 1)
				return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	// 전화번호 중복 찾기 메소드
	public boolean isPhoneUse( String phoneNumber ) {
		try {
			String sql = "select hphone from hrm where hphone = " + phoneNumber;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() )
				return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	// 직원 전체 출력 메소드
	public ArrayList<HrmDto> read(){
		ArrayList<HrmDto> dtoArr = new ArrayList<>();
		try {
			String sql = "select * from hrm";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HrmDto dto = new HrmDto( rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6));
				dtoArr.add(dto); System.out.println("dto" + dto);
			}
			
			return dtoArr;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
}
