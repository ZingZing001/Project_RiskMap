package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {

  public void checkValidCountry(Map<String, Country> countries, String userInput)
      throws CountryNotFoundException {
    if (userInput == null || userInput.trim().isEmpty()) {
      MessageCli.INVALID_COUNTRY.printMessage(userInput);
      throw new CountryNotFoundException();
    }

    userInput = Utils.capitalizeFirstLetterOfEachWord(userInput);

    if (!countries.containsKey(userInput)) {
      MessageCli.INVALID_COUNTRY.printMessage(userInput);
      throw new CountryNotFoundException();
    }
  }
}
