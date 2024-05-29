package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {
  private String name;
  private String continent;
  private String tax;

  public void exception(Map<String, Country> countries, String userInput, MessageCli messageCli)
      throws CountryNotFoundException {
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
      messageCli.printMessage(name, continent, tax);
    }
  }
}
