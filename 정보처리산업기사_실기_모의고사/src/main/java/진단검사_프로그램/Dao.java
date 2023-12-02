package 진단검사_프로그램;

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
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
		System.out.println("연동성공");
		}catch(Exception e) {e.printStackTrace();}
	}
	public List<Map<String, String>> searchPatient(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select * from tbl_patient_202004").executeQuery();
			while(rs.next()) {
				list.add( new HashMap<String,String>(){{
					put("p_no", rs.getString(1)); put("p_name", rs.getString(2));
					put("p_birth", rs.getString(3)); put("p_gender", rs.getString(4));
					put("p_tel", rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7));
					put("p_city" , rs.getString(8));
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public boolean registe( String...data ) {
		try {
			ps = conn.prepareStatement("insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result ) "
			+ "	values( ?, ?, ?, ?, ?, ? ) ");
			ps.setString(1, data[0]);ps.setString(2, data[1]);
			ps.setString(3, data[2]);ps.setString(4, data[3]);
			ps.setString(5, data[4]);ps.setString(6, data[5]);
			return ps.executeUpdate() == 1;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public List<Map<String, String>> getResultList(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select r.p_no, p.p_name, l.t_name, r.t_sdate, r.t_status, r.t_ldate, r.t_result from "
					+ "	tbl_result_202004 r inner join tbl_patient_202004 p on r.p_no = p.p_no "
					+ "	inner join tbl_lab_test_202004 l on r.t_code = l.t_code order by r.p_no asc ").executeQuery();
			while(rs.next()) {
				list.add(new HashMap<String,String>(){{
					put("p_no", rs.getString(1)); put("p_name", rs.getString(2));
					put("t_name", rs.getString(3));
					put("t_sdate", rs.getString(4)); put("t_status", rs.getString(5));
					put("t_ldate", rs.getString(6)); put("t_result", rs.getString(7));
				}});
			}
			return list;
			
		}catch(Exception e) {e.printStackTrace();}
		return null;
		
	}
	public List<Map<String,String>> getLocalSta(){
		try {
			List<Map<String,String>> list = new ArrayList<>();
			rs = conn.prepareStatement("select p.p_city, case when p.p_city = '10' then '서울'\r\n"
					+ "		when p.p_city = '20' then '경기'\r\n"
					+ "		when p.p_city = '30' then '강원'\r\n"
					+ "		else '대구' end as p_city_name,\r\n"
					+ "count(*) from tbl_patient_202004 p inner join tbl_result_202004 r on p.p_no\r\n"
					+ " = r.p_no group by p.p_city order by p.p_city asc").executeQuery();
			while(rs.next()) {
				list.add(new HashMap<String,String>(){{
					put("p_city", rs.getString(1)); put("p_city_name", rs.getString(2));
					put("count", rs.getString(3));
				}});
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
}
