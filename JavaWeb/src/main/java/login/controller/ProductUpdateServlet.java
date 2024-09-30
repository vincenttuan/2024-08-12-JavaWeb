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
import login.dto.ProductDto;
import login.entity.Product;
import login.exception.ProductDaoRuntimeException;
import login.service.ProductService;

// 修改商品(含上傳圖片)
@WebServlet("/product/update")
@MultipartConfig(maxFileSize = 1024*1024*10) // 設定上傳檔案大小 10MB
public class ProductUpdateServlet extends HttpServlet {
	
	private ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ProductDto productDto = productService.getById(Integer.parseInt(id));
		req.setAttribute("productDto", productDto);
		// 重導到 product_update.jsp
		req.getRequestDispatcher("/WEB-INF/jsp/login/product_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得一般表單資料
		String id = req.getParameter("id");
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
		
		String resultMessage = "修改";
		try {
			productService.updateProduct(id, productName, price, stockQuantity, base64Image);
			resultMessage += "成功";
		} catch (ProductDaoRuntimeException e) {
			resultMessage += "失敗: " + e.getMessage();
		}
		
		req.setAttribute("resultMessage", resultMessage);
		req.setAttribute("productName", productName);
		req.setAttribute("price", price);
		req.setAttribute("stockQuantity", stockQuantity);
		req.setAttribute("base64Image", base64Image);
		
		req.getRequestDispatcher("/WEB-INF/jsp/login/product_result.jsp").forward(req, resp);
	}
	
}
