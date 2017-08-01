package io.prajesh.domain.pojo;

import io.prajesh.domain.DomainObject;
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
  private String address;
  private String city;
  private String state;
  private Integer zipCode;

  @OneToOne
  private User user;

}