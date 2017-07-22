package io.prajesh.domain;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
public class Customer {
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String address;
  private String city;
  private String state;
  private Integer zipCode;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Customer{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append(", city='").append(city).append('\'');
    sb.append(", state='").append(state).append('\'');
    sb.append(", zipCode=").append(zipCode);
    sb.append('}');
    return sb.toString();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}