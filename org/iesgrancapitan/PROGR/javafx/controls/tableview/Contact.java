package org.iesgrancapitan.PROGR.javafx.controls.tableview;

public class Contact {

  private String firstName = null;
  private String lastName = null;
  private String phoneNumber = null;

  public Contact() {
  }

  public Contact(String firstName, String lastName, String phoneNumber) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.setPhoneNumber(phoneNumber);
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
  }

  
 
}