package com.example.autoserviceapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
