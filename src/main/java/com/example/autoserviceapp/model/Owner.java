package com.example.autoserviceapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "owners")
@NoArgsConstructor
@RequiredArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(generator = "owners_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "owners_id_seq", sequenceName = "owners_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Car> cars;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Order> orders;
}
