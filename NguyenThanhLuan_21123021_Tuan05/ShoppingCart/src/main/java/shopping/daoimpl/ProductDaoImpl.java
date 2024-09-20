package shopping.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import shopping.dao.ProductDao;
import shopping.entity.Product;

public class ProductDaoImpl implements ProductDao {
	
	private DataSource dataSource;
	
	public ProductDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public ProductDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getAllProducts() {
		 	List<Product> products = new ArrayList<>(); // Khởi tạo danh sách products
	        String query = "SELECT * FROM Product"; // Đảm bảo rằng cột image tồn tại
	        try (
	            Connection conn = this.dataSource.getConnection();
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();
	        ) {
	            while (rs.next()) {
	                Product product = new Product();
	                product.setId(rs.getInt("id"));
	                product.setName(rs.getString("name"));
	                product.setPrice(rs.getDouble("price"));
	                product.setImage(rs.getString("img"));
	                products.add(product);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	        System.out.println(products);
	        return products;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Product product = null;
		String query = "SELECT * FROM product WHERE id = ?";
		
		try (
				Connection conn = this.dataSource.getConnection(); 
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int productId = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String image = rs.getString("img");
				product = new Product(productId, name, price, image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO product(name, price, image) VALUES(?, ?, ?)";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
