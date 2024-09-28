package shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shopping.dao.ProductDao;
import shopping.daoimpl.ProductDaoImpl;
import shopping.entity.CartItem;
import shopping.entity.Product;


/**
 * Servlet implementation class CartController
 */
@WebServlet(urlPatterns = {"/cart", "/cart*"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/shopping")
	private DataSource dataSource;
	
	private ProductDao productDao;
    /**
     * Default constructor. 
     */
    public CartController() {
        // TODO Auto-generated constructor stub
    	System.out.println(dataSource);
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
    		System.out.println(this.dataSource.getConnection());
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	productDao = new ProductDaoImpl(this.dataSource);
    	System.out.println(productDao.getAllProducts());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		
		switch (action) {
			case "buy":
				doGetBuy(request, response);
				break;
			case "remove":
				doGetRemove(request, response);
				break;
			default:
				doGetDisplayCart(request, response);
				break;
		}
	}


    private void doGetBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartItem> cart = null;
        if (session.getAttribute("cart") == null) {
            cart = new ArrayList<CartItem>();
        } else {
            cart = (List<CartItem>) session.getAttribute("cart");
        }
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Product ID: " + id);
        Product product = productDao.getProductById(id);
        if (product != null) {
            int index = isProductExisting(id, cart);
            if (index == -1) {
                cart.add(new CartItem(product, 1));
            } else {
                int quantity = cart.get(index).getQuantity() + Integer.parseInt(request.getParameter("quantity"));
                cart.get(index).setQuantity(quantity);
            }
        } else {
            System.out.println("Product not found for ID: " + id);
        }
        session.setAttribute("cart", cart);
        System.out.println("Cart: " + session.getAttribute("cart"));
        response.sendRedirect(request.getContextPath() + "/cart");
    }

	private void doGetRemove(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		int index = isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		try {
			response.sendRedirect("cart");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private int isProductExisting(int id, List<CartItem> cart) {
		// TODO Auto-generated method stub
	for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i).getProduct();
            if (product != null && product.getId() == id) {
                return i;
            }    
        }
        return -1;
	}

	private void doGetDisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/cart/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
