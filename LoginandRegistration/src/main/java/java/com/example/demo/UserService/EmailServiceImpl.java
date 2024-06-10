package java.com.example.demo.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	@Autowired
	private JavaMailSender mailsender;
	
	public void MailSend(String to,String body,String Subject) {
		SimpleMailMessage mailmessage = new SimpleMailMessage();
		mailmessage.setTo(to);
		mailmessage.setSubject(Subject);
		mailmessage.setText(body);
		mailsender.send(mailmessage);
	}

}
