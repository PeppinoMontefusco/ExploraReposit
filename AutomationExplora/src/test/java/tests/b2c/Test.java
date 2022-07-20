package tests.b2c;
import java.io.IOException;
import java.util.List;

import tests.b2c.*;

public class Test {
	
	public static void main(String[] args) {
		
		final String myYopMail = "paolino@yopmail.com";
		
		final YopmailReader yopmailReader = YopmailReader.getInstance();
		
		try {
			// Getting the content of the lastmail received
			final String lastMailContent = yopmailReader.getLastMailContent(myYopMail);
			System.out.println("Last email content: " );
			System.out.println(lastMailContent);
			// Getting the first 15 received mails
			List<Mail> listMail = yopmailReader.getIncomingMailList(myYopMail);
			for(final Mail mail : listMail){
				System.out.println("Mail from: " + mail.getSender());
				System.out.println("Mail subject: " + mail.getSubject());
				System.out.println("Mail content: ");
				System.out.println(yopmailReader.getMailContent(mail));
			}
			final int page = 2;
			// Getting the next 15 received mails (page 2)
			listMail = yopmailReader.getIncomingMailList(myYopMail, page);
			for(final Mail mail : listMail){
				System.out.println("Mail from: " + mail.getSender());
				System.out.println("Mail subject: " + mail.getSubject());
				System.out.println("Mail content: ");
				System.out.println(yopmailReader.getMailContent(mail));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}