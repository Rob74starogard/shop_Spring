package com.shop.shop;

import com.shop.shop.model.ProductDto;
import com.shop.shop.repository.ProductRepository;
import com.shop.shop.service.Productmanager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final Productmanager productmanager;
    private final ProductRepository productRepository;

    /*@PostMapping
    public void addProduct(@RequestBody ProductEntity productEntity){
        productRepository.save(productEntity);
    }*/

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto){
        productmanager.productAdd(productDto);
    }
}
