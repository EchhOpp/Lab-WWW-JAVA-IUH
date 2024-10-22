package bookstore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bookstore.dao.BillDao;
import bookstore.dao.BookDao;
import bookstore.daoimpl.BookDaoImpl;
import bookstore.entity.Book;
import bookstore.entity.DetailBill;

/**
 * Servlet implementation class BillController
 */
@WebServlet(urlPatterns = {"/bill", "/bill/*"})
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BookDao bookDao;
	private BillDao billDao;
	@Resource(name = "jdbc/bookstore")
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillController() {
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
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		
		switch (action) {
			case "add":
				doGetAdd(request, response);
				break;
			case "delete":
				doGetDelete(request, response);
				break;
			default:
				doGetDisplay(request, response);
				break;
		}
	}

	private void doGetDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/bill/index.jsp").forward(request, response);
	}

	private void doGetDelete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Book> books = (List<Book>) session.getAttribute("bill");
		int id = Integer.parseInt(request.getParameter("id"));
		int index = isExisting(id, books);
		books.remove(index);
		session.setAttribute("bill", books);
		try {
			response.sendRedirect("bill");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doGetAdd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Book> books = null;
		if (session.getAttribute("bill") == null) {
			books = new ArrayList<>();
		} else {
			books = (List<Book>) session.getAttribute("bill");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.getBook(id);
		if (book != null) {
			int index = isExisting(id, books);
			if (index == -1) {
                books.add(book);
            } else {
                String quantity = books.get(index).getQuantity();
                books.get(index).setQuantity(Integer.parseInt(quantity) + 1 + "");
            }
		}
		session.setAttribute("bill", books);
		System.out.println("Bill: " + session.getAttribute("bill"));
		try {
			response.sendRedirect("bill");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int isExisting(int id, List<Book> books) {
		// TODO Auto-generated method stub
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
