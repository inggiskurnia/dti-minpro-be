package com.miniproject.eventure.entity.geography;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provinces_id_gen")
    @SequenceGenerator(name = "provinces_id_gen", sequenceName = "provinces_province_id_seq", allocationSize = 1)
    @Column(name = "province_id", nullable = false)
    private Long id;

    @Column(name= "name", nullable = false, length = 100)
    private String name;
}
