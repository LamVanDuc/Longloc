package com.example.projectsem2.Service;

import com.example.projectsem2.dto.EmailDetails;

public interface EmailService {

    Object sendSimpleEmail(EmailDetails emailDetails);

//    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);

}
