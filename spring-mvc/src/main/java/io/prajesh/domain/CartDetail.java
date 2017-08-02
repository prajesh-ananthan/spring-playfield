package io.prajesh.domain;

import javax.persistence.*;

/**
 * @author Prajesh Ananthan
 *         Created on 1/8/2017.
 */
@Entity
public class CartDetail {

  @ManyToOne
  private Cart cart;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Version
  private Integer version;

  @OneToOne
  private Product product;

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
