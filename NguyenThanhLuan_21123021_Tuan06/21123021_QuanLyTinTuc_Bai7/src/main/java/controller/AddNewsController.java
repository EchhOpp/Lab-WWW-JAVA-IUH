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
import entity.TinTuc;

/**
 * Servlet implementation class AddNewsController
 */
public class AddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/QuanLyTinTuc")
	private DataSource dataSource;
	private DanhMucDao danhMucDao;
	private TinTucDao tinTucDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	danhMucDao = new DanhMucDaoImpl(dataSource);
    	tinTucDao = new TinTucDaoImpl(dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		   <form action="AddController" method="get">
//           <table>
//               <tr>
//                   <td>Mã tin tức</td>
//                   <td><input type="text" name="maTT" required></td>
//               </tr>
//               <tr>
//                   <td>Tiêu đề</td>
//                   <td><input type="text" name="tieuDe" required></td>
//               </tr>
//               <tr>
//                   <td>Nội dung</td>
//                   <td><input name="noiDungTT" required></textarea></td>
//               </tr>
//               <tr>
//                   <td>Liên kết</td>
//                   <td><input type="text" name="lienKet" required></td>
//               </tr>
//               <tr>
//                   <td>Mã danh mục</td>
//                   <td>
//                       <select name="maDM">
//                           <c:forEach items="${danhMucs}" var="itemsDM">
//                               <option value="${itemsDM.maDM}">${itemsDM.tenDM}</option>
//                           </c:forEach>
//                       </select>
//                   </td>
//               </tr>
//               <tr>
//                   <td></td>
//                   <td><input type="submit" value="Thêm"></td>
//               </tr>
//           </table>

		String maTT = request.getParameter("maTT");
		String tieuDe = request.getParameter("tieuDe");
		String noiDungTT = request.getParameter("noiDungTT");
		String lienKet = request.getParameter("lienKet");
		String maDM = request.getParameter("maDM");
		TinTuc tt = new TinTuc(maTT, tieuDe, noiDungTT, lienKet, maDM);
	
		if(tinTucDao.addTinTuc(tt)) {
            request.setAttribute("message", "Thêm thành công");
        } else {
            request.setAttribute("message", "Hãy thêm tin tức mới");
        }
		
		
		request.setAttribute("danhMucs", danhMucDao.getAllDanhMuc());
		request.getRequestDispatcher("view/add/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
