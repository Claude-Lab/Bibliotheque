/**
 * 
 */
package fr.lusseau.bibliotheque.configuration;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 12:55:13
 * @author Claude LUSSEAU
 *
 */
public class MailSender {
	
	@Autowired
    private JavaMailSender javaMailSender; 
    
    public void sendMail(String to, String subject, String text) throws MailException {
//      MimeMessage message = null;
	//... créer ici l'objet message (de type SimpleMailMessage ou MimeMessage) à envoyer
      SimpleMailMessage message = new SimpleMailMessage(); 
      message.setFrom("noreply@baeldung.com");
      message.setTo(to); 
      message.setSubject(subject); 
      message.setText(text);
      javaMailSender.send(message);
    }

}
