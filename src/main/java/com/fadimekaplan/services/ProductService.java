package com.fadimekaplan.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadimekaplan.dto.DTOProduct;
import com.fadimekaplan.dto.DTOProductIU;
import com.fadimekaplan.entities.Product;
import com.fadimekaplan.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService implements IProductService{
	
	 @Autowired
	  private ProductRepository productRepository;
	 
	  public DTOProduct getProduct(Integer id) {
	      DTOProduct dto_product = new DTOProduct();
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Order not found")); 
	        BeanUtils.copyProperties(product, dto_product);
	        return dto_product;
	    }

	  @Transactional
	  public DTOProduct createProduct(DTOProductIU dtoproduct) {
	         Product product = new Product();
	         DTOProduct responseproduct = new DTOProduct();
			 BeanUtils.copyProperties(dtoproduct, product);
			 
			 Product dbproduct = productRepository.save(product);
			 BeanUtils.copyProperties(dbproduct, responseproduct);
		      return responseproduct;
	  }
	  
	    public DTOProduct updateProduct(Integer id, DTOProductIU dtoProductIU) {
	    	Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	        existingProduct.setProductName(dtoProductIU.getProductName());
	        existingProduct.setPrice(dtoProductIU.getPrice());
	        existingProduct.setStockQuantity(dtoProductIU.getStockQuantity());
	        
	        Product updatedProduct = productRepository.save(existingProduct);
	        
	        // DTO'ya dönüştürme
	        DTOProduct dtoProduct = new DTOProduct();
	        BeanUtils.copyProperties(updatedProduct, dtoProduct);
	        
	        return dtoProduct;
	    }

	    public void deleteProduct(Integer id) {
	        productRepository.deleteById(id);
	    }
	  
}
