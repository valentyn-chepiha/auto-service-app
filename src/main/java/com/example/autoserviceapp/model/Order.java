package com.example.autoserviceapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "orders")
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(generator = "orders_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_id_seq", allocationSize = 1)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "car_id")
    private Car car;
    private String description;
    @Column(name = "date_start")
    private LocalDate dateStart;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Operation> operations;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "detail_id"))
    private List<Detail> details;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_paid")
    private StatusService status;
    private BigDecimal total;
    @Column(name = "date_end")
    private LocalDate dateEnd;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

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
