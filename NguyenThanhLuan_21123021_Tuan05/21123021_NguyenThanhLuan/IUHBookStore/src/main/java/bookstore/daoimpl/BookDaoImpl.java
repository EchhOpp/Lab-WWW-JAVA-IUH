package bookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bookstore.dao.BookDao;
import bookstore.entity.Book;
import jakarta.annotation.Resource;

public class BookDaoImpl implements BookDao{
	
	private DataSource dataSource;

	public BookDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public BookDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		String query = "SELECT * FROM Book";
		try(
				Connection conn = this.dataSource.getConnection();
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				) {
			while(rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				String image = rs.getString("image");
				String price = rs.getString("price");
				String quantity = rs.getString("quantity");
				Book book = new Book(Integer.parseInt(id), title, image, price, quantity);
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		System.out.println(list);
		return list;
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		Book book = null;
		String query = "SELECT * FROM Book WHERE id = ?";
		try(
                Connection conn = this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
                ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String title = rs.getString("title");
                String image = rs.getString("image");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                book = new Book(id, title, image, price, quantity);
            }
        } catch (Exception e) {
			e.printStackTrace();
			return null;
        }
		return book;
	}

	@Override
	public void insertBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	
}
