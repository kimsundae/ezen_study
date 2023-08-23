package accountbook.model.dao;

import java.util.ArrayList;

import accountbook.model.dto.AccountbookDto;
import model.dao.Dao;

public class AccountbookDao extends Dao{
	private static AccountbookDao accountbookDao = new AccountbookDao();
	private AccountbookDao() {}
	public static AccountbookDao getInstance() {return accountbookDao;}
	
	public boolean post( AccountbookDto dto ) {
		try {
			String sql = "insert into accountbook(acontent , aprice , adate) values( ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getAcontent());ps.setString(2, dto.getAprice());
			ps.setString(3, dto.getAdate());
			int row = ps.executeUpdate();
			if(row == 1)return true;
		}catch(Exception e){System.out.println(e);}
		
		return false;
	}
	public ArrayList<AccountbookDto> read(){
		ArrayList<AccountbookDto> arr = new ArrayList<>();
		try {
			String sql = "select * from accountbook";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AccountbookDto dto = new AccountbookDto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
				arr.add(dto);
			}
			return arr;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	public boolean update( AccountbookDto dto ) {
		try {
			String sql = "update accountbook set acontent = ? , aprice = ? where ano = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getAcontent());ps.setString(2, dto.getAprice());
		ps.setInt(3, dto.getAno());
		int row = ps.executeUpdate();
		if(row == 1)return true;
		}catch(Exception e) {System.out.println(e);}
		
		return false;	
	}
	public boolean delete( int ano ) {
		try {
			String sql ="delete from accountbook where ano = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ano);
			int row = ps.executeUpdate();
			if(row == 1)return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	
}
