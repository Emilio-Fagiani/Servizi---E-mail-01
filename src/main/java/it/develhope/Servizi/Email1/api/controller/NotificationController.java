package it.develhope.Servizi.Email1.api.controller;

import it.develhope.Servizi.Email1.api.DTO.NotificationDTO;
import it.develhope.Servizi.Email1.email.EmailService;
import it.develhope.Servizi.Email1.student.entity.Student;
import it.develhope.Servizi.Email1.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {


    @Autowired(required = true)
    StudentService studentService;
    @Autowired(required = true)
    EmailService emailService;

    @PostMapping
    public ResponseEntity sendNotification(@RequestBody NotificationDTO payload) {
        try {
            Student studentSendNotify = studentService.getStudentById(payload.getContactId());
            System.out.println(studentSendNotify);
            if (studentSendNotify == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");

            }
            emailService.sendTo(studentSendNotify.getEmail(), payload.getTitle(), payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
