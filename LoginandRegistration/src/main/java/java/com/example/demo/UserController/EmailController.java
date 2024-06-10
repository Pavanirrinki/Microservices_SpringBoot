package java.com.example.demo.UserController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.com.example.demo.UserService.EmailServiceImpl;

@RestController
@RequestMapping("/send_email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

	@Autowired
	private EmailServiceImpl emailservice;
	
	
	@PostMapping("/1234")
	public void SendMail(@RequestBody Map<String, String> emailRequest) {
		System.out.println("poooooo");
		emailservice.MailSend(emailRequest.get("to"),emailRequest.get("body"),emailRequest.get("Subject"));
		
	}
	
@GetMapping("/po")
public String data() {
	return "powert";
}
	}
