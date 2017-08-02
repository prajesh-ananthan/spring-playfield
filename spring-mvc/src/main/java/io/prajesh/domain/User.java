package io.prajesh.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Prajesh Ananthan
 *         Created on 29/7/2017.
 */
@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Version
  private Integer version;

  private String userName;

  @Transient
  private String password;
  private String encryptedPassword;
  private Boolean enabled = true;

  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Customer customer;

  // cart is removed when user is deleted
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private Cart cart;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
    cart.setUser(this);
  }

  public Customer getCustomer() {
    return customer;
  }

  // Truly what makes the User and Customer bi-directional
  public void setCustomer(Customer customer) {
    this.customer = customer;
    customer.setUser(this);
  }
}
