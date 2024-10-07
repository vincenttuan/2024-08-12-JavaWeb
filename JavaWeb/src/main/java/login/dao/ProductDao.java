package login.dao;

import java.sql.SQLException;
import java.util.List;

import login.entity.Product;

public interface ProductDao {
	// 查詢單筆
	Product getById(int productId);
	// 查詢全部
	List<Product> findAllProducts();
	// 單筆新增
	void add(Product product) throws SQLException;
	// 單筆修改
	void update(int id, Product product) throws SQLException;
	// 扣抵庫存
	void deductInventory(int productId, int amount) throws SQLException;
}
