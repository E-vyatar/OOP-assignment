import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void constructorNotNullTest() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertNotNull(a);
    }

    @Test
    void getStreet() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals("Sint Olofslaan", a.street());
    }

    @Test
    void getNumber() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals(14, a.number());
    }

    @Test
    void getZipCode() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals("2613EJ", a.zipCode());
    }

    @Test
    void getCity() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals("Delft", a.city());
    }

    @Test
    void testToString() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals("Address: Sint Olofslaan 14, 2613EJ, Delft", a.toString());
    }

    @Test
    void testEqualsSameAddress() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals(a, a);
    }

    @Test
    void testEquals() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        Address b = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentNumber() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        Address b = new Address("Sint Olofslaan", 37, "2613EJ", "Delft");
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentZipcode() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        Address b = new Address("Sint Olofslaan", 14, "2497DV", "Delft");
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsNull() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertNotEquals(null, a);
    }
}