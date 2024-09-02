package test;

import org.junit.jupiter.api.Test;

import login.service.EmailService;

public class SendEmail {
	
	@Test
	public void send() {
		EmailService emailService = new EmailService();
		String to = "vincenttuan@gmail.com"; // 收信者
		String url = "http://localhost:8080/JavaWeb"; // 驗證信件 url
		
		emailService.sendEmail(to, url);
		
		System.out.println("信件發送完畢");
		
	}
	
}
