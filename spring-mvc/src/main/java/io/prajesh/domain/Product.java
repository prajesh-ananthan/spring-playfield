package io.prajesh.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Prajesh Ananthan
 *         Created on 21/7/2017.
 */
@Data
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

}