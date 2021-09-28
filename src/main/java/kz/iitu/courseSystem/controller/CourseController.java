package kz.iitu.courseSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.courseSystem.entities.cources.Course;
import kz.iitu.courseSystem.repository.CourseRepository;
import kz.iitu.courseSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/courseList")
    public List<Course> courseList(){
        return courseRepository.findAll();
    }

    @GetMapping("/allCourses")
    public String allCourses(Model model){
        model.addAttribute("cou",courseList());
        return "courses";
    }

    @ApiOperation(value = "Add new course")
    @PostMapping("/newCourse")
    public String newCourse(@RequestBody Course course){
        courseRepository.save(course);
        return course.toString();
    }

    @ApiOperation(value = "Update course")
    @PostMapping("/update")
    public String updateCourse(@RequestBody Course course){
        courseRepository.save(course);
        return course.toString();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        userService.deleteCourse(id);
    }



}
