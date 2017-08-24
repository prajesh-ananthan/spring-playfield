package io.prajesh.converters;

import io.prajesh.commands.ProductForm;
import io.prajesh.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Prajesh Ananthan
 *         Created on 24/8/2017.
 */
@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
  @Override
  public ProductForm convert(Product product) {
    ProductForm productForm = new ProductForm();
    productForm.setId(product.getId());
    productForm.setVersion(product.getVersion());
    productForm.setDescription(product.getDescription());
    productForm.setPrice(product.getPrice());
    productForm.setImageUrl(product.getImageUrl());
    return productForm;
  }
}
