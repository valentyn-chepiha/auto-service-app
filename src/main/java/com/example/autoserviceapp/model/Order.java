package com.example.autoserviceapp.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    @OneToOne
    private Car car;
    private String description;
    @Column(name = "date_start")
    private LocalDate dateStart;
    @OneToMany
    private List<Service> services;
    @OneToMany
    private List<Detail> details;
    @Enumerated(EnumType.STRING)
    private StatusService status;
    private double total;
    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Getter
    @AllArgsConstructor
    public enum StatusService {
        ACCEPTED("Accepted"),
        PROCESSING("Processing"),
        DONE("Done"),
        FAIL("Fail"),
        PAID("Paid");

        private String name;
    }
}
