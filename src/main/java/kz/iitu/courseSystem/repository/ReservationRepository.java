package kz.iitu.courseSystem.repository;


import kz.iitu.courseSystem.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
