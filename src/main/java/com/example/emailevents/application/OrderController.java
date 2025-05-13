package com.example.emailevents.application;

import com.example.emailevents.domain.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Map<String, Object> request) {
        String email = (String) request.get("email");
        List<String> productos = (List<String>) request.get("productos");

        Map<String, Object> response = orderService.processOrder(email, productos);
        return ResponseEntity.ok(response);
    }
}