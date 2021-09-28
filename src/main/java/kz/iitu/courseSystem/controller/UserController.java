package kz.iitu.courseSystem.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.courseSystem.entities.users.User;
import kz.iitu.courseSystem.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@Api(value = "User Controller")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @ApiOperation(value = "List of users")
    @GetMapping("")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @ApiOperation(value = "User by id")
    @GetMapping("/byId/{id}")
    public User userById(@RequestParam Long id){
        return userService.findUserById(id);
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        if (id == null){
            throw new NullPointerException("id must not be null");
        }
        userService.deleteUser(id);
    }

    @ApiOperation(value = "User by name")
    @GetMapping("/username/{name}")
    public User userByName(@PathVariable String username){
        return userService.getByUsername(username);
    }

    //checked
    @ApiOperation(value = "Add new user")
    @PostMapping("/signUp")
    public void newUser(@RequestBody User user) {
       User user1 = userService.getByUsername(user.getUsername());
       if (user1 != null){
           throw new RuntimeException("With this " + user.getUsername() + " is exist");
       }
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            throw new RuntimeException("username and password should not be empty");
        }

        userService.newUser(user);
    }

}
