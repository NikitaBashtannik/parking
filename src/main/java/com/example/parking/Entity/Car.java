package com.example.parking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence_car", allocationSize = 1)
    private Long id;

    private String name;

    private String number;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    @JsonIgnore
    List<TimeAndPrice> link;

}
