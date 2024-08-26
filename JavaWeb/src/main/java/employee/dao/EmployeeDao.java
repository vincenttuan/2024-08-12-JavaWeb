package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EmployeeDao {
	private static Connection conn;
	
	static {
		String username = "root";
		String password = "12345678";
		String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
		// 建立連線
		try {
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 查詢全部員工姓名
	public List<String> findAllNames() {
		return null;
	}
	
}
