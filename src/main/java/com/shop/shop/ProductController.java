package com.shop.shop;

import com.shop.shop.model.ProductDto;
import com.shop.shop.service.Productmanager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final Productmanager productmanager;


    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto){
        productmanager.productAdd(productDto);
    }
    @GetMapping("/getall")
    public List<ProductDto> getProducts(){
        return productmanager.getAllProducts();
    }
}
