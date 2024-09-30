package login.dao;

import java.util.List;

import login.entity.Product;

public interface ProductDao {
	// 單筆新增
	void add(Product product);
	// 查詢單筆
	Product getById(int productId);
	// 查詢全部
	List<Product> findAllProducts();
}
