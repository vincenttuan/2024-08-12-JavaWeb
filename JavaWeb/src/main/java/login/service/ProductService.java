package login.service;

import login.dao.ProductDao;
import login.dao.ProductDaoImpl;
import login.entity.Product;

public class ProductService {
	
	private ProductDao productDao = new ProductDaoImpl();
	
	public ProductDto getById(int productId) {
		return productDao.getById(productId);
	}
	
}
