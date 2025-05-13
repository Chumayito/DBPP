package com.example.emailevents.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    @Lob
    private String productos; // Guardamos como texto separado por comas
}