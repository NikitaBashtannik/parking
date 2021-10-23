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
@Table(name = "timeandprice")
public class TimeAndPrice {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "timePlace")
    private String timePlace;

    @Column(name = "pricePlace")
    private String pricePlace;

    @Column(name = "idCar")
    private Long idCar;

    @Column(name = "idPlace")
    private Long idPlace;
}
