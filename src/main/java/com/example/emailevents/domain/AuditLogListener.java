package com.example.emailevents.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuditLogListener {

    @EventListener
    @Async
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("Pedido auditado: ID={} Email={} Productos={}",
                 event.getEmail(), event.getProductos());
    }
}
