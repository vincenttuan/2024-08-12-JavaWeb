package login.dto;

public class UserDto {
	private Integer userId;
	private String userName;
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
		return "UserDto [userId=" + userId + ", userName=" + userName + ", email=" + email + ", active=" + active + "]";
	}
	
	
}
