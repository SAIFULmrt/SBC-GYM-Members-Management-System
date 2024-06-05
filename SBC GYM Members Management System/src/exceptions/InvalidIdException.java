package exceptions;

/*
 *  Name: Md. Saiful Islam
 *  ID: 1922071
 *  Course: CSE215L.16
 *  Instructor Name: Shaikh Shawon Arefin Shimon
 *  @date 19 Jan 2021
 */
public class InvalidIdException extends Exception {

  private static final long serialVersionUID = 4066261464135840840L;

  public InvalidIdException() {
    super();
  }

  public InvalidIdException(String message) {
    super(message);
  }
}
