package com.example.demo;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBao09Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBao09Application.class, args);
		System.out.println("Hello World!");
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
//	public ApplicationRunner applicationRunner() {
//		return args -> {
//			try {
//                if (Desktop.isDesktopSupported()) {
//                    Desktop.getDesktop().browse(new URI("http://localhost:8080/"));
//                } else {
//                    System.err.println("Desktop is not supported on this system.");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//		};
//	}
}
