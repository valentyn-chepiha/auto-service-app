package com.example.autoserviceapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "owners")
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(generator = "owner_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "owner_id_seq", sequenceName = "owner_id_seq", allocationSize = 1)
    private Long id;
    @OneToMany
    private List<Car> cars;
    /*
    *
    1) https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
    2) https://www.bezkoder.com/jpa-one-to-many/
    3) https://www.baeldung.com/hibernate-one-to-many
    * */
}
