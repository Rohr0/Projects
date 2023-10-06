package og.jsp.mailsenderapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@CrossOrigin
public class SendMailController {
	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping("/send")
	public String sendMail(@RequestParam String email) {
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper  helper=new MimeMessageHelper(message);
		try {
			helper.setTo(email);
			helper.setSubject("Testing Mail API");
			helper.setText("Mail sent successfully  ");
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mailSender);
		return "Mail Sent to : "+email;
	}

}
