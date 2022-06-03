package org.iesgrancapitan.PROGR.javafx.controls.tableview;

public class Person {

  private String fullName;
  private String gender;
  private boolean single;

  public Person(String fullName, String gender, boolean single) {
    this.fullName = fullName;
    this.gender = gender;
    this.single = single;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public boolean isSingle() {
    return single;
  }

  public void setSingle(boolean single) {
    this.single = single;
  }
}