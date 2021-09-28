package kz.iitu.courseSystem.entities;

import kz.iitu.courseSystem.entities.cources.Course;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<Course> courses;


}
