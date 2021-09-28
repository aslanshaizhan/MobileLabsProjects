package kz.iitu.courseSystem.repository;


import kz.iitu.courseSystem.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByPhone(String phone);
    User findByUsername(String username);
}
