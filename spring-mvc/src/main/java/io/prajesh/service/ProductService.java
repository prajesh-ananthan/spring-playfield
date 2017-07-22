package io.prajesh.service;

import io.prajesh.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */
@Service
public interface ProductService {
  List<Product> listProducts();

  Product getProductById(Integer id);

  Product saveOrUpdateProduct(Product product);

  void removeProductById(Integer id);
}
