package io.prajesh.controller;

import com.google.common.annotations.VisibleForTesting;
import io.prajesh.commands.ProductForm;
import io.prajesh.converters.ProductToProductForm;
import io.prajesh.domain.Product;
import io.prajesh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */

@Controller
@RequestMapping("/product")
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

  private static final String PRODUCT_FORM_PAGE = PRODUCT + "/product-form";
  private static final String PRODUCT_FORM = "productForm";
  private ProductService productService;
  private ProductToProductForm productToProductForm;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @Autowired
  public void setProductToProductForm(ProductToProductForm productToProductForm) {
    this.productToProductForm = productToProductForm;
  }

  @GetMapping("/list")
  public String listProducts(Model model) {
    model.addAttribute(PRODUCTS, productService.list());
    return PRODUCTS_PAGE;
  }

  @GetMapping("/{id}")
  public String findProductById(@PathVariable Integer id, Model model) {
    Product product = productService.findById(id);
    if (product != null) {
      model.addAttribute(PRODUCT, product);
      return PRODUCT_PAGE;
    }
    return ERROR_PAGE;
  }

  @GetMapping("/new")
  public String createNewProduct(Model model) {
    model.addAttribute(PRODUCT_FORM, new Product());
    return PRODUCT_FORM_PAGE;
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Product product = productService.findById(id);
    ProductForm productForm = productToProductForm.convert(product);
    model.addAttribute(PRODUCT_FORM, productForm);
    return PRODUCT_FORM_PAGE;
  }

  @GetMapping(value = "/remove/{id}")
  public String delete(@PathVariable Integer id, Model model) {
    productService.remove(id);
    return REDIRECT_PRODUCTS;
  }

  @PostMapping
  public String saveOrUpdate(@Valid ProductForm productForm, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return PRODUCT_FORM_PAGE;
    }

    Product savedProduct = productService.saveOrUpdateProductForm(productForm);
    return REDIRECT_PRODUCT_PAGE + savedProduct.getId();
  }
}
