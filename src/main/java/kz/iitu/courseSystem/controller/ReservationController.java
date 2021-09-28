package kz.iitu.courseSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.courseSystem.entities.cources.Course;
import kz.iitu.courseSystem.entities.Reservation;
import kz.iitu.courseSystem.entities.users.User;
import kz.iitu.courseSystem.repository.CourseRepository;
import kz.iitu.courseSystem.repository.ReservationRepository;
import kz.iitu.courseSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@Api(value = "Reservation Controller")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<Reservation> reservationList(){
        return reservationRepository.findAll();
    }


    @ApiOperation(value = "By course")
    @PostMapping("/{courseId}/{userId}")
    public void setReservation( @PathVariable Long courseId, @PathVariable Long userId){
        LocalDate date = LocalDate.now();
        Course course = courseRepository.findById(courseId).get();
        User user = userRepository.findById(userId).get();
        Reservation reservation = new Reservation();
        course.setIsAvailable(true);
        reservation.setCourse(course);
        reservation.setDate(date);
        reservation.setIsValid(true);
        reservation.setUser(user);
        reservationRepository.save(reservation);
        courseRepository.save(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        if (id == null){
            throw new NullPointerException("id must not be null");
        }
        reservationRepository.deleteById(id);
    }
}
