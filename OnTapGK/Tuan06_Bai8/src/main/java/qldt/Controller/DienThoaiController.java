package qldt.Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qldt.Dao.DienThoaiDao;
import qldt.DaoImpl.DienThoaiImpl;
import qldt.Entities.DienThoai;
import qldt.Entities.NhaCungCap;
import qldt.Utils.persistenceUtils;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class DienThoaiController
 */
public class DienThoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private persistenceUtils utils;
	private DienThoaiDao dtDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DienThoaiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		utils = new persistenceUtils();
		dtDao = new DienThoaiImpl(utils.getEntityManager());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		utils.close();
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "add":
			ShowFormADD(request, response);
			break;
		case "update":
			showFormEdit(request, response);
			break;
		case "delete":
			DeleteDT(request, response);
			break;
		default:
			listDT(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "addDT":
			addDT(request, response);
			break;
		case "updateDT":
			updateDT(request, response);
			break;
		default:
			listDT(request, response);
			break;
		}
	}

	private void listDT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DienThoai> list = dtDao.getALLDT();
		request.setAttribute("listDT", list);
		request.getRequestDispatcher("views/dienthoai/list.jsp").forward(request, response);
	}

	private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int madt = Integer.parseInt(request.getParameter("txtmaDT"));
		DienThoai dt = dtDao.getDTByID(madt);
		request.setAttribute("dt", dt);
		request.getRequestDispatcher("views/dienthoai/edit.jsp").forward(request, response);
	}

	private void DeleteDT(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int madt = Integer.parseInt(request.getParameter("txtmaDT"));
		DienThoai dt = dtDao.getDTByID(madt);
		dtDao.deleteDT(dt.getMaDT());
		response.sendRedirect("DienThoai");
	}

	private void ShowFormADD(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/dienthoai/add.jsp").forward(request, response);
	}

	private void updateDT(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int madt = Integer.parseInt(request.getParameter("txtmaDT"));
		String tendt = request.getParameter("txttenDT");
		int namsx = Integer.parseInt(request.getParameter("txtnamSX"));
		int mancc = Integer.parseInt(request.getParameter("txtmaNCC"));
		String cauhinh = request.getParameter("txtcauHinh");
		NhaCungCap ncc = dtDao.getNCCByID(mancc);
		DienThoai dt = new DienThoai(madt, tendt, namsx, cauhinh, ncc);
		dtDao.updateDT(dt);
		response.sendRedirect("DienThoai");
	}

	private void addDT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tendt = request.getParameter("txttenDT");
		int namsx = Integer.parseInt(request.getParameter("txtnamSX"));
		int mancc = Integer.parseInt(request.getParameter("txtmancc"));
		String cauhinh = request.getParameter("txtcauHinh");
		NhaCungCap ncc = dtDao.getNCCByID(mancc);
		if(ncc == null) {
			String tenncc = request.getParameter("txttenNCC");
			String diachi = request.getParameter("txtdiaChi");
			String sdt = request.getParameter("txtsdt");
			ncc = new NhaCungCap(tenncc, diachi, sdt);
			dtDao.addNCC(ncc);
		}
		DienThoai dt = new DienThoai(tendt, namsx, cauhinh, ncc);
		dtDao.addDT(dt);
		response.sendRedirect("DienThoai");
	}
}
