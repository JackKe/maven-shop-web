package cn.likegirl.shop.utils;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


/**
 * 邮件发送类
 * @author CK_BOY
 *
 */
public class EmailUtils {
	/**
	 * 发送邮件的方法
	 * @param to ：接受的人
	 * @param code ：激活码
	 */
	public static void sendEmail(String to,String code){
		/**
		 * 1.获得一个Session 对象
		 * 2.创建一个代表邮件的对象Message
		 * 3.发送邮件Transport
		 */
		try {
			// tep:1   获得连接对象
			Properties props = new Properties();
			//配置本地发送邮件
		    //props.setProperty("mail.host", "localhost"); 
			//props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.port", "25");
			props.setProperty("mail.transport.protocol", "smtp");
			//props.setProperty("mail.smtp.socketFactory.port", "465");
	        props.setProperty("mail.smtp.host", "smtp.sina.com");
			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication("ckboy193@sina.com", "ck7388662");
				}		
			});
			// tep:2 创建邮箱对象
			Message message = new MimeMessage(session);
			//  tep:3  设置发件人
			message.setFrom(new InternetAddress("ckboy193@sina.com"));
			// tep 4:设置收件人
				message.addRecipient(RecipientType.TO, new InternetAddress(to));
				
		    // tep 5: 设置标题
				message.setSubject("来自购物天堂官方激活邮件！");
			// tep 6: 设置正文
				
				message.setContent("<h1>购物天堂官方激活邮件！点此链接完成激活操作！</h1><h3><a href='http://localhost:8080/SSH_Shop/user/active.action?code="+code+"'>http://localhost:8080/SSH_Shop/user/active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
				
	    	// tep :7 发送邮件
				Transport.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/*@Test
	public void send(){
		System.out.println("begin");
		sendEmail("605336558@qq.com", "132456");
		System.out.println("end");
	}*/

}
