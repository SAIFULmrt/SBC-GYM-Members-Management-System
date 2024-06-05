package dataclass;

import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import application.EnrollMembersInfoController;

public class Member implements Serializable {

  private static final long serialVersionUID = -5278920240631218022L;
  private int membershipId;
  private LocalDate joiningDate;
  private String firstName;
  private String lastName;
  private String nidNumber;
  private String pathToPhoto;
  private String address;
  private String lifeStyle;
  private String gender;
  private LocalDate dateOfBirth;
  private double height;
  private double weight;
  private String phoneNumber;
  private String email;
  private String membershipPackage;
  private String classSchedule;

  public Member(int membershipId, LocalDate joiningDate, String firstName, String lastName, String nidNumber,
      String pathToPhoto, String address, String lifeStyle, String gender, LocalDate dateOfBirth, double height,
      double weight, String phoneNumber, String email, String membershipPackage, String classSchedule) {
    super();
    this.membershipId = membershipId;
    this.joiningDate = joiningDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nidNumber = nidNumber;
    this.pathToPhoto = pathToPhoto;
    this.address = address;
    this.lifeStyle = lifeStyle;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.height = height;
    this.weight = weight;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.membershipPackage = membershipPackage;
    this.classSchedule = classSchedule;
  }

  public int getMembershipId() {
    return membershipId;
  }

  public void setMembershipId(int membershipId) {
    this.membershipId = membershipId;
  }

  public LocalDate getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
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

  public String getNidNumber() {
    return nidNumber;
  }

  public void setNidNumber(String nidNumber) {
    this.nidNumber = nidNumber;
  }

  public String getPathToPhoto() {
    return pathToPhoto;
  }

  public void setPathToPhoto(String pathToPhoto) {
    this.pathToPhoto = pathToPhoto;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLifeStyle() {
    return lifeStyle;
  }

  public void setLifeStyle(String lifeStyle) {
    this.lifeStyle = lifeStyle;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMembershipPackage() {
    return membershipPackage;
  }

  public void setMembershipPackage(String membershipPackage) {
    this.membershipPackage = membershipPackage;
  }

  public String getClassSchedule() {
    return classSchedule;
  }

  public void setClassSchedule(String classSchedule) {
    this.classSchedule = classSchedule;
  }

  @Override
  public String toString() {
    return "Membership ID: " + membershipId + ",   Full Name: " + firstName + " " + lastName + ",   Joining Date: " + joiningDate + ",   Gender: " + gender +
        ",   Membership Package: " + membershipPackage + ",   Class Schedule: " + classSchedule;
  }

}