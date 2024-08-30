package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Optional<User> getUser(String userName) {
		String sql = "select userId, userName, passwordHash, salt, email, active from user where userName = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userName);
			// 進行查詢
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) { // 假設有一筆資料
					User user = new User();
					user.setUserId(rs.getInt("userId"));
					user.setUserName(rs.getString("userName"));
					user.setPasswordHash(rs.getString("passwordHash"));
					user.setSalt(rs.getString("salt"));
					user.setEmail(rs.getString("email"));
					user.setActive(rs.getBoolean("active"));
					
					return Optional.of(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	// 查詢多筆使用者
	public List<User> findAllUsers() {
		String sql = "select userId, userName, passwordHash, salt, email, active from user";
		List<User> users = new ArrayList<>();
		
		
		return users;
	}
	
}
