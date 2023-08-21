package com.victorsaccucci.Sistemaorquidarioprojeto.repositories;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE email = :email and password = :password", nativeQuery = true)
    public User Login(String email, String password);

}
