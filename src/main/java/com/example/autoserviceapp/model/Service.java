package com.example.autoserviceapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "services")
public class Service {
    @Id
    private Long id;
    @OneToOne
    private Master master;
    private double cost;
    @Enumerated(EnumType.STRING)
    private StatusPaid status;

    @Getter
    @AllArgsConstructor
    public enum StatusPaid {
        PAID("Paid"), NOT_PAID("not_paid");

        private String name;
    }
}
