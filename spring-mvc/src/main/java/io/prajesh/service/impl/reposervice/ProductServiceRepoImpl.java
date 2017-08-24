package io.prajesh.service.impl.reposervice;

import io.prajesh.commands.ProductForm;
import io.prajesh.constants.ProfileConfig;
import io.prajesh.converters.ProductFormToProduct;
import io.prajesh.domain.Product;
import io.prajesh.repositories.ProductRepository;
import io.prajesh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 16/8/2017.
 */
@Service
@Profile(ProfileConfig.SPRING_DATA_JPA)
public class ProductServiceRepoImpl implements ProductService {

  ProductRepository productRepository;
  ProductFormToProduct productFormToProduct;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Autowired
  public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
    this.productFormToProduct = productFormToProduct;
  }

  @Override
  public List<?> list() {
    List<Product> products = new ArrayList<>();
//    productRepository.findAll().forEach(p -> products.add(p));
    productRepository.findAll().forEach(products::add);
    return products;
  }

  @Override
  public Product findById(Integer id) {
    return productRepository.findOne(id);
  }

  @Override
  public Product saveOrUpdate(Product domainObject) {
    return productRepository.save(domainObject);
  }

  @Override
  public void remove(Integer id) {
    productRepository.delete(id);
  }

  @Override
  public Product saveOrUpdateProductForm(ProductForm productForm) {
    Product product = productFormToProduct.convert(productForm);
    return productRepository.save(product);
  }
}
