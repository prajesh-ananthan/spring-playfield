package io.prajesh.bootstrap;

import io.prajesh.domain.pojo.Customer;
import io.prajesh.domain.pojo.Product;
import io.prajesh.service.CustomerService;
import io.prajesh.service.ProductService;
import io.prajesh.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by ANAN011 on 27/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 *         <p>
 *         Bootstrap data for loading Customer and Product content
 */
//@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private static final String PRODUCTS_JSON_FILE = "json/products.json";
  private static final String CUSTOMERS_JSON_FILE = "json/customers.json";
  private ProductService productService;
  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    try {
      loadProducts();
      loadCustomers();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadProducts() throws IOException {
    List<Product> productList = JsonUtils.convertJsonToProductPojo(PRODUCTS_JSON_FILE);
    productList.forEach(p -> productService.saveOrUpdate(p));
  }

  private void loadCustomers() throws IOException {
    List<Customer> customerList = JsonUtils.convertJsonToCustomerPojo(CUSTOMERS_JSON_FILE);
    customerList.forEach(c -> customerService.saveOrUpdate(c));
  }
}
