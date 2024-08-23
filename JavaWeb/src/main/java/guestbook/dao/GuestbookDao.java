package guestbook.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import guestbook.entity.Guestbook;

public class GuestbookDao {
	// Guestbook 儲存資料集合
	private static CopyOnWriteArrayList<Guestbook> guestbooks;
	
	// 新增 Guestbook
	public void addGuestbook(Guestbook guestbook) {
		guestbooks.add(guestbook); // 將留言紀錄加入到集合
	}
	
	// 查詢全部 Guestbook
	public List<Guestbook> findAllGuestbooks() {
		return guestbooks;
	}
}
