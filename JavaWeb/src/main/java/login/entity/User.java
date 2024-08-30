package login.entity;

// user 資料表紀錄
public class User {
	private Integer userId;
	private String userName;
	private String passwordHash;
	private String salt;
	private String email;
	private Boolean active;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passwordHash=" + passwordHash + ", salt=" + salt
				+ ", email=" + email + ", active=" + active + "]";
	}
	
	
}
