package LopController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Utils.ConnectDB;
import dao.LopDao;
import daoimpl.LopDaoImpl;

/**
 * Servlet implementation class LopController
 */
public class LopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private LopDao lopDao;
	private ConnectDB connectDB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LopController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	connectDB = new ConnectDB();
    	lopDao = new LopDaoImpl(connectDB.getEntityManager());
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
		case "addSV":
			addTT(request, response);
			break;
        default:
        	showList(request, response);
        	break;
	} 
	}

	private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", lopDao.getAllLop());
		request.getRequestDispatcher("views/body/showList.jsp").forward(request, response);
	}
	
	private void showDanhsach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", lopDao.getSinhVienByLop(request.getParameter("maLop")));
		request.getRequestDispatcher("views/body/showList.jsp").forward(request, response);
	}

	private void addTT(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void showThemTT(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
