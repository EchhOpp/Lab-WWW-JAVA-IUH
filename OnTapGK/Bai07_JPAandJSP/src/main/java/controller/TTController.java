package controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utlis.ConnectDB;

import java.io.IOException;
import java.util.List;

import dao.DanhMucDao;
import dao.TinTucDao;
import daoimpl.DanhMucDaoImpl;
import daoimpl.TinTucDaoImpl;
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class TTController
 */
public class TTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DanhMucDao danhMucDao;
	private TinTucDao tinTucDao;
	private EntityManager entityManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TTController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	ConnectDB connectDB = new ConnectDB();
    	entityManager = connectDB.getEntityManager();
    	danhMucDao = new DanhMucDaoImpl(entityManager);
    	System.out.println("danhMucDao: " + danhMucDao.getAll());
    	tinTucDao = new TinTucDaoImpl(entityManager);
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
			case "showDanhSach":
				showDanhsach(request, response);
	            break;
	        case "showThemTT":
				showThemTT(request, response);
				break;
			case "addTT":
				addTT(request, response);
				break;
				
	        case "showQL":
	        	showQL(request, response);
	        	break;
	        default:
	        	showDanhsach(request, response);
	        	break;
		}
	}

	private void addTT(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
//		<tr>
//		<td>Mã tin tức</td>
//		<td><input type="text" name="txtmaTT"></td>
//	</tr>
//	<tr>
//		<td>Tiêu đề</td>
//		<td><input type="text" name="txttieuDe"></td>
//	</tr>
//	<tr>
//		<td>Nội dung</td>
//		<td><input type="text" name="txtnoiDungTT"></td>
//	</tr>
//	<tr>
//		<td>Liên kết</td>
//		<td><input type="text" name="txtlienKet"></td>
//	</tr>
//	<tr>
//		<td>Mã danh mục</td>
//		<td><input type="text" name="txtmaDM"></td>
//	</tr>
//	<tr>
//		<td colspan="2"><input type="submit" value="Thêm mới"></td>
//	</tr>
		    
            String maTT = request.getParameter("txtmaTT");
            String tieuDe = request.getParameter("txttieuDe");
            String noiDungTT = request.getParameter("txtnoiDungTT");
            String lienKet = request.getParameter("txtlienKet");
            String maDM = request.getParameter("txtmaDM");
            
            TinTuc tinTuc = new TinTuc();
            tinTuc.setMaTT(maTT);
            tinTuc.setTieuDe(tieuDe);
            tinTuc.setNoiDungTT(noiDungTT);
            tinTuc.setLienKet(lienKet);
            DanhMuc danhMuc = danhMucDao.getById(maDM);
            tinTuc.setDanhMuc(danhMuc);
            
            tinTucDao.add(tinTuc);
            showDanhsach(request, response);
	}

	private void showThemTT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.getRequestDispatcher("views/body/ShowAdd.jsp").forward(request, response);
	}

	private void showQL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/body/ShowChucNang.jsp").forward(request, response);
	}

	private void showDanhsach(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<TinTuc> list = tinTucDao.getAll();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("views/body/ShowList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
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
