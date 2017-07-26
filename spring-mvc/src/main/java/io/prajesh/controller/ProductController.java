package io.prajesh.controller;

import com.google.common.annotations.VisibleForTesting;
import io.prajesh.domain.pojo.Product;
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

  @VisibleForTesting
  static final String ERROR_PAGE = "error/404";
  @VisibleForTesting
  static final String PRODUCT = "product";
  @VisibleForTesting
  static final String PRODUCTS = "products";
  @VisibleForTesting
  static final String PRODUCT_PAGE = PRODUCT + "/" + PRODUCT;
  @VisibleForTesting
  static final String PRODUCTS_PAGE = PRODUCT + "/" + PRODUCTS;
  @VisibleForTesting
  static final String REDIRECT_PRODUCTS = "redirect:/" + PRODUCTS + "/";
  @VisibleForTesting
  static final String REDIRECT_PRODUCT_PAGE = "redirect:/" + PRODUCT + "/";

  private static final String PRODUCT_FORM = PRODUCT + "/product-form";
  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/products")
  public String listProducts(Model model) {
    model.addAttribute("products", productService.list());
    return PRODUCTS_PAGE;
  }

  @RequestMapping("/product/{id}")
  public String findProductById(@PathVariable Integer id, Model model) {
    Product product = productService.findById(id);
    if (product != null) {
      model.addAttribute("product", product);
      return PRODUCT_PAGE;
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
    Product product = productService.findById(id);
    model.addAttribute("product", product);
    return PRODUCT_FORM;
  }

  @RequestMapping("/product/remove/{id}")
  public String delete(@PathVariable Integer id, Model model) {
    productService.remove(id);
    return REDIRECT_PRODUCTS;
  }

  @RequestMapping(value = "/product", method = RequestMethod.POST)
  public String createOrUpdateProduct(Product product) {
    Product savedProduct = productService.saveOrUpdate(product);
    return REDIRECT_PRODUCT_PAGE + savedProduct.getId();
  }
}
