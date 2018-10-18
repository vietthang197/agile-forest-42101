package com.levietthang.shopee.services;

import com.levietthang.shopee.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListAllProduct();
    Product saveProduct(Product product);
    Product updateProduct(Product product);
}
