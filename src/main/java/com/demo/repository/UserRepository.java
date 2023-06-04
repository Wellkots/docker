package com.demo.repository;


import com.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u join fetch u.roles where u.username= :email")
    User findByUsername(String email);


    Optional<User> findById(Long id);


    void deleteById(Long id);
}
