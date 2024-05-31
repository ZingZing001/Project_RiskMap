package nz.ac.auckland.se281;

import java.util.Map;

/**
 * The {@code CheckUserInput} class provides methods to validate user input against predefined
 * criteria. It primarily checks if the user's input matches a valid country name from a provided
 * map.
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
      MessageCli.INVALID_COUNTRY.printMessage(
          userInput); // Print error message if input is null or empty
      throw new CountryNotFoundException(); // Throw exception indicating that the country was not
                                            // found
    }

    userInput =
        Utils.capitalizeFirstLetterOfEachWord(userInput); // Normalize the input to match map keys

    if (!countries.containsKey(userInput)) {
      MessageCli.INVALID_COUNTRY.printMessage(
          userInput); // Print error message if country is not in the map
      throw new CountryNotFoundException(); // Throw exception indicating that the country was not
                                            // found
    }
  }
}
