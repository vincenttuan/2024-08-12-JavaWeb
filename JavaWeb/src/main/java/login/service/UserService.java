package login.service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.google.protobuf.Option;

import login.dao.UserDao;
import login.dto.UserDto;
import login.entity.User;
import login.exception.LoginException;

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
	public boolean insertUser(String userName, String password, String email) {
		// 1.查詢使用者是否存在 ?
		Optional<User> optUser = dao.getUserByName(userName);
		if(optUser.isPresent()) {
			throw new RuntimeException("使用者已存在: " + userName);
		}
		// 2. 生成加鹽的密碼
		String salt = generateSalt(); // 鹽
		String passwordHash = getHashPassword(password, salt); // 加鹽的密碼
		// 3. 建立要新增的使用者 
		User user = new User();
		user.setUserName(userName);
		user.setPasswordHash(passwordHash);
		user.setSalt(salt);
		user.setEmail(email);
		// 4. 將使用者透過 dao 存到資料表中
		boolean result = dao.addUser(user);
		return result;
	}
	
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
	
	// 查詢所有使用者資料
	// 並將 entity(User) 轉 dto(UserDto)
	public List<UserDto> findAllUserDtos() {
		// 從 dao 中得到 List<User>
		List<User> users = dao.findAllUsers();
		// 建立 UserDto 集合
		List<UserDto> userDtos = new ArrayList<>();
		// 逐筆將 user 轉 userDto
		for(User user : users) {
			UserDto userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			userDto.setEmail(user.getEmail());
			userDto.setActive(user.getActive());
			// 放入到 UserDto 集合
			userDtos.add(userDto);
		}
		return userDtos;
	}
	
	// 驗證使用者
	public UserDto verifyUser(String userName, String password) throws LoginException {
		// 1.查詢是否有此人
		Optional<User> optUser = dao.getUserByName(userName);
		if(optUser.isEmpty()) {
			throw new LoginException("查無使用者: " + userName);
		}
		User user = optUser.get();
		// 2.驗證密碼
		String passwordHash = getHashPassword(password, user.getSalt());
		if(passwordHash.equals(user.getPasswordHash())) {
			UserDto userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			userDto.setEmail(user.getEmail());
			userDto.setActive(user.getActive());
			return userDto;
		}
		throw new LoginException("密碼錯誤");
	}
	
}
