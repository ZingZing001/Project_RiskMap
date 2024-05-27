package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {
  private String name;
  private String continent;
  private String tax;
  private String userInput;

  public void exception(Map<String, Country> countries) {
    userInput = Utils.scanner.nextLine();
    userInput = Utils.capitalizeFirstLetterOfEachWord(userInput.strip());
    if (!countries.containsKey(userInput)) {
      MessageCli.INVALID_COUNTRY.printMessage(userInput);
      throw new CountryNotFoundException();
    } else {
      name = countries.get(userInput).getName();
      continent = countries.get(userInput).getContinent();
      tax = countries.get(userInput).getTax() + "";
      MessageCli.COUNTRY_INFO.printMessage(name, continent, tax);
    }
  }
}
