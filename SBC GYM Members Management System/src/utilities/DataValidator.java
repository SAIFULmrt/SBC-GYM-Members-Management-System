package utilities;

import java.time.LocalDate;

import exceptions.InvalidHeightOrWeightException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import exceptions.NullException;

/*
 *  Name: Md. Saiful Islam
 *  ID: 1922071
 *  Course: CSE215L.16
 *  Instructor Name: Shaikh Shawon Arefin Shimon
 *  @date 19 Jan 2021
 */
public class DataValidator {

  public static boolean isValidData(String membershipId, LocalDate joiningDate, String firstName, String lastName,
      String nidNumber, String pathToPhoto, String address, String lifestyle, String gender, LocalDate dateOfBirth,
      String height, String weight, String phoneNumber, String email, String membershipPackage, String classSchedule)
      throws Exception {

    if (!isMembershipIdNotValid(membershipId)) {
      throw new InvalidIdException("Membership id is not valid. Membership id can contains only digit.");
    }
    if (joiningDate == null) {
      throw new NullException("Invalid joining date. Maybe you didn't pick a date?");
    }

    if (!isNameNotNull(firstName)) {
      throw new InvalidNameException(
          "firstName is not valid. Name must have at least 3 characters and can only contains letter");
    }

    if (!isNameNotNull(lastName)) {
      throw new InvalidNameException(
          "lastName is not valid. Name must have at least 3 characters and can only contains letter");
    }
    if (!isLength10Or17(nidNumber) || !isOnlyDigit(nidNumber)) {
      throw new NullException("Nid Number is not valid. Nid Number must be 10 or 17 digit, but not other lengths.");
    }
    if (pathToPhoto == null) {
      throw new NullException("Invalid path to profile picture. Maybe you didn't select a path?");
    }
    if (!isNotNullOrEmptyString(address)) {
      throw new NullException("Address is not valid. Maybe you didn't entered any address?");
    }
    if (!isNotNullOrEmptyString(lifestyle) || !isOnlyLetters(lifestyle)) {
      throw new NullException("Lifestyle is not valid. Lifestyle can contains only letter.");
    }
    if (!isNotNullOrEmptyString(gender)) {
      throw new NullException("Gender is not valid. Maybe you didn't pick a gender?");
    }
    if (dateOfBirth == null) {
      throw new NullException("Invalid date of birth. Maybe you didn't pick a date?");
    }
    if (!isDouble(weight)) {
      throw new InvalidHeightOrWeightException(weight + " kg is an invalid value for weight.");
    }

    if (!isDouble(height)) {
      throw new InvalidHeightOrWeightException(height + " cm is an invalid value for height.");
    }

    if (!isOnlyDigitAndPlusForPhoneNumber(phoneNumber) || !isLength11Or15(phoneNumber)) {
      throw new NullException("Phone number is not valid. Phone number must be 11 or 15 digit, but not other lengths.");
    }

    if (!isNotNullOrEmptyString(email)) {
      throw new NullException("Email is not valid. Email must have '.' and '@' character.");
    }
    if (!isNotNullOrEmptyString(membershipPackage)) {
      throw new NullException("Membership package is not valid. Maybe you didn't pick a package?");
    }
    if (!isNotNullOrEmptyString(classSchedule)) {
      throw new NullException("Class schedule is not valid. Maybe you didn't pick a time?");
    }

    return true;
  }

  public static boolean isMembershipIdNotValid(String value) {
    try {
      int id = Integer.parseInt(value);

      if (id <= 0) {
        return false;
      }
    } catch (Exception parseException) {
      return false;
    }
    return true;
  }

  public static boolean isNameNotNull(String value) {
    return value != null && value.length() >= 3 && isOnlyLetters(value);
  }

  public static boolean isNotNull(String value) {
    return value != null && value.length() >= 1;
  }

  public static boolean isNotNullOrEmptyString(String string) {
    return string != null && string.length() > 0;
  }

  public static boolean isOnlyLetters(String str) {
    str = str.toLowerCase();
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char ch = charArray[i];
      if (!(ch >= 'a' && ch <= 'z')) {
        return false;
      }
    }
    return true;
  }

  public static boolean isOnlyDigit(String str) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char ch = charArray[i];
      if (!(ch >= '0' && ch <= '9')) {
        return false;
      }
    }
    return true;
  }

  public static boolean isOnlyDigitAndPlusForPhoneNumber(String str) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char ch = charArray[i];
      if (!((ch >= '0' && ch <= '9') || ch == '+')) {
        return false;
      }
    }
    return true;
  }

  public static boolean isLength10Or17(String str) {
    return str != null && (str.length() == 10 || str.length() == 17);
  }

  public static boolean isLength11Or15(String str) {
    return str != null && (str.length() == 11 || str.length() == 15);
  }

  public static boolean isDouble(String supposedlyNumericData) {
    try {
      double data = Double.parseDouble(supposedlyNumericData);

      if (data <= 0) {
        return false;
      }
    } catch (Exception parseException) {
      return false;
    }

    return true;
  }

}
