package com.luisbicho.dscommerce.services;

import com.luisbicho.dscommerce.dto.ProductDTO;
import com.luisbicho.dscommerce.dto.ProductMinDTO;
import com.luisbicho.dscommerce.entities.Product;
import com.luisbicho.dscommerce.factory.ProductFactory;
import com.luisbicho.dscommerce.repositories.ProductRepository;
import com.luisbicho.dscommerce.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private Long existingId, nonExistingId;
    private String productName;
    private Product product;
    private List<Product> products;
    private PageImpl<Product> page;

    @BeforeEach
    public void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 2L;
        productName = "Playstation 5";
        product = ProductFactory.createProduct(productName);

        page = new PageImpl<>(List.of(product));

        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(product));
        Mockito.when(repository.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
        Mockito.when(repository.searchByName(any(), (Pageable) any())).thenReturn(page);
    }

    @Test
    public void findByIdShouldReturnProductDTOWhenIdExists() {

        ProductDTO productDTO = service.findById(existingId);

        Assertions.assertNotNull(productDTO);
        Assertions.assertEquals(productDTO.getId(), existingId);
        Assertions.assertEquals(productDTO.getName(), product.getName());

    }

    @Test
    public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });

    }

    @Test
    public void findAllShouldReturnPagedProductMinDTO() {
        Pageable pageable = PageRequest.of(0, 12);
        Page<ProductMinDTO> productDTOPage = service.findAll(productName, pageable);

        Assertions.assertNotNull(productDTOPage);
        Assertions.assertEquals(productDTOPage.getSize(), 1);
        Assertions.assertEquals(productDTOPage.iterator().next().getName(), productName);
        
    }
}
