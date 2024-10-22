package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import dao.DanhMucDao;
import dao.TinTucDao;
import daoimpl.DanhMucDaoImpl;
import daoimpl.TinTucDaoImpl;

/**
 * Servlet implementation class HomeController
 */

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/QuanLyTinTuc")
	private DataSource dataSource;
	private DanhMucDao danhMucDao;
	private TinTucDao tinTucDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
			danhMucDao = new DanhMucDaoImpl(dataSource);
			System.out.println(danhMucDao.getAllDanhMuc());
			tinTucDao = new TinTucDaoImpl(dataSource);
			System.out.println(tinTucDao.getAllTinTuc());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("danhMucs", danhMucDao.getAllDanhMuc());
		request.setAttribute("tinTucs", tinTucDao.getAllTinTuc());
		request.getRequestDispatcher("view/home/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
