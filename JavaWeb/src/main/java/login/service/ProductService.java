package login.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.dao.ProductDao;
import login.dao.ProductDaoImpl;
import login.dto.ProductDto;
import login.entity.Product;
import login.exception.ProductDaoRuntimeException;

public class ProductService {
	
	private ProductDao productDao = new ProductDaoImpl();
	
	// 取得 ProductDto 物件資料
	public ProductDto getById(int productId) {
		// 自 productDao 得到 Product 物件
		Product product = productDao.getById(productId);
		if(product == null) {
			return null;
		}
		// 將 Product 物件轉 ProductDto 物件
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getProductId());
		productDto.setName(product.getProductName());
		productDto.setPrice(product.getPrice());
		productDto.setQty(product.getStockQuantity());
		productDto.setImageBase64(product.getImageBase64());
		return productDto;
	}
	
	public List<ProductDto> findAllProducts() {
		// 自 productDao 得到 products 集合物件
		List<Product> products = productDao.findAllProducts();
		if(products.size() == 0) {
			return new ArrayList<>();
		}
		List<ProductDto> productDtos = new ArrayList<>();
		products.forEach(product -> {
			// 將 Product 物件轉 ProductDto 物件
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getProductId());
			productDto.setName(product.getProductName());
			productDto.setPrice(product.getPrice());
			productDto.setQty(product.getStockQuantity());
			productDto.setImageBase64(product.getImageBase64());
			// 注入到 productDtos 集合中
			productDtos.add(productDto);
		});
		return productDtos;
	}
	
	public void addProduct(String productName, String price, String stockQuantity, String imageBase64)  {
		// 檢查略..
		Product product = new Product();
		product.setProductName(productName);
		product.setPrice(Double.parseDouble(price));
		product.setStockQuantity(Integer.parseInt(stockQuantity));
		product.setImageBase64(imageBase64);
		// 新增
		try {
			productDao.add(product);
		} catch (SQLException e) {
			throw new ProductDaoRuntimeException(e.getMessage());
		}
	}
	
	public void updateProduct(String id, String productName, String price, String stockQuantity, String imageBase64)  {
		// 檢查略..
		Product product = new Product();
		product.setProductName(productName);
		product.setPrice(Double.parseDouble(price));
		product.setStockQuantity(Integer.parseInt(stockQuantity));
		product.setImageBase64(imageBase64);
		// 修改
		try {
			productDao.update(Integer.parseInt(id), product);
		} catch (SQLException e) {
			throw new ProductDaoRuntimeException(e.getMessage());
		}
	}
}
