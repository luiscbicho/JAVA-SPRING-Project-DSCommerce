package com.luisbicho.dscommerce.repositories;

import com.luisbicho.dscommerce.entities.OrderItem;
import com.luisbicho.dscommerce.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
