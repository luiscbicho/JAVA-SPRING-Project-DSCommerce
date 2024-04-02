package com.luisbicho.dscommerce.repositories;

import com.luisbicho.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
