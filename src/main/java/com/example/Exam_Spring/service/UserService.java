package com.example.Exam_Spring.service;

import com.example.Exam_Spring.entities.User;
import com.example.Exam_Spring.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepositories userRepositories;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public List<User> getAll(){
        return userRepositories.findAll();
    }

    public User createUser(User user){
        return userRepositories.save(user);
    }

    public User updateUser(Long id, User user){
        return userRepositories.findById(id)
                .map(p-> {
                    p.setName(user.getName());
                    p.setAge(user.getAge());
                    p.setSalary(user.getSalary());
                    return userRepositories.save(p);
                })
                .orElseGet(()->{
                    user.setId(id);
                    return userRepositories.save(user);
                });
    }

    public void deleteUser(Long id){
       userRepositories.deleteById(id);
    }

    public List<User> searchUser(String search){
        return userRepositories.findAllByNameContainingOrDescriptionContaining(search,search);
    }


}
