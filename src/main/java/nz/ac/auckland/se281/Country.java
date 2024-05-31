package nz.ac.auckland.se281;

/**
 * The {@code Country} class represents a country with its name, continent, and tax rate. This class
 * provides methods to retrieve these properties.
 */
public class Country {
  private String name;
  private String continent;
  private int tax;

  /**
   * Constructs a new {@code Country} object with specified name, continent, and tax rate.
   *
   * @param name the name of the country.
   * @param continent the continent on which the country is located.
   * @param tax the tax rate applicable in the country.
   */
  public Country(String name, String continent, int tax) {
    this.name = name;
    this.continent = continent;
    this.tax = tax;
  }

  /**
   * Returns the name of the country.
   *
   * @return the name of the country.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the continent on which the country is located.
   *
   * @return the continent of the country.
   */
  public String getContinent() {
    return continent;
  }

  /**
   * Returns the tax rate applicable in the country.
   *
   * @return the tax rate of the country.
   */
  public int getTax() {
    return tax;
  }
}
