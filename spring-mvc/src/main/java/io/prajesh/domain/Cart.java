package io.prajesh.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 1/8/2017.
 */

@Entity
@Data
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

  @Override
  public Integer getId() {
    return id;
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
