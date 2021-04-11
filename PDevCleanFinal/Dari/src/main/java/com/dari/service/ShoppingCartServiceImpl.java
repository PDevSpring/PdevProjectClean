package com.dari.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dari.model.Fourniture;
import com.dari.repository.FournitureRepository;




public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	FournitureService fournitureservice;
	private FournitureRepository productRepository;
	private Map<Fourniture, Integer> products = new HashMap<>();

	@Autowired
    public ShoppingCartServiceImpl(FournitureRepository productRepository) {
        this.productRepository = productRepository;
    }

	
	@Override
    public void addProduct(Fourniture product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }
	
	 @Override
	    public void removeProduct(Fourniture product) {
	        if (products.containsKey(product)) {
	            if (products.get(product) > 1)
	                products.replace(product, products.get(product) - 1);
	            else if (products.get(product) == 1) {
	                products.remove(product);
	            }
	        }
	    }
	 @Override
	    public Map<Fourniture, Integer> getProductsInCart() {
	        return Collections.unmodifiableMap(products);
	    }
	 
	 
	   @Override
	    public String checkout( Long id) {
		   Fourniture product;
	        for (Map.Entry<Fourniture, Integer> entry : products.entrySet()) {
	    
	            product = fournitureservice.findFourniture(id);
	            if (product.getQuantity() == 0) {
	            	
	            	return(String.format("id:  %d Fourniture in stock. Only %d left", product.getFournitureId(), product.getQuantity()));
	            }
	            else {
	            	fournitureservice.BuyFourniturebyid(id);
	            }
	       
	    }
			return null;
	 
	  
	   }}
