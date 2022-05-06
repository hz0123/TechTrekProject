package com.techtrek5.zihengBackend.authentication.registration.email;

import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    @Async
    public void send(String to, String emailBody){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText(emailBody);
            simpleMailMessage.setSubject("Click to confirm email");
            javaMailSender.send(simpleMailMessage);
        }catch (MailException mailException){
            throw new IllegalStateException("Failed to send email");
        }
    }
}
