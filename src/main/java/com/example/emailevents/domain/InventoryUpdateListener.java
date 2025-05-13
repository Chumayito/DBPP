package com.example.emailevents.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class InventoryUpdateListener {

    private static int stock = 10;

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        int cantidadProductos = event.getProductos().size();
        stock -= cantidadProductos;

        log.info("Se han vendido {} productos.", cantidadProductos);
        log.info("Stock restante: {}", stock);
    }
}