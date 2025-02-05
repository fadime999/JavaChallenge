package com.fadimekaplan.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fadimekaplan.dto.DTOProduct;
import com.fadimekaplan.dto.DTOProductIU;
import com.fadimekaplan.entities.Product;
import com.fadimekaplan.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @GetMapping("/{id}")
    public DTOProduct getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }
    
    @PostMapping(path = "/create-product")
    public DTOProduct createProduct(@RequestBody DTOProductIU dtoproduct) {
        return productService.createProduct(dtoproduct);
    }

    @PutMapping("/update/{id}")
    public DTOProduct updateProduct(@PathVariable Integer id, @RequestBody  DTOProductIU dtoProductIU) {
        return productService.updateProduct(id, dtoProductIU);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}