package exceptions;

public class NullException extends Exception {

  private static final long serialVersionUID = -7447420302339975320L;

  public NullException() {
    super();
  }

  public NullException(String message) {
    super(message);
  }
}
