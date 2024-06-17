package com.github.lu_backend.repository;

import com.github.lu_backend.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
    Optional<Student> findByUsername(String username);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByUsernameAndPassword(String username, String password);
    Optional<Student> findByEmailAndPassword(String email, String password);
}
