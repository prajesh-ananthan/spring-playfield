package io.prajesh.service.impl;

import io.prajesh.domain.pojo.Product;
import io.prajesh.service.AbstractMapService;
import io.prajesh.service.ProductService;
import io.prajesh.util.JsonUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */
@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

  private static final String PRODUCTS_JSON_FILE = "json/products.json";

  public ProductServiceImpl() throws IOException {
  }

  @Override
  protected void loadDomainObjectsFromJSON() throws IOException {
    List<Product> productList = JsonUtils.convertJsonToProductPojo(PRODUCTS_JSON_FILE);
    domainMap = productList.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
  }

  @Override
  public List<?> list() {
    return super.listAll();
  }

  @Override
  public Product findById(Integer id) {
    return (Product) super.getById(id);
  }

  @Override
  public Product saveOrUpdate(Product domainObject) {
    return (Product) super.saveOrUpdate(domainObject);
  }

  @Override
  public void remove(Integer id) {
    super.delete(id);
  }
}