package com.deploy.deploy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deploy.deploy.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}