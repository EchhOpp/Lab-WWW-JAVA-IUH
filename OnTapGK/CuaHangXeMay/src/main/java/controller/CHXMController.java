package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConnectDB;

import java.io.IOException;
import java.util.List;

import dao.XeDao;
import daoimpl.XeDaoImpl;
import entity.Xe;

/**
 * Servlet implementation class CHXMController
 */
public class CHXMController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private XeDao xeDao;
	private ConnectDB connectDB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CHXMController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	connectDB = new ConnectDB();
    	xeDao = new XeDaoImpl(connectDB.getEntityManager());
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
			case "ShowList":
				showDanhsach(request, response);
				break;
			case "ShowAdd":
				showThem(request, response);
				break;
			case "add":
				Add(request, response);
				break;
			case "search":
				Search(request, response);
				break;
			default:
				showDanhsach(request, response);
				break;
		}
	}

	private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String maXe = request.getParameter("txtmaXe");
		String tenXe = request.getParameter("txttenXe");
		String giaXe = request.getParameter("txtgiaXe");
		String namSanXuat = request.getParameter("txtnamSanXuat");
		String maHangXe = request.getParameter("txtmaHangXe");
		Xe xe = new Xe(maXe, tenXe, giaXe, namSanXuat, maHangXe);
		if (xeDao.addXe(xe)) {
			request.setAttribute("message", "Thêm mới thành công");
		} else {
			request.setAttribute("message", "Thêm mới thất bại");
		}
		response.sendRedirect("CHXMController?action=ShowList");
	}

	private void Search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String txtSearch = request.getParameter("txtSearch");
		request.setAttribute("list", xeDao.getByTenOrGia(txtSearch));
		try {
			request.getRequestDispatcher("views/body/ShowSearch.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void showThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/body/ShowAdd.jsp").forward(request, response);
	}

	private void showDanhsach(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("list", xeDao.getAllXe());
		try {
			request.getRequestDispatcher("views/body/ShowList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
