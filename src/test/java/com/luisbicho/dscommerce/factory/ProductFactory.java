package com.luisbicho.dscommerce.factory;

import com.luisbicho.dscommerce.entities.Category;
import com.luisbicho.dscommerce.entities.Product;

public class ProductFactory {

    public static Product createProduct() {
        Category category = CategoryFactory.createCategory();
        Product product = new Product(1L, "Console Playstation 5", "TOP DE GAMA", 500.50, "www.playstation.com");
        product.getCategories().add(category);
        return product;
    }

    public static Product createProduct(String name) {
        Product product = createProduct();
        product.setName(name);
        return product;
    }

}
