package 학사관리_프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Dao() {
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		System.out.println("연동성공");
		} catch(Exception e) {e.printStackTrace();}
	}
	
	public List<Map<String, String>> studentList(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select * from student_tbl_03").executeQuery();
			while(rs.next()) {
				list.add( new HashMap<String, String>(){{
					put("sno",rs.getString(1)); put("sname", rs.getString(2));
					put("sphone",rs.getString(3)); put("sgender",rs.getString(4));
					put("sadress",rs.getString(5));
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public boolean registeScore( String...data ) {
		try {
			ps = conn.prepareStatement("insert into exam_tbl_03(sno, ekor, emath, eeng, ehist)"
			+ "values( ?, ?, ?, ?, ? )");
			ps.setString(1, data[0] );ps.setString(2, data[1] );
			ps.setString(3, data[2] );ps.setString(4, data[3] );
			ps.setString(5, data[4] );
			return ps.executeUpdate() == 1 ;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Map<String,String>> getScoreList(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement( "select * from student_tbl_03 s left join exam_tbl_03 e on s.sno = e.sno "
					+ "order by e.ekor+e.emath+e.eeng+e.ehist desc nulls last").executeQuery();
			while(rs.next()) {
				list.add(new HashMap<String,String>(){{
					put("sno", rs.getString(1));put("sname", rs.getString(2));
					put("ekor", rs.getString(7)); put("emath", rs.getString(8));
					put("eeng",rs.getString(9)); put("ehist", rs.getString(10));
					put("sum", String.valueOf(rs.getInt(7) + rs.getInt(8) + rs.getInt(9)+ rs.getInt(10)));
					put("avr", String.valueOf((rs.getInt(7) + rs.getInt(8) + rs.getInt(9)+ rs.getInt(10)) / 4));
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
}
