package nz.ac.auckland.se281;

import java.util.Map;

public class CheckIfCountryValid {
  private CheckUserInput inputChecks;

  public CheckIfCountryValid() {
    inputChecks = new CheckUserInput();
  }

  public String getValidCountry(Map<String, Country> countries) {
    String userInput = null;
    boolean validCountry = false;
    MessageCli.INSERT_COUNTRY.printMessage();
    while (!validCountry) {
      userInput = Utils.scanner.nextLine();
      try {
        userInput = userInput.strip();
        inputChecks.exception(countries, userInput, MessageCli.COUNTRY_INFO);
        validCountry = true;
      } catch (CountryNotFoundException e) {
        MessageCli.INVALID_COUNTRY.printMessage(Utils.capitalizeFirstLetterOfEachWord(userInput));
      }
    }
    return userInput;
  }
}
