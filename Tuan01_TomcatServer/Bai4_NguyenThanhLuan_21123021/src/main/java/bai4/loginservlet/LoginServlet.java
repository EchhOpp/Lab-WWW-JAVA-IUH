package bai4.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("Name");
		String email=request.getParameter("Email");
		String facebook=request.getParameter("Facebook");
		String shortbio=request.getParameter("ShortBio");
		String html= 
				"<br>"  + "<html>" + "<head>"    + "<title>Result Page</title>"
				+ "</head>"    + "<body>"
				+ "First Name: "+ name +"<br>"
				+ "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
				+ "Short Bio: "+ shortbio +"<br>"
				+ "</body>"    + "</html>";
				out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
