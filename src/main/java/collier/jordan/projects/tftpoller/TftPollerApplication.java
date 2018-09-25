package collier.jordan.projects.tftpoller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TftPollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TftPollerApplication.class, args);
	}
}
