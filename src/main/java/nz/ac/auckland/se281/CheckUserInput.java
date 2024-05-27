package nz.ac.auckland.se281;

import java.util.Map;

public class CheckUserInput {
  String name;
  String continent;
  String tax;

  public void exception(Map<String, Country> countries, String userInput) {
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
