package login.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 取得驗證碼
@WebServlet("/user/authcode")
public class AuthCodeServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(AuthCodeServlet.class);
	private Random random = new Random();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 產生四位數的隨機驗證碼
		String authCode = String.format("%04d", random.nextInt(10000)); // 0000~9999
		logger.info("驗證碼: " + authCode);
		
		// 寫入圖片資料
		ImageIO.write(getAuthCodeImage(authCode), "JPEG", resp.getOutputStream());
	}
	
	// 產生圖像資訊
	private BufferedImage getAuthCodeImage(String authCode) {
		return null;
	}
	
}
