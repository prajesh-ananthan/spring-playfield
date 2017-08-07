package io.prajesh.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Data
@Entity
public class Customer extends AbstractDomain {

  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  @Embedded
  private Address billingAddress;
  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private User user;
}