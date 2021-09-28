package kz.iitu.courseSystem.entities.cources;

import kz.iitu.courseSystem.entities.Building;
import kz.iitu.courseSystem.entities.Reservation;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "cources")
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean isAvailable = true;
    private CourseType courseType;
    private int price;
    private String pathImg;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToOne(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reservation reservation;
}
