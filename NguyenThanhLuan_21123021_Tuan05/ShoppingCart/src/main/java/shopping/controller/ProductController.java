package shopping.controller;

import java.io.IOException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shopping.dao.ProductDao;
import shopping.daoimpl.ProductDaoImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Resource(name = "jdbc/shopping")
	private DataSource dataSource;
	private ProductDao productDao;
	
    /**
     * Default constructor. 
     */
    public ProductController() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
			System.out.println(this.dataSource.getConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	productDao = new ProductDaoImpl(this.dataSource);

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("products", productDao.getAllProducts());
		request.getRequestDispatcher("views/products/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
