package com.vinicius.cursospring.repositories;

import com.vinicius.cursospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
