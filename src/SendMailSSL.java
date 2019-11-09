import java.util.Properties;

import javax.mail.*;

import javax.mail.internet.*;

 

public class SendMailSSL {

	Properties props;

	Session session;

	Message message;

	

	public SendMailSSL(final String username, final String password){

		

		props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.socketFactory.port", "465");

		props.put("mail.smtp.socketFactory.class",

				"javax.net.ssl.SSLSocketFactory");

		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.port", "465");

		

		 session = Session.getDefaultInstance(props,

			new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

			                     return new PasswordAuthentication(username,password); 				                          }

			});	 	 

	}

	

	public void sendMail(String from, String to, String subject, String content){

                     try {		 

		message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));


		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); 			

		message.setSubject(subject);

		message.setText(content);

 

		Transport.send(message);

		

System.out.println("Done");

	      } catch (MessagingException e) { throw new RuntimeException(e); }

	}

//main for the check if its work
	public static void main(String[] args) {	

		SendMailSSL mail=new SendMailSSL("liorkatz100","password");

		mail.sendMail("liorkatz100@gmail.com", "liorkatz100@gmail.com", "gym", "content of mail");		

	}

}