package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import login.entity.User;

// 與資料表 user 進行溝通
public class UserDao {
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
	
	// 新增使用者
	public boolean addUser(User user) {
		String sql = "insert into user(userName, passwordHash, salt, email) values(?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// 將參數內容注入到 sql 語句中
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPasswordHash());
			pstmt.setString(3, user.getSalt());
			pstmt.setString(4, user.getEmail());
			// 進行資料表更新程序(更新前與更新後的異動)
			int rowcount = pstmt.executeUpdate(); // rowcount 資料表異動筆數
			return rowcount > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 查詢使用者
	
	
}
