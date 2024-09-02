package javaweb.member.login.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;

import javaweb.member.login.util.LoggerUtil;

public class EmailService {
	private static final Logger logger = LoggerUtil.getLogger();
	
	// Google應用程式密碼
	// 請參考此篇 https://www.yongxin-design.com/Article/10
	// 請自行產生Google應用程式密碼
	String googleAppPassword = "";
	
    // 寄件者的電子郵件地址
    String from = "@gmail.com";
    
	// to: // 收件者的電子郵件地址
	public void sendEmail(String to, String confirmUrl) {
         
        // 使用 Gmail SMTP 伺服器
        String host = "smtp.gmail.com";

        // 設定屬性
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // 建立會話物件，並提供驗證資訊
        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                	// Google應用程式密碼請參考此篇
                	// https://www.yongxin-design.com/Article/10
                    return new PasswordAuthentication(from, googleAppPassword);
                }
            });

        try {
            // 建立一個預設的 MimeMessage 物件
            Message message = new MimeMessage(session);

            // 設定寄件者
            message.setFrom(new InternetAddress(from));

            // 設定收件者
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

            // 設定郵件標題
            message.setSubject("會員註冊確認信");

            // 設定郵件內容讓使用者點選連結（confirmUrl）進行確認
            message.setText("請點選以下連結進行確認：\n" + confirmUrl);
            
            // 傳送郵件
            Transport.send(message);

            logger.info("郵件發送成功！");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

