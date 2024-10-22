package bookstore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import bookstore.dao.BookDao;
import bookstore.daoimpl.BookDaoImpl;
import bookstore.entity.Book;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet(urlPatterns = {"/bookdetail"})
public class BookDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/bookstore")
	private DataSource dataSource;
	private BookDao bookDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	bookDao = new BookDaoImpl(dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		Book book = bookDao.getBook(id);
		if (book == null) {
			response.sendRedirect("home");
			return;
		}
		System.out.println(book);
		request.setAttribute("book", book);
		System.out.println(request.getAttribute("book"));
		request.getRequestDispatcher("views/detail/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
