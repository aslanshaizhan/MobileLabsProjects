package kz.iitu.courseSystem.repository;


import kz.iitu.courseSystem.entities.cources.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
