package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProductManager {

	private final Map<Integer, Product> allProducts = new HashMap<>();

	public ProductManager() {
		loadProducts();
	}

	public void loadProducts() {

		try {
			Connection cn = ConnectorDB.getConnection();

			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM product");

			while (rs.next()) {
				int id = rs.getInt(1);
				String descr = rs.getString(2);

				allProducts.put(id, new Product(id, descr));
			}

			rs.close();
			statement.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Map<Integer, Product> getAllProducts() {
		return allProducts;
	}

	public void addProduct(String descr) {
		if (getProduct(descr) != null) {
			return;
		}

		String sql = "INSERT INTO product(descr) VALUES(?)";

		try (Connection cn = ConnectorDB.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setString(1, descr);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		loadProducts();
	}

	public void removeProduct() {

	}

	public void updateProduct(Product product) {
		
		String sql = String.format("UPDATE product SET descr = '%s' where id = %d", product.getDescr(), product.getId());

		try (Connection cn = ConnectorDB.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		loadProducts();
		
		
	}

	public Product getProduct(String descr) {

		for(Entry<Integer, Product> entry : allProducts.entrySet())
		{
			Product product = entry.getValue();
			if (product.getDescr().equals(descr)){
				return product;
			}
		}

		return null;
	}

}
