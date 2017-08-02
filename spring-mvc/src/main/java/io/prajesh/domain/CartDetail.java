package io.prajesh.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Prajesh Ananthan
 *         Created on 1/8/2017.
 */
@Data
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

}
