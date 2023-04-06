package com.example.autoserviceapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "details")
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    @Id
    @GeneratedValue(generator = "details_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "details_id_seq", sequenceName = "details_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private double price;
}
