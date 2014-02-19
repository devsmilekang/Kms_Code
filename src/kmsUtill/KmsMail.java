package kmsUtill;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**************************************************
 * lib 폴더에 있는 mail.jar 파일 import 
 * Oracle 에서 제공하는 JAVA mail
 **************************************************/


public class KmsMail {
	private String to;
	private String from;
	private Session session;
	private Properties props;
	private String hostname;
	private String from_pwd;
	
	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getHostname() {
		return hostname;
	}


	public void setHostname(String hostname) {
		this.hostname = hostname;
	}


	public KmsMail(String to, String from, String hostname, String from_pwd){
		this.to = to;
		this.from = from;
		this.hostname = hostname;
		this.from_pwd = from_pwd;
		this.props = new Properties();
		this.props.put("mail.smtp.host", "sniper.handysoft.co.kr"); //발송할 SMTP 서버
		this.session = Session.getInstance(props);
	}
	
	
	public void sendMail(String subject, String massage, String filepath) throws MessagingException, IOException {
		MimeMultipart multipart = new MimeMultipart();
		Message msg = new MimeMessage(this.session);
		msg.setFrom(new InternetAddress(this.from));
		InternetAddress[] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());
       // msg.setContent("테스트메일로 보냅니다.","text/html; charset=UTF-8");
        
        //파일첨부
        if(!"".equals(filepath)){
	        MimeBodyPart filepart = new MimeBodyPart();
	        File file = new File(filepath);
	        filepart.setDataHandler(new DataHandler(new FileDataSource(file)));
	        filepart.setFileName(file.getName());
	        multipart.addBodyPart(filepart);
        }
        MimeBodyPart bodypart = new MimeBodyPart();
        bodypart.setContent(massage,"text/html; charset=UTF-8");
        multipart.addBodyPart(bodypart);
        
        
        msg.setContent(multipart);
        Transport transport = this.session.getTransport("smtp");
        transport.connect(this.hostname,this.from,this.from_pwd); 
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
	}
}
