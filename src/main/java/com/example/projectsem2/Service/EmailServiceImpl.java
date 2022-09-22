package com.example.projectsem2.Service;

import com.example.projectsem2.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class EmailServiceImpl implements EmailService  {

    @Value("${spring.mail.username}") private String sender;

    @Autowired
    public JavaMailSender javaMailSender;
///
    @Override
    public Object sendSimpleEmail(EmailDetails emailDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        message.setTo(currentPrincipalName);
        message.setSubject(emailDetails.getTitle());
        message.setText(emailDetails.getMsgBody());
        this.javaMailSender.send(message);
        return message;
    }



//    @Autowired
//    public String sendSimpleMail(EmailDetails details)
//    {
//
//        try {
//
//            SimpleMailMessage mailMessage
//                    = new SimpleMailMessage();
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String currentPrincipalName = authentication.getName();
//            mailMessage.setFrom(sender);
//            mailMessage.setTo(currentPrincipalName);
//            mailMessage.setText(details.getMsgBody());
//            mailMessage.setSubject(details.getTitle());
//
//            // Sending the mail
//            javaMailSender.send(mailMessage);
//            return "Mail Sent Successfully...";
//        }
//
//        // Catch block to handle the exceptions
//        catch (Exception e) {
//            return "Error while Sending Mail";
//        }
//    }

    @Override
    public String sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getTitle());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}
