package login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import login.entity.Product;
import login.exception.ProductDaoRuntimeException;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	
	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		String sql = "select product_id, product_name, price, stock_quantity from product";
		List<Product> products = new ArrayList<>();
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);) {
			
		} catch (SQLException e) {
			throw new ProductDaoRuntimeException(e.getMessage());
		}
		return products;
	}
	
}
