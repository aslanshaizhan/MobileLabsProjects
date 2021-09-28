package kz.iitu.courseSystem.service;



import kz.iitu.courseSystem.entities.users.User;

import java.util.List;

public interface UserService {
    void login();
    List<User> getAllUsers();
    void deleteUser(Long id);
    void deleteCourse(Long id);
    User findUserById(Long id);
    void newUser(User user);
    User getByUsername(String usernmae);
}
