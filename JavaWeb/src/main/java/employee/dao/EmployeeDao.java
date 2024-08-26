package employee.dao;

import java.sql.Connection;
import java.util.List;

public class EmployeeDao {
	private static Connection conn;
	
	static {
		String username = "root";
		String password = "12345678";
		String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
	}
	
	
	// 查詢全部員工姓名
	public List<String> findAllNames() {
		return null;
	}
	
}
