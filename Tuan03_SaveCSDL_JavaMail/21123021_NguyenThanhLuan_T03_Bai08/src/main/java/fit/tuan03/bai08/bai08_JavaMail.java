package fit.tuan03.bai08;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tuan03_Bai08
 */
@WebServlet("/bai08_JavaMail")
public class bai08_JavaMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public bai08_JavaMail() {
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
		String to = request.getParameter("rMail");
		String from = request.getParameter("sMail");
		String host = "localhost";
		
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.host", host);
		
		Session session = Session.getDefaultInstance(properties);
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
			message.setSubject("This is the Subject Line!");
			
			BodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setText("Message body");// Nội dung
			Multipart multipart = new MimeMultipart();// Email sẽ gồm 2 part (text, file attached)
			multipart.addBodyPart(messageBodyPart); // Phần text
			// Phần xử lý với file attached
			messageBodyPart = new MimeBodyPart();
			
			String filename = "file.txt";
			DataSource source = new FileDataSource(filename);
			
			messageBodyPart.setDataHandler(new DataHandler(source));
			
			messageBodyPart.setFileName(filename);
			
			multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);
			
			Transport.send(message); // Gửi mail
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
