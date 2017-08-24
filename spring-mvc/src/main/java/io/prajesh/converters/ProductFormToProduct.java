package io.prajesh.converters;

import io.prajesh.commands.ProductForm;
import io.prajesh.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Prajesh Ananthan
 *         Created on 22/8/2017.
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

  @Override
  public Product convert(ProductForm productForm) {
    Product product = new Product();
    product.setId(productForm.getId());
    product.setDescription(productForm.getDescription());
    product.setImageUrl(productForm.getImageUrl());
    product.setPrice(productForm.getPrice());
    return product;
  }
}
