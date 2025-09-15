package com.akul.microservices.notification.service;

import com.akul.microservices.order.event.OrderPlacedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * NotificationService.java
 *
 * @author Andrii Kulynch
 * @version 1.0
 * @since 9/14/2025
 */
@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender mailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent) {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
            messageHelper.setFrom("from@example.com ");
            messageHelper.setTo(orderPlacedEvent.getEmail().toString());
            messageHelper.setSubject(String.format("Your Order with OrderNbr %s placed successfully", orderPlacedEvent.getOrderNbr()));
            messageHelper.setText(String.format("""
                            Hi, %s %s
                            
                            Your Order with OrderNbr %s placed successfully.
                            
                            Best Regards
                            Cloud Shop
                            """,
                    orderPlacedEvent.getFirstName(),
                    orderPlacedEvent.getLastName(),
                    orderPlacedEvent.getOrderNbr()));
            log.info("Order Notification email sent !!!");
        };
        try {
            mailSender.send(messagePreparator);
        }catch (MailException e) {
            log.error("Exception sending email",e);
            throw new RuntimeException("Exception while sending email to springshop@email.com",e);
        }

    }
}
