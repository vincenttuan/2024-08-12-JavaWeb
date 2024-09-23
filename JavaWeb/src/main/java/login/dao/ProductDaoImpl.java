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
		String sql = "select product_id, product_name, price, stock_quantity from product where product_id = ?";
		
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		String sql = "select product_id, product_name, price, stock_quantity from product";
		List<Product> products = new ArrayList<>();
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);) {
			
			while(rs.next()) {
				// 建立商品物件, 將資料紀錄逐一注入到對應的商品物件屬性中
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setStockQuantity(rs.getInt("stock_quantity"));
				// 將商品注入到集合中
				products.add(product); 
			}
			
		} catch (SQLException e) {
			throw new ProductDaoRuntimeException(e.getMessage());
		}
		return products;
	}
	
}
