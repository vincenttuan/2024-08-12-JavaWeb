package login.dao;

import java.sql.SQLException;
import java.util.List;

import login.entity.Product;

public interface ProductDao {
	// 單筆新增
	void add(Product product) throws SQLException;
	// 查詢單筆
	Product getById(int productId);
	// 查詢全部
	List<Product> findAllProducts();
}
