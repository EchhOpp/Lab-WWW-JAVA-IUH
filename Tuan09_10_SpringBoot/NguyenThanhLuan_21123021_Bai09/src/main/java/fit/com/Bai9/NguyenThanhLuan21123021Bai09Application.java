package fit.com.Bai9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class NguyenThanhLuan21123021Bai09Application {

    public static void main(String[] args) {
        SpringApplication.run(NguyenThanhLuan21123021Bai09Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowserOnStartup() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI("http://localhost:8080/"));
            } else {
                System.err.println("Desktop is not supported on this system.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
