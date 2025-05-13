package com.example.emailevents.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailNotificationListener {

    private final EmailService emailService;

    public EmailNotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    @Async
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("Enviando correo a {}", event.getEmail());
        emailService.sendEmail(
                event.getEmail(),
                "Confirmación de pedido",
                "Su pedido con ID " +  " ha sido recibido."
        );
    }
}
