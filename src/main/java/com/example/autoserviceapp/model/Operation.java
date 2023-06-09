package com.example.autoserviceapp.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "operations")
@RequiredArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(generator = "operations_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "operations_id_seq",
            sequenceName = "operations_id_seq",
            allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "master_id", nullable = false)
    private Master master;
    private BigDecimal cost;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_paid")
    private StatusPaid status;

    @Getter
    @AllArgsConstructor
    public enum StatusPaid {
        PAID("paid"),
        NOT_PAID("not_paid");

        private String name;
    }
}
