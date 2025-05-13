package com.example.emailevents.domain;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
public class OrderCreatedEvent extends ApplicationEvent {

    private final String email;
    private final List<String> productos;

    public OrderCreatedEvent(Object source, String email, List<String> productos) {
        super(source);
        this.email = email;
        this.productos = productos;
    }
}