package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {
  public static boolean exception(Map<String, Country> countries) {
    String userInput = Utils.scanner.nextLine();
    userInput = Utils.capitalizeFirstLetterOfEachWord(userInput.strip());
    if (!countries.containsKey(userInput)) {
      throw new CountryNotFoundException();
    } else {
      return true;
    }
  }
}
