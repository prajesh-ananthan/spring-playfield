package io.prajesh.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 1/8/2017.
 */

@Entity
public class Cart implements DomainObject {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Version
  private Integer version;

  @OneToOne
  private User user;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CartDetail> cartDetails = new ArrayList<>();

  public List<CartDetail> getCartDetails() {
    return cartDetails;
  }

  public void setCartDetails(List<CartDetail> cartDetails) {
    this.cartDetails = cartDetails;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public Integer getId() {
    return null;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  public void addCartDetail(CartDetail cartDetail) {
    cartDetails.add(cartDetail);
    cartDetail.setCart(this);
  }

  public void removeCartDetail(CartDetail cartDetail) {
    cartDetails.remove(cartDetail);
    cartDetail.setCart(null);
  }
}
