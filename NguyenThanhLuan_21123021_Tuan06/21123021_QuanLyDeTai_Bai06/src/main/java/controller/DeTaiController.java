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

import dao.DeTaiDao;
import daoImpl.DeTaiImpl;

/**
 * Servlet implementation class DeTaiController
 */
public class DeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/QuanLyDeTai")
	private DataSource dataSource;
	private DeTaiDao deTaiDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTaiController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
    		System.out.println("DeTaiController: init" + this.dataSource.getConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		deTaiDAO = new DeTaiImpl(dataSource);
;    }

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
