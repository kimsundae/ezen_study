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
	
	
}
