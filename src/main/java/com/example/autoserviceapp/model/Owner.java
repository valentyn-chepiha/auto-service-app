package com.example.autoserviceapp.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "owners")
public class Owner {
    @Id
    private Long id;
    @OneToMany
    private List<Car> cars;
}
