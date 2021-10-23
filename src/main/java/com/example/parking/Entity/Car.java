package com.example.parking.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "nameCar")
    private String nameCar;

    @Column(name = "numberCar")
    private String numberCar;

    @Column(name = "numberPlace")
    private int numberPlace;

}
