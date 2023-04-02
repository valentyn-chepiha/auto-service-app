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
@Getter
@Setter
@Table(name = "masters")
@NoArgsConstructor
@AllArgsConstructor
public class Master {
    @Id
    @GeneratedValue(generator = "masters_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "masters_id_seq", sequenceName = "masters_id_seq", allocationSize = 1)
    private Long id;
    private String pib;
}
