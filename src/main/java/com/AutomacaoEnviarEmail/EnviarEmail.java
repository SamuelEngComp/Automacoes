package com.AutomacaoEnviarEmail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.stereotype.Service;

@Service
public class EnviarEmail extends Thread{

	private static String origem;
	private static String destino;
	private static String assunto;
	private static String mensagem;


	private static final String mailUsuario = "samuellima810@gmail.com";
	private static final String mailSenha = "senhapessoal";
	private static final String mailPortaSMTP = "587";
	private static final String mailHost = "smtp.gmail.com";

	synchronized public void setDestino(String origem, String destino, String assunto, String mensagem){

		this.origem = origem;
		this.destino = destino;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}

	//email simples
	synchronized public static void sendMail() {


		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", mailHost);
		prop.put("mail.smtp.port", mailPortaSMTP);
		prop.put("mail.smtp.socketFactory.port", mailPortaSMTP);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.ssl.trust", mailHost);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.debug", true);

		SimpleAuth auth = new SimpleAuth(mailUsuario, mailSenha);

		Session session = Session.getDefaultInstance(prop, auth);

		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);

		try {
			Address from = new InternetAddress(origem);
			Address to = new InternetAddress(destino);

			message.setFrom(from);
			message.addRecipient(RecipientType.TO, to);

			message.setSentDate(new Date());
			message.setSubject(assunto);

			message.setText(mensagem);
			Transport.send(message);

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	@Override
	public void run() {

		System.out.println("Thread: "+ getName() +" = "+getState());
		sendMail();

	}


}


class SimpleAuth extends Authenticator {
	
	public String username = null;
	public String password = null;
	
	public SimpleAuth(String user, String pwd) {
		username = user;
		password = pwd;
	}
	
	synchronized protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication (username,password);
	}	
}