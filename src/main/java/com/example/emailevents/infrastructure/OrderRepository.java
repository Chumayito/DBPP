package com.example.emailevents.infrastructure;


import com.example.emailevents.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
