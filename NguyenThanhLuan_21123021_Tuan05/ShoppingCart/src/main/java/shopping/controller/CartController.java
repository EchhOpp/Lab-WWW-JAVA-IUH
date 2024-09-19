package shopping.controller;

import java.io.IOException;

import javax.sql.DataSource;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shopping.dao.ProductDao;
import shopping.daoimpl.ProductDaoImpl;


/**
 * Servlet implementation class CartController
 */
@WebServlet(urlPatterns = {"/cart", "/cart*" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource dataSource;
	private ProductDao productDao;
    /**
     * Default constructor. 
     */
    public CartController() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	productDao = new ProductDaoImpl(this.dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
