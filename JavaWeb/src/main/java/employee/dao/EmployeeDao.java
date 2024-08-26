package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	private static Connection conn;
	
	static {
		String username = "root";
		String password = "12345678";
		String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
		// 建立連線
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 查詢全部員工姓名
	public List<String> findAllNames() {
		String sql = "select name from employee_name";
		try(Statement stmt = conn.createStatement();  // 建立 sql 敘述物件
			ResultSet rs = stmt.executeQuery(sql);) {
			// 準備一個 List<String> 用來存放 name
			List<String> employeeNames = new ArrayList<>();
			// 輪詢資料表中每一筆紀錄, 並加入到集合中
			while (rs.next()) {
				String name = rs.getString("name");
				employeeNames.add(name);
			}
			return employeeNames;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
}
