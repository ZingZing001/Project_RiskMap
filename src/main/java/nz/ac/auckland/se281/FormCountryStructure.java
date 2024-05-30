package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormCountryStructure {
  private Map<String, Country> Countries;

  public FormCountryStructure() {
    Countries = new HashMap<>();
  }

  public Map<String, Country> initializeCountryStructure(List<String> countries) {
    for (String CountriesLine : countries) {
      String[] splited = CountriesLine.split(",");
      String country = splited[0];
      String continent = splited[1];
      int tax = Integer.parseInt(splited[2]);
      Countries.put(country, new Country(country, continent, tax));
    }
    return Countries;
  }
}
