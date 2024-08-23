package guestbook.controller;

import java.io.IOException;
import java.util.Date;

import guestbook.dao.GuestbookDao;
import guestbook.entity.Guestbook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/add")
public class AddGuestbookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Guestbook Add");
		// 1.取得表單資訊
		// req.getParameter("userId") 會取得 HTML 表單中 name="userId" 所輸入的內容
		// req.getParameter("message") 會取得 HTML 表單中 name="message" 所輸入的內容
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		String message = req.getParameter("message");
		
		// 2.建立 Guestbook 物件資料
		// 目的: 將表單中所得到的資料注入到 Guestbook 物件中 
		Guestbook guestbook = new Guestbook();
		guestbook.setUserId(userId);
		guestbook.setMessage(message);
		guestbook.setTime(new Date());
		
		// 3.儲存留言記錄到集合中
		GuestbookDao dao = new GuestbookDao();
		dao.addGuestbook(guestbook);
		
		// 4.取得目前留言記錄筆數
		int count = dao.findAllGuestbooks().size();
		resp.getWriter().print("\nGuestbooks count = " + count);
		
	}
	
}
