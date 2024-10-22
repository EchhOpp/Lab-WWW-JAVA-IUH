package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.DeTaiDao;
import dao.GiangVienDao;
import daoImpl.DeTaiImpl;
import daoImpl.GiangVienImpl;
import entity.DeTai;
import entity.GiangVien;

/**
 * Servlet implementation class GiangVienController
 */
@WebServlet( urlPatterns = {"/displayTeacher"})
public class DisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GiangVienDao giangVienDAO;
	private DeTaiDao deTaiDao;
	
	@Resource(name = "jdbc/QuanLyDeTai")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
			System.out.println("GiangVienController: init" + this.dataSource.getConnection());
			System.out.println("GiangVienController: init" + this.dataSource.getConnection());
			giangVienDAO = new GiangVienImpl(dataSource);
	    	deTaiDao = new DeTaiImpl(dataSource);
	    	System.out.println(giangVienDAO.getAllGiangVien());
	    	System.out.println(deTaiDao.getAllDeTai());
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
        List<GiangVien> giaoVienList = giangVienDAO.getAllGiangVien();
        request.setAttribute("giaoVienList", giaoVienList);
        
        List<DeTai> deTaiList = deTaiDao.getAllDeTai();
        request.setAttribute("deTaiList", deTaiList);
        
        System.out.println(request.getAttribute("giaoVienList"));
        System.out.println(request.getAttribute("deTaiList"));
		request.getRequestDispatcher("displaytable/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
