package com.example.Exam_Spring.repositories;
import com.example.Exam_Spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
    List<User> findAllByNameContaining(String name);
    List<User> findAllByNameContainingOrDescriptionContaining(String search,String name);
}
