package io.prajesh.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * @author Prajesh Ananthan
 *         Created on 29/7/2017.
 */
@Data
@Entity
public class User extends AbstractDomain {

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
