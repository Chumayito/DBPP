package com.example.emailevents.domain;

import com.example.emailevents.domain.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public Map<String, Object> processOrder(String email, List<String> productos) {
        publisher.publishEvent(new OrderCreatedEvent(this, email, productos));

        // Log opcional para mostrar acción en consola
        log.info("Pedido recibido de {} con {} productos.", email, productos.size());

        // Retornar información como respuesta
        return Map.of(
                "mensaje", "El correo se ha enviado.",
                "cantidadProductos", productos.size(),
                "productos", productos
        );
    }
}