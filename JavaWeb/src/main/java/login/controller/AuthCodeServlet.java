package login.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import jakarta.servlet.http.HttpSession;

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
		// 將驗證碼存入到 session 中
		HttpSession session = req.getSession();
		session.setAttribute("authCode", authCode);
		// 寫入圖片資料
		ImageIO.write(getAuthCodeImage(authCode), "JPEG", resp.getOutputStream());
	}
	
	// 產生圖像資訊
	private BufferedImage getAuthCodeImage(String authCode) {
		// 建立圖像暫存區
		BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		// 建立畫布
		Graphics g = img.getGraphics();
		// 設定顏色
		g.setColor(Color.YELLOW); // 拿彩色筆(黃)
		// 塗滿背景
		g.fillRect(0, 0, 80, 30);
		// 設定顏色
		g.setColor(Color.BLACK); // 拿彩色筆(黑)
		
		// 設定字型
		//g.setFont(new Font("新細明體", Font.BOLD, 20)); // 字體, 風格, 大小
		// 繪字串
		//g.drawString(authCode, 22, 22);
		
		// 不同字型大小與位置
		g.setFont(new Font("新細明體", Font.BOLD, 14));
        g.drawString(authCode.charAt(0)+"", 3, 17); // code, x, y
        g.setFont(new Font("新細明體", Font.BOLD, 30));
        g.drawString(authCode.charAt(1)+"", 10, 25); // code, x, y
        g.setFont(new Font("新細明體", Font.BOLD, 18));
        g.drawString(authCode.charAt(2)+"", 40, 25); // code, x, y
        g.setFont(new Font("新細明體", Font.BOLD, 20));
        if(authCode.charAt(3) % 2 == 0)
            g.drawString(authCode.charAt(3)+"", 65, 10); // code, x, y
        else
            g.drawString(authCode.charAt(3)+"", 65, 27); // code, x, y
		
		// 干擾線 
		g.setColor(Color.RED);
		for(int i=0;i<15;i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(80);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2); // 繪直線
		}
		return img;
	}
	
}
