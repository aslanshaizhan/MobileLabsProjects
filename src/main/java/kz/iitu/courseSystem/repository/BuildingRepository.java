package kz.iitu.courseSystem.repository;


import kz.iitu.courseSystem.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {

}
