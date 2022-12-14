package demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAdminServer
@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class ResourceApplication {

	@RequestMapping("/hello")
	@CrossOrigin(origins="*", maxAge=3600)
	public Message secured() {
		return new Message("Secured Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

}

class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	Message() {
	}

	public Message(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
