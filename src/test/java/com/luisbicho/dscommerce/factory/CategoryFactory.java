package com.luisbicho.dscommerce.factory;

import com.luisbicho.dscommerce.entities.Category;

public class CategoryFactory {

    public static Category createCategory() {
        return new Category(1L, "Games");
    }

    public static Category createCategory(Long Id, String name) {
        return new Category(Id, name);
    }

}
