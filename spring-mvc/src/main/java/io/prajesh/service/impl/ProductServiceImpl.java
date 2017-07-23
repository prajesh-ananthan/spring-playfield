package io.prajesh.service.impl;

import io.prajesh.domain.Product;
import io.prajesh.service.ProductService;
import io.prajesh.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

  private static final String PRODUCTS_JSON_FILE = "json/products.json";
  private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
  private Map<Integer, Product> products;

  public ProductServiceImpl() throws IOException {
    loadProducts();
  }

  @Override
  public Product getProductById(Integer id) {
    for (Product product : products.values()) {
      if (id == product.getId()) {
        return product;
      }
    }
    LOG.error("Product not found!");
    return null;
  }

  @Override
  public Product saveOrUpdateProduct(Product product) {
    if (product != null) {
      if (product.getId() == null) {
        product.setId(getNextKey());
      }
      products.put(product.getId(), product);
    } else {
      LOG.error("Product cannot be null!");
      throw new RuntimeException("Product cannot be null!");
    }
    return product;
  }

  @Override
  public void removeProductById(Integer id) {
    for (Product product : products.values()) {
      if (id == product.getId()) {
        products.remove(product.getId());
        return;
      }
    }
  }

  @Override
  public List<Product> listProducts() {
    return new ArrayList<>(products.values());
  }

  private Integer getNextKey() {
    if (!CollectionUtils.isEmpty(products.keySet())) {
      return Collections.max(products.keySet()) + 1;
    }
    return 1;
  }

  private void loadProducts() throws IOException {
    List<Product> productList = JsonUtils.convertJsonToProductPojo(PRODUCTS_JSON_FILE);
    products = productList.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
  }
}