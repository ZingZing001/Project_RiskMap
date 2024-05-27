package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {
  private String name;
  private String continent;
  private String tax;
  private String userInput;

  public void exception(Map<String, Country> countries, String userInput) {
    if (userInput.isEmpty()) {
      throw new CountryNotFoundException();
    }
    userInput = Utils.capitalizeFirstLetterOfEachWord(userInput);
    if (!countries.containsKey(userInput)) {
      throw new CountryNotFoundException();
    } else {
      name = countries.get(userInput).getName();
      continent = countries.get(userInput).getContinent();
      tax = countries.get(userInput).getTax() + "";
      MessageCli.COUNTRY_INFO.printMessage(name, continent, tax);
    }
  }
}
