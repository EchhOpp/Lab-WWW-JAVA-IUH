package servletStudent;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.Student;
import student.Qualification;

/**
 * Servlet implementation class ServletStudent
 */
@WebServlet("/ServletStudent")
public class ServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletStudent() {
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
        // Get the parameters from the form	
		String studentFName = request.getParameter("studentFName");
		String studentLName = request.getParameter("studentLName");
		String studentDOB = request.getParameter("studentDOB");
		String studentEmail = request.getParameter("studentEmail");
		String studentPhone = request.getParameter("studentPhone");
		String studentGender = request.getParameter("gender");
		String studentAddress = request.getParameter("studentAddress");
		String studentCity = request.getParameter("studentCity");
		String studentPin = request.getParameter("studentPin");
		String studentState = request.getParameter("studentState");
		String studentCountry = request.getParameter("studentCountry");
		String[] studentHobbies = request.getParameterValues("studentHobbies");
		String studentBoard1 = request.getParameter("studentBoard1");
		String studentPercentage1 = request.getParameter("studentPercentage1");
		String studentYear1 = request.getParameter("studentYear1");
		String studentBoard2 = request.getParameter("studentBoard2");
		String studentPercentage2 = request.getParameter("studentPercentage2");
		String studentYear2 = request.getParameter("studentYear2");
		String studentBoard3 = request.getParameter("studentBoard3");
		String studentPercentage3 = request.getParameter("studentPercentage3");
		String studentYear3 = request.getParameter("studentYear3");
		String studentBoard4 = request.getParameter("studentBoard4");
		String studentPercentage4 = request.getParameter("studentPercentage4");
		String studentYear4 = request.getParameter("studentYear4");
		String studentCourse = request.getParameter("studentCourse");
		
	
		Qualification qualification1 = new Qualification(studentBoard1, studentPercentage1, studentYear1);
		Qualification qualification2 = new Qualification(studentBoard2, studentPercentage2, studentYear2);
		Qualification qualification3 = new Qualification(studentBoard3, studentPercentage3, studentYear3);
		Qualification qualification4 = new Qualification(studentBoard4, studentPercentage4, studentYear4);
		
		Student student = new Student(
				studentFName, studentLName, studentDOB, studentEmail, studentPhone, studentGender,
                studentAddress, studentCity, studentPin, studentState, studentCountry, studentHobbies,
                qualification1, qualification2, qualification3, qualification4, studentCourse);
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("studentDetails.jsp").forward(request, response);
	}

}
