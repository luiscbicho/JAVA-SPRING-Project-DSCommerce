package com.luisbicho.dscommerce.services;

import com.luisbicho.dscommerce.dto.CategoryDTO;
import com.luisbicho.dscommerce.entities.Category;
import com.luisbicho.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }

}
