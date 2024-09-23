package login.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 登入過濾器
@WebFilter(urlPatterns = {"/user/list", "/product/*"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 檢查有 session 登入資料才可以繼續
		HttpSession session = req.getSession();
		if(session.getAttribute("loginStatus") == null) {
			//resp.getWriter().print("Not Login !");
			// 該使用者原本要到哪裡 ?
			String requestURI = req.getRequestURI();
			// 將該路徑從放到 session 中
			session.setAttribute("requestURI", requestURI);
			// 外重導到登入頁面
			resp.sendRedirect("/JavaWeb/user/login");
			return;
		}
		
		// 有登入繼續往下
		chain.doFilter(req, resp);
	}
	
}
