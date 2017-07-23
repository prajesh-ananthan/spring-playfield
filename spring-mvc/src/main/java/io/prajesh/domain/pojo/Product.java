package io.prajesh.domain.pojo;

import io.prajesh.domain.DomainObject;

import java.math.BigDecimal;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */
public class Product implements DomainObject {
  private Integer id;
  private String description;
  private BigDecimal price;
  private String imageUrl;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", imageUrl='" + imageUrl + '\'' +
        '}';
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}