import java.util.Objects;
import java.util.Scanner;

/* Class Address, contains four private fields:
* - String street
* - int number
* - String zipCode
* - String city*/
public class AddressOriginal {

    // fields
    private String street;
    private int number;
    private String zipCode;
    private String city;

    /**
     * constructor, requires  all fields
     * @param street the street of the address
     * @param number house number of the address
     * @param zipCode zipcode of the address
     * @param city the city of the address
     */
    public AddressOriginal(String street, int number, String zipCode, String city) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * read Address from given string
     * @param line string to read the Address from
     * @return Address read from string
     */
    public static AddressOriginal read(String line) {
        Scanner addressScanner = new Scanner(line).useDelimiter("; ");

        String scannedStreet = addressScanner.next();
        int scannedNumber = addressScanner.nextInt();
        String scannedZipCode = addressScanner.next();
        String scannedCity = addressScanner.next();

        return new AddressOriginal(scannedStreet, scannedNumber, scannedZipCode, scannedCity);
    }

    /**
     *
     * @return street field
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @return number field
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @return zipCode field
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     *
     * @return city field
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return human friendly representation of this object
     */
    @Override
    public String toString() {
        return "Address: " + street + " " + number + ", " + zipCode + ", " + city;
    }

    /**
     * equals method, checks for same address, null parameter,
     * same class and same number and zipCode
     * @param other object to check equality to
     * @return boolean for equality of the objects
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        AddressOriginal that = (AddressOriginal) other;
        return number == that.number && Objects.equals(zipCode, that.zipCode);
    }

    /**
     * create file storing friendly string representation of this object
     * @return string representation of this object matching file format
     */
    public String stringToWrite() {
        return street + "; " + number + "; " + zipCode + "; " + city;
    }
}
