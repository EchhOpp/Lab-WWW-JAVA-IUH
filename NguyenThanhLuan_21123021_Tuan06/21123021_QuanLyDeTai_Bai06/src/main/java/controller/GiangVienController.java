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

import dao.GiangVienDao;
import daoImpl.GiangVienImpl;

/**
 * Servlet implementation class GiangVienController
 */
public class GiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GiangVienDao giangVienDAO;
	@Resource(name = "jdbc/QuanLyDeTai")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiangVienController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
			System.out.println("GiangVienController: init" + this.dataSource.getConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	giangVienDAO = new GiangVienImpl(dataSource);
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
