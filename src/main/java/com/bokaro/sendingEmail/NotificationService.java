package com.bokaro.sendingEmail;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

//	private JavaMailSender javaMailSender;
//	
//	@Autowired
//	public NotificationService(JavaMailSender javaMailSender) {
//		this.javaMailSender=javaMailSender;
//	}
//	public void sendNotification(UserDTO user)throws MailException{
//		SimpleMailMessage mail = new SimpleMailMessage();
//		mail.setTo(user.getEmail());
//		mail.setFrom("srivastava.praveen9@gmail.com");
//		mail.setSubject("hi, My name is Shipra Singh");
//		mail.setText("This is a cool email notification");
//		
//		javaMailSender.send(mail);
//	}
}
