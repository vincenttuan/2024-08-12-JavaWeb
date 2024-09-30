package login.controller;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

// 新增商品(含上傳圖片)
@WebServlet("/product/add")
@MultipartConfig(maxFileSize = 1024*1024*10) // 設定上傳檔案大小 10MB
public class ProductAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到 product_add.jsp
		req.getRequestDispatcher("/WEB-INF/jsp/login/product_add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得一般表單資料
		String productName = req.getParameter("product_name");
		String price = req.getParameter("price");
		String stockQuantity = req.getParameter("stock_quantity");
		
		// 取得 type="file" 表單資料
		Part productImage = req.getPart("product_image");
		String base64Image = null;
		if(productImage != null && productImage.getSize() > 0) {
			// 將圖片傳換為 base64 編碼 (圖片轉字串)
			base64Image = Base64.getEncoder().encodeToString(productImage.getInputStream().readAllBytes());
		}
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<html>");
		resp.getWriter().println("商品名稱: " + productName + "<p>");
		resp.getWriter().println("商品價格: " + price + "<p>");
		resp.getWriter().println("商品庫存: " + stockQuantity + "<p>");
		resp.getWriter().println("商品圖片: <img src='data:image/png;base64," + base64Image + "'><p>");
		resp.getWriter().println("</html>");
		
	}
	
}
