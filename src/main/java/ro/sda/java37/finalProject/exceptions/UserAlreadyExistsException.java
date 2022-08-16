package ro.sda.java37.finalProject.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String message) {
    super("User already exists. Try again.");
  }
}
