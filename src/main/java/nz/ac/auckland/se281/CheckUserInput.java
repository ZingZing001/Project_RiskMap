package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {
  public boolean exception(Map<String, Country> countries, String userInput) {

    if (!countries.containsKey(userInput)) {
      throw new CountryNotFoundException();
    } else {
      return true;
    }
  }
}
