package com.example.autoserviceapp.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "masters")
public class Master {
    @Id
    private Long id;
    private String pib;
    @ManyToMany
    private List<Order> orders;
}
