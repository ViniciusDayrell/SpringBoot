package com.vinicius.cursospring.repositories;

import com.vinicius.cursospring.entities.Order;
import com.vinicius.cursospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
