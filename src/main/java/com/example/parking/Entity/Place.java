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
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence_place", allocationSize = 1)
    private Long id;

    @Column(name = "numberPlace")
    private String numberPlace;

    @Column(name = "action")
    private String action;

    @OneToMany(mappedBy = "place")
    @JsonIgnore
    List<TimeAndPrice> places;
}
