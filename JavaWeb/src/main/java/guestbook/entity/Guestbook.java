package guestbook.entity;

import java.util.Date;

// 留言紀錄格式
public class Guestbook {
	private Integer userId; // 使用者 id
	private String message; // 使用者留言內容
	private Date time;      // 使用者發佈時間
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Guestbook [userId=" + userId + ", message=" + message + ", time=" + time + "]";
	}
	
	
}
