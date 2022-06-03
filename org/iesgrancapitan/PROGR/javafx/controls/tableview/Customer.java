package org.iesgrancapitan.PROGR.javafx.controls.tableview;

public class Customer {
  private String firstName = null;
  private String lastName = null;
  private String customerNo = null;
  private String email = null;

  public Customer() {
  }

  public Customer(String customerNo, String firstName, String lastName, String email) {
    this.customerNo = customerNo;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
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

  public String getName() {
    return (firstName + " " + lastName).toUpperCase();
  }

  public String getCustomerNo() {
    return customerNo;
  }

  public void setCustomerNo(String customerNo) {
    this.customerNo = customerNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerNo=" + customerNo + ", email="
        + email + "]";
  }

  
}
