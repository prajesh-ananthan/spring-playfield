package io.prajesh.domain.pojo;

import io.prajesh.domain.DomainObject;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */
@Entity
public class Product implements DomainObject {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Version
  private Integer version;
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

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
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