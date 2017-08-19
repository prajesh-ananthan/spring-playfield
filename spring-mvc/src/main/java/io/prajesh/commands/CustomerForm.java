package io.prajesh.commands;

/**
 * @author Prajesh Ananthan
 *         Created on 18/8/2017.
 */
public class CustomerForm {

  private Integer userId;
  private Integer userVersion;
  private Integer customerId;
  private Integer customerVersion;
  private String userName;
  private String passwordText;
  private String passwordTextConfirm;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getUserVersion() {
    return userVersion;
  }

  public void setUserVersion(Integer userVersion) {
    this.userVersion = userVersion;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getCustomerVersion() {
    return customerVersion;
  }

  public void setCustomerVersion(Integer customerVersion) {
    this.customerVersion = customerVersion;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPasswordText() {
    return passwordText;
  }

  public void setPasswordText(String passwordText) {
    this.passwordText = passwordText;
  }

  public String getPasswordTextConfirm() {
    return passwordTextConfirm;
  }

  public void setPasswordTextConfirm(String passwordTextConfirm) {
    this.passwordTextConfirm = passwordTextConfirm;
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
}