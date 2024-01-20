/* Class MyDate, contains three private fields:
 * - int day
 * - int month
 * - int year*/

import java.util.Scanner;

public class MyDate implements Comparable<MyDate>{

    // fields
    private int day;
    private int month;
    private int year;

    /**
     * constructor, requires  all fields
     * @param day the day part of a date
     * @param month  the month part of a date
     * @param year the year part of a date
     */
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * read MyDate from given string
     * @param line string to read the MyDate from
     * @return MyDate read from string
     */
    public static MyDate read(String line) {
        Scanner dateScanner = new Scanner(line).useDelimiter("-");

        int scannedDay = dateScanner.nextInt();
        int scannedMonth = dateScanner.nextInt();
        int scannedYear = dateScanner.nextInt();

        return new MyDate(scannedDay, scannedMonth, scannedYear);
    }

    /**
     *
     * @return day field
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @return month field
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @return year field
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @return human friendly representation of this object
     */
    @Override
    public String toString() {
        return "MyDate: " + day + "/" + month + "/" + year;
    }

    /**
     * equals method, check for same address, null parameter,
     * same class and same day, month and year values
     * @param other object to check equality to
     * @return boolean for equality of the objects
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MyDate that = (MyDate) other;
        return day == that.day && month == that.month && year == that.year;
    }

    /**
     * create file storing friendly string representation of this object
     * @return string representation of this object matching file format
     */
    public String stringToWrite() {
        return day + "-" + month + "-" + year;
    }

    @Override
    public int compareTo(MyDate other) {
        return (
                (this.year - other.getYear())
                        *33)
                +(
                (this.month - other.getMonth())
                        *3)
                +(this.day - other.getDay());
    }
}
