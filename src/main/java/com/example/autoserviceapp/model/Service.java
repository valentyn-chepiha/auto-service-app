package com.example.autoserviceapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    private Long id;
//    todo:
//    private Long order_id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "master_id", nullable = false)
    private Master master;
    private double cost;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_paid")
    private StatusPaid status;

    @Getter
    @AllArgsConstructor
    public enum StatusPaid {
        PAID("Paid"), NOT_PAID("not_paid");

        private String name;
    }
}
