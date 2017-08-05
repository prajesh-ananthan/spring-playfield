package io.prajesh.domain;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @author Prajesh Ananthan
 *         Created on 5/8/2017.
 */
@Data
@Embeddable
public class Address {
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String zipCode;
}
