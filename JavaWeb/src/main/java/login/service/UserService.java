package login.service;

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
	// -----------------------------------------------------------
	
}
