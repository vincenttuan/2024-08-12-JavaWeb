package login.dao;

import java.util.List;

public interface ProductDao {
	// 查詢單筆
	Product getById(int productId);
	// 查詢全部
	List<Product> findAllProducts();
}
