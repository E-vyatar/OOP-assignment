import java.util.Scanner;

public record Address(String street, int number, String zipCode, String city) {

    /**
     * read Address from given string
     * @param line string to read the Address from
     * @return Address read from string
     */
    public static Address read(String line) {
        Scanner addressScanner = new Scanner(line).useDelimiter("; ");

        String scannedStreet = addressScanner.next();
        int scannedNumber = addressScanner.nextInt();
        String scannedZipCode = addressScanner.next();
        String scannedCity = addressScanner.next();

        return new Address(scannedStreet, scannedNumber, scannedZipCode, scannedCity);
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
     * create file storing friendly string representation of this object
     * @return string representation of this object matching file format
     */
    public String stringToWrite() {
        return street + "; " + number + "; " + zipCode + "; " + city;
    }
}
