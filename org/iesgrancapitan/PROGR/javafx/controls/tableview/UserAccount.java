package org.iesgrancapitan.PROGR.javafx.controls.tableview;

public class UserAccount {

  private Long id;
  private String userName;
  private String email;
  private String firstName;
  private String lastName;
  private boolean active;

  public UserAccount(Long id, String userName, String email, //
      String firstName, String lastName, boolean active) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.active = active;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
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

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
