package bookstore.dao;

import java.util.List;

import bookstore.entity.Book;

public interface BookDao {
	public List<Book> getAllBook();
	public Book getBook(int id);
	public void insertBook(Book book);
}
