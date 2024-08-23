package guestbook.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import guestbook.dao.GuestbookDao;
import guestbook.entity.Guestbook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/find")
public class FindGuestbookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 查詢所有留言紀錄
		GuestbookDao dao = new GuestbookDao();
		List<Guestbook> guestbooks = dao.findAllGuestbooks();
		
		// 將所有留言轉成 json 格式後印出
		Gson gson = new Gson();
		String guestBooksJsonString = gson.toJson(guestbooks.toArray());
		resp.getWriter().print(guestBooksJsonString);
		
	}
	
}
