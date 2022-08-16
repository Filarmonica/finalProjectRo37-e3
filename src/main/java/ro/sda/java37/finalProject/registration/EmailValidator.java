package ro.sda.java37.finalProject.registration;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailValidator implements Predicate<String> {

  final String regexPattern = "^(.+)@(\\S+)$";

  @Override
  public boolean test(String emailAddress) {
    return Pattern.compile(regexPattern)
      .matcher(emailAddress)
      .matches();
  }
}

