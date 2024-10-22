package fit.se.tuan02;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class UploadFileServket
 */

//@WebServlet("/UploadFileServket")

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 , // 1MB
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 5 // 5MB
)

public class UploadFileServket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPLOAD_PATH = null;

    public UploadFileServket() {
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException {
		super.init();
		UPLOAD_PATH = getServletContext().getInitParameter("upload.path");
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
		try {
			for (Part filePart : request.getParts()) {
				if (filePart == null || filePart.getSubmittedFileName() == null
						|| filePart.getSubmittedFileName().isEmpty()) {
					continue;
				}
				
				String fileName = filePart.getSubmittedFileName();
				
				InputStream inputStream = filePart.getInputStream();
				Files.copy(inputStream, Paths.get(UPLOAD_PATH + File.separator + fileName),
						StandardCopyOption.REPLACE_EXISTING);
				System.out.println(UPLOAD_PATH + File.separator + fileName);
			}
			
			response.getWriter().println("Upload success");
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().println("Upload failed: "+ e.getMessage());
		}
	}

}
