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

/**
 * Servlet implementation class HomeBookController
 */
@WebServlet(urlPatterns = {"/home"})
public class HomeBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private BookDao bookDao;
    @Resource(name = "jdbc/bookstore")
    private DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
    		System.out.println(dataSource.getConnection());
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	bookDao = new BookDaoImpl(dataSource);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("books", bookDao.getAllBook());
		request.getRequestDispatcher("views/home/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
