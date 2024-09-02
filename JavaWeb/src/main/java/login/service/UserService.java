package login.service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import login.dao.UserDao;

// 使用者服務
// Controller -> Service -> Dao
// 透過此服務進行雜湊(Hash)加密加鹽邏輯處理
// 負責生成認證碼
// 將 Service 設計成一個 SingleTon 單例模式
public class UserService {
	private UserDao dao = new UserDao();
	// -- 單例配置方法 -----------------------------------------------
	private static UserService _instance = new UserService();
	private UserService() {
		
	}
	public static UserService getInstance() {
		return _instance;
	}
	// -- 服務功能 --------------------------------------------------
	// 新增使用者
	
	// 產生鹽
	private String generateSalt() {
		// 數學上安全不可預測的偽隨機(安全的亂數)
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		// 將 byte[] 透過 Base64 編碼並轉成 String
		// 方便儲存在資料表中
		return Base64.getEncoder().encodeToString(salt); 
	}
	
	// 雜湊加鹽加密
	// 放入 password 與 salt 可以得到加鹽後的雜湊碼
	private static String getHashPassword(String password, String salt) {
		try {
			// 加密演算法: SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt.getBytes()); // 先放鹽
			byte[] bytes = md.digest(password.getBytes()); // 再進行加密
			// 將 byte[] 透過 Base64 編碼並轉成 String
			// 方便儲存在資料表中
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
