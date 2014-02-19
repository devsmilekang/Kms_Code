package kmsUtill;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**************************************************
 * lib ������ �ִ� mail.jar ���� import 
 * Oracle ���� �����ϴ� JAVA mail
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
		this.props.put("mail.smtp.host", "sniper.handysoft.co.kr"); //�߼��� SMTP ����
		this.session = Session.getInstance(props);
	}
	
	
	public void sendMail() throws MessagingException {
		Message msg = new MimeMessage(this.session);
		msg.setFrom(new InternetAddress(this.from));
		InternetAddress[] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject("[����] �ڹٸ��Ϻ�����");
        msg.setSentDate(new java.util.Date());
        msg.setContent("�׽�Ʈ���Ϸ� �����ϴ�.","text/html; charset=UTF-8");
        Transport transport = this.session.getTransport("smtp");
        transport.connect(this.hostname,this.from,this.from_pwd); 
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
	}
}
