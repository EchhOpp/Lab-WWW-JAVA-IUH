package fit.bai07;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tuan02_Bai07
 */
@WebServlet("/Tuan02_Bai07")
public class Tuan02_Bai07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int BUFFER_SIZE = 4096;
	private static final String SAVE_DIR = "images";
	
	private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB";
	private String user = "sa";
	private String password = "sapassword";

    /**
     * Default constructor. 
     */
    public Tuan02_Bai07() {
        // TODO Auto-generated constructor stub
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		InputStream inputStream = null;
	}

}
