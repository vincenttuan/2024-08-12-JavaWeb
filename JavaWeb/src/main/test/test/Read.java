package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import login.entity.User;

public class Read {
	public static void main(String[] args) throws Exception {
		Connection conn;
		String username = "root";
		String password = "12345678";
		String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, username, password);
		String sql = "select userId, userName, passwordHash, salt, email, active from user";

		List<User> users = new ArrayList<>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) { // 逐筆尋訪
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPasswordHash(rs.getString("passwordHash"));
				user.setSalt(rs.getString("salt"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("active"));

				users.add(user); // 放入到集合中
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(users);
	}
}
