package io.prajesh.controller;

import io.prajesh.domain.Product;
import io.prajesh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */

@Controller
public class ProductController {

  ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/products")
  public String listProducts(Model model) {
    model.addAttribute("products", productService.listProducts());
    return "products";
  }

  @RequestMapping("/product/{id}")
  public String findProductById(@PathVariable Integer id, Model model) {
    Product product = productService.getProductById(id);
    if (product != null) {
      model.addAttribute("product", product);
      return "product";
    }
    return "error/404";
  }
}
