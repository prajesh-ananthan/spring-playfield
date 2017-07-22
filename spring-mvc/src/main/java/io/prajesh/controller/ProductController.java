package io.prajesh.controller;

import io.prajesh.domain.Product;
import io.prajesh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */

@Controller
public class ProductController {

  private static final String ERROR_PAGE = "error/404";
  private static final String PRODUCT = "product";
  private static final String PRODUCT_FORM = "product-form";
  private static final String PRODUCTS = "products";
  private static final String REDIRECT_PRODUCT = "redirect:/product/";
  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/products")
  public String listProducts(Model model) {
    model.addAttribute("products", productService.listProducts());
    return PRODUCTS;
  }

  @RequestMapping("/product/{id}")
  public String findProductById(@PathVariable Integer id, Model model) {
    Product product = productService.getProductById(id);
    if (product != null) {
      model.addAttribute("product", product);
      return PRODUCT;
    }
    return ERROR_PAGE;
  }

  @RequestMapping("/product/new")
  public String createNewProduct(Model model) {
    model.addAttribute("product", new Product());
    return PRODUCT_FORM;
  }

  @RequestMapping("/product/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Product product = productService.getProductById(id);
    model.addAttribute("product", product);
    return PRODUCT_FORM;
  }

  @RequestMapping(value = "/product", method = RequestMethod.POST)
  public String createOrUpdateProduct(Product product) {
    Product savedProduct = productService.saveOrUpdateProduct(product);
    return REDIRECT_PRODUCT + savedProduct.getId();
  }
}
