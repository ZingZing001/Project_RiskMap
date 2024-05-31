package nz.ac.auckland.se281;

import java.util.Map;

/**
 * The {@code CheckUserInput} class provides methods to validate user input against predefined
 * criteria.
 */
public class CheckUserInput {

  /**
   * Checks if the provided user input corresponds to a valid country in the provided map. It first
   * checks if the input is null or empty, and then ensures the country exists in the map after
   * capitalizing the first letter of each word of the country name. If any check fails, an
   * appropriate message is printed and a {@code CountryNotFoundException} is thrown.
   *
   * @param countries a map of country names to {@code Country} objects, where the country names are
   *     expected to be capitalized properly as keys.
   * @param userInput the country name input by the user which needs to be validated.
   * @throws CountryNotFoundException if the input is null, empty, or does not exist in the map.
   */
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
