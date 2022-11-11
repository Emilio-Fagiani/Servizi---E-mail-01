package it.develhope.Servizi.Email1.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendTo(String contactId, String title,String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(contactId);
        simpleMailMessage.setFrom("rugdece85@gmail.com");
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
    }

