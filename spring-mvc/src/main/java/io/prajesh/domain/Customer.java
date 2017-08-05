package io.prajesh.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Data
@Entity
public class Customer implements DomainObject {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Version
  private Integer version;

  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  @Embedded
  private Address billingAddress;

  @OneToOne
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}