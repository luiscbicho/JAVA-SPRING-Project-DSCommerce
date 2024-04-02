package com.luisbicho.dscommerce.services;

import com.luisbicho.dscommerce.dto.OrderDTO;
import com.luisbicho.dscommerce.dto.OrderItemDTO;
import com.luisbicho.dscommerce.entities.Order;
import com.luisbicho.dscommerce.entities.OrderItem;
import com.luisbicho.dscommerce.entities.Product;
import com.luisbicho.dscommerce.entities.User;
import com.luisbicho.dscommerce.entities.enums.OrderStatus;
import com.luisbicho.dscommerce.repositories.OrderItemRepository;
import com.luisbicho.dscommerce.repositories.OrderRepository;
import com.luisbicho.dscommerce.repositories.ProductRepository;
import com.luisbicho.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new OrderDTO(order);

    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);
        for (OrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);

    }
}
