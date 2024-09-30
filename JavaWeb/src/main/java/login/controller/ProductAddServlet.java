package login.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
	}
	
}
