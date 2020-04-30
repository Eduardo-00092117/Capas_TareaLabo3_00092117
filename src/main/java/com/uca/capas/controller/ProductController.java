package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class ProductController {

	private List<Product> products = new ArrayList<Product>();
	
	@GetMapping("/producto")
	public ModelAndView producto() {
		ModelAndView mav = new ModelAndView();
		
		products.clear();
		
		products.add(new Product(0, "WWZ", "20"));
		products.add(new Product(1, "Paladins", "15"));
		products.add(new Product(2, "GRID 2", "5"));
		products.add(new Product(3, "Tomb Raider", "60"));
		products.add(new Product(4, "Dirt 3", "34"));
		products.add(new Product(5, "Left 4 Dead 2", "42"));
		
		mav.setViewName("productos");
		mav.addObject("producto", products);
		mav.addObject("product", new Product());
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mav = new ModelAndView();
		
		if(Integer.parseInt(products.get(producto.getId()).getCantidad()) >= Integer.parseInt(producto.getCantidad())) {
			mav.setViewName("compra"); 
		} else {
			mav.setViewName("error");
		}
		
		mav.addObject("nombre", products.get(producto.getId()).getNombre());
		
		return mav;
	}
	
}
