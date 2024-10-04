package login.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.dto.UserDto;
import login.exception.LoginException;
import login.service.UserService;

// 使用者登入
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	
	private UserService userService = UserService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到指定 login.jsp 表單畫面
		req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String authCode = req.getParameter("authCode");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		// 比對登入資訊
		try {
			// 比對驗證碼
			String sessionAuthCode = (String)session.getAttribute("authCode");
			if(!authCode.equals(sessionAuthCode)) { // 比對
				throw new LoginException("驗證碼不符");
			}
			// 比對 userName & password 登入資訊
			UserDto userDto = userService.verifyUser(userName, password);
			req.setAttribute("userDto", userDto);
			req.setAttribute("loginSuccess", true);
			req.setAttribute("loginMessage", "登入成功");
			// 透過 session 來紀錄登入成功資訊
			session.setAttribute("loginStatus", true); // 登入狀態
			session.setAttribute("loginName", userName); // 登入者姓名
			session.setAttribute("userDto", userDto); // userDto
			// 檢查 session 中有無 requestURI 的資料?
			if(session.getAttribute("requestURI") != null) {
				String requestURI = (String)session.getAttribute("requestURI");
				session.setAttribute("requestURI", null); // 清空 "requestURI"
				resp.sendRedirect(requestURI); // 重導到指定地點
				return;
			}
			
		} catch (LoginException e) {
			req.setAttribute("loginSuccess", false);
			req.setAttribute("loginMessage", "登入失敗: " + e.getMessage());
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/login/login_result.jsp").forward(req, resp);
	}
	
}
